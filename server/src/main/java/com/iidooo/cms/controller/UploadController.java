package com.iidooo.cms.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.iidooo.cms.service.UploadService;
import com.iidooo.core.util.FileUtil;
import com.iidooo.core.util.StringUtil;

@Controller
public class UploadController {
    private static final Logger logger = Logger.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody String uploadFile(HttpServletRequest request, HttpServletResponse response) {
        try {

            ServletContext sc = request.getServletContext();

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");
            String fileType = multipartRequest.getParameter("fileType");

            // 保存上传的文件到服务器的既定路径下
            String uploadFolderPath = "";
            if (StringUtil.isNotBlank(fileType) && fileType.equals(FileType.UserPhoto.getValue())) {
                uploadFolderPath = (String) sc.getAttribute(PropertyKey.FILE_PATH_UPLOAD_USER_PHOTO);
            } else {
                uploadFolderPath = (String) sc.getAttribute(PropertyKey.FILE_PATH_UPLOAD_CONTENT_PICTURE);
            }

            String fileName = file.getOriginalFilename();
            String newFilePath = FileUtil.save(file.getBytes(), uploadFolderPath, FileUtil.getUniqueFileName(fileName));

            // 把文件上传到阿里云OSS的既定路径下
            String domain = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_DOMAIN);
            String endpoint = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_END_POINT);
            String accessKeyId = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_ACCESS_KEY_ID);
            String accessKeySecret = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_ACCESS_KEY_SECRET);
            String bucketName = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_BUCKET_NAME);
            String key = "";
            if (StringUtil.isNotBlank(fileType) && fileType.equals(FileType.UserPhoto.getValue())) {
                key = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_FOLDER_PHOTO);
            } else {
                key = (String) sc.getAttribute(PropertyKey.ALIYUN_OSS_FOLDER_CONTENT);
            }
            OSSClient ossClient = OSSUtil.getOSSClient(endpoint, accessKeyId, accessKeySecret);
            String newKey = OSSUtil.uploadFile(ossClient, bucketName, key, newFilePath);
            return domain + newKey;
        } catch (Exception e) {
            logger.fatal(e);
            return "";
        }
    }
}
