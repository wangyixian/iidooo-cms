package com.iidooo.cms.controller;

import java.io.File;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.aliyun.oss.OSSClient;
import com.iidooo.aliyun.util.OSSUtil;
import com.iidooo.cms.constant.PropertyKey;
import com.iidooo.cms.enums.FileType;
import com.iidooo.cms.service.HisOperatorService;
import com.iidooo.cms.service.UploadService;
import com.iidooo.core.enums.MessageLevel;
import com.iidooo.core.enums.MessageType;
import com.iidooo.core.enums.ResponseStatus;
import com.iidooo.core.model.Message;
import com.iidooo.core.model.ResponseResult;
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

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody ResponseResult uploadFile(HttpServletRequest request, HttpServletResponse response) {
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
            String uploadFolderPath = (String) sc.getAttribute(PropertyKey.SERVER_UPLOAD_FOLDER);
            String yearMonth = DateUtil.getNow(DateUtil.DATE_YEAR_MONTH_SIMPLE);
            uploadFolderPath = uploadFolderPath + File.separator + yearMonth;

            // 写出文件到指定路径下
            String fileName = file.getOriginalFilename();
            fileName = FileUtil.getUniqueFileName(fileName);
            String uploadFilePath = FileUtil.save(file.getBytes(), uploadFolderPath, fileName);

            String newFilePath = FileUtil.getNewFileName(uploadFilePath, "_mini");
            if (fileType.equals(FileType.UserPhoto.getCode())) {
                PictureUtil.cutSquare(uploadFilePath, newFilePath);
                PictureUtil.compress(newFilePath, newFilePath, 200, 200, false);
            } else if (fileType.equals(FileType.NewsPicture.getCode())) {
                PictureUtil.compress(uploadFilePath, newFilePath, 500, 500, true);
            } else {
                PictureUtil.compress(uploadFilePath, newFilePath, 1000, 1000, true);
            }

            // 把文件上传到阿里云OSS的既定路径下
            String domain = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_DOMAIN);
            String endpoint = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_END_POINT);
            String accessKeyId = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_ACCESS_KEY_ID);
            String accessKeySecret = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_ACCESS_KEY_SECRET);
            String bucketName = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_BUCKET_NAME);

            OSSClient ossClient = OSSUtil.getOSSClient(endpoint, accessKeyId, accessKeySecret);
            String newKey = OSSUtil.uploadFile(ossClient, bucketName, yearMonth + "/", newFilePath);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("url", domain + newKey);

            result.setStatus(ResponseStatus.OK.getCode());
            result.setData(jsonObject);

        } catch (Exception e) {
            logger.fatal(e);
            Message message = new Message(MessageType.Exception.getCode(), MessageLevel.FATAL);
            message.setDescription(e.getMessage());
            result.getMessages().add(message);
            result.setStatus(ResponseStatus.Failed.getCode());
        }
        return result;
    }
}
