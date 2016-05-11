package com.iidooo.cms.controller;

import java.io.File;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aliyun.oss.OSSClient;
import com.iidooo.aliyun.util.OSSUtil;
import com.iidooo.cms.enums.FileType;
import com.iidooo.cms.service.UploadService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
import com.iidooo.core.service.HisOperatorService;
import com.iidooo.core.util.DateUtil;
import com.iidooo.core.util.FileUtil;
import com.iidooo.core.util.PictureUtil;
import com.iidooo.core.util.StringUtil;
import com.iidooo.core.util.ValidateUtil;

@Controller
public class UploadController {
    private static final Logger logger = Logger.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;

    @Autowired
    private HisOperatorService hisOperatorService;

    @ResponseBody
    @RequestMapping(value = { "/uploadFile", "/admin/uploadFile" }, method = RequestMethod.POST)
    public ResponseResult uploadFile(HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = new ResponseResult();
        try {
            ServletContext sc = request.getServletContext();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");
            String fileType = multipartRequest.getParameter("fileType");

            // 验证必填项和格式
            if (file == null) {
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "file");
                result.getMessages().add(message);
            }

            if (StringUtil.isBlank(fileType)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldRequired.getCode(), MessageLevel.WARN, "fileType");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            } else if (!ValidateUtil.isNumber(fileType)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.FieldNumberRequired.getCode(), MessageLevel.WARN, "fileType");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            if (result.getMessages().size() > 0) {
                // 验证失败，返回message
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            // 保存上传的文件到服务器的既定路径下
            Properties systemProperties = (Properties) sc.getAttribute("system.properties");
            String uploadFolderPath = systemProperties.getProperty("SERVER_UPLOAD_FOLDER");
            String yearMonth = DateUtil.getNow(DateUtil.DATE_YEAR_MONTH_SIMPLE);
            uploadFolderPath = uploadFolderPath + File.separator + yearMonth;

            // 写出文件到指定路径下
            String fileName = file.getOriginalFilename();
            if (StringUtil.isBlank(fileName)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.Exception.getCode(), MessageLevel.ERROR, "file.getOriginalFilename()");
                message.setDescription("The file name is blank by invoke getOriginalFilename.");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            String suffix = FileUtil.getFileSuffix(fileName);

            // fileName = FileUtil.changeFileName(fileName, DateUtil.DATE_TIME_FULL_SIMPLE);
            String nowStr = DateUtil.getNow(DateUtil.DATE_TIME_FULL_SIMPLE);
            String uploadFilePath = FileUtil.save(file.getBytes(), uploadFolderPath, nowStr + "." + suffix);
            if (StringUtil.isBlank(uploadFilePath)) {
                // 验证失败，返回message
                Message message = new Message(MessageType.Exception.getCode(), MessageLevel.ERROR, "uploadFilePath");
                message.setDescription("Save file to server failed.");
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
                return result;
            }

            if (PictureUtil.isImage(uploadFilePath)) {
                if (fileType.equals(FileType.UserPhoto.getCode())) {
                    PictureUtil.MaintainOrientation(uploadFilePath);
                    PictureUtil.cutSquare(uploadFilePath, uploadFilePath);
                    PictureUtil.compress(uploadFilePath, uploadFilePath, 200, 200, false);
                } else if (fileType.equals(FileType.NewsPicture.getCode())) {
                    PictureUtil.MaintainOrientation(uploadFilePath);
                    PictureUtil.compress(uploadFilePath, uploadFilePath, 500, 500, true);
                } else if (fileType.equals(FileType.ContentPicture.getCode())) {
                    PictureUtil.MaintainOrientation(uploadFilePath);
                    PictureUtil.compress(uploadFilePath, uploadFilePath, 1000, 1000, true);
                }
            }

            // 把文件上传到阿里云OSS的既定路径下
            Properties aliyunProperties = (Properties) sc.getAttribute("aliyun.properties");

            OSSClient ossClient = OSSUtil.getOSSClient(aliyunProperties);
            String newKeyURL = OSSUtil.uploadFile(aliyunProperties, ossClient, yearMonth + "/", uploadFilePath);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("url", newKeyURL);

            result.setStatus(ResponseStatus.OK.getCode());
            result.setData(jsonObject);

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
            if (e instanceof MaxUploadSizeExceededException) {
                Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL, "");
                message.setDescription("MaxUploadSizeExceededException and the file size should be less than "
                        + ((MaxUploadSizeExceededException) e).getMaxUploadSize());
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.MaxUploadSizeExceededException.getCode());
            } else {
                Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
                message.setDescription(e.toString());
                result.getMessages().add(message);
                result.setStatus(ResponseStatus.Failed.getCode());
            }
        }
        return result;
    }
}
