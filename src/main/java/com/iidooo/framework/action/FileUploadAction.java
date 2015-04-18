package com.iidooo.framework.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.json.simple.JSONObject;

import com.iidooo.core.action.BaseAction;
import com.iidooo.framework.constant.DictConstant;

/**
 * This action is for upload files
 * 
 * @author Ethan
 *
 */
public class FileUploadAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(FileUploadAction.class);

    private String dir;

    private File imgFile;

    private String imgFileContentType;

    private String imgFileFileName;

    private String localUrl;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public String getImgFileContentType() {
        return imgFileContentType;
    }

    public void setImgFileContentType(String imgFileContentType) {
        this.imgFileContentType = imgFileContentType;
    }

    public String getImgFileFileName() {
        return imgFileFileName;
    }

    public void setImgFileFileName(String imgFileFileName) {
        this.imgFileFileName = imgFileFileName;
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public void upload() {
        try {
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpServletResponse response = ServletActionContext.getResponse();
            PrintWriter out = response.getWriter();
            
            // 文件保存目录路径
            String savePath = ServletActionContext.getServletContext().getRealPath("/") + "attached/";

            // 文件保存目录URL
            String saveUrl = request.getContextPath() + "/attached/";

            // 定义允许上传的文件扩展名
            HashMap<String, String> extMap = new HashMap<String, String>();
            extMap.put("image", "gif,jpg,jpeg,png,bmp");
            extMap.put("flash", "swf,flv");
            extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
            extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

            // 最大文件大小
            Object maxSizeObj = this.getApplicationValue(DictConstant.DICT_ITEM_UPLOAD_MAX_SIZE);
            long maxSize = 1000000;
            if (maxSizeObj != null && maxSizeObj instanceof String) {
                maxSize = Long.parseLong((String)maxSizeObj);
            }

            response.setContentType("text/html; charset=UTF-8");

            if (!ServletFileUpload.isMultipartContent(request)) {
                out.println(getError("请选择文件。"));
                return;
            }
            // 检查目录
            File uploadDir = new File(savePath);
            if (!uploadDir.isDirectory()) {
                out.println(getError("上传目录不存在。"));
                return;
            }
            // 检查目录写权限
            if (!uploadDir.canWrite()) {
                out.println(getError("上传目录没有写权限。"));
                return;
            }

            String dirName = request.getParameter("dir");
            if (dirName == null) {
                dirName = "image";
            }
            if (!extMap.containsKey(dirName)) {
                out.println(getError("目录名不正确。"));
                return;
            }
            // 创建文件夹
            savePath += dirName + "/";
            saveUrl += dirName + "/";
            File saveDirFile = new File(savePath);
            if (!saveDirFile.exists()) {
                saveDirFile.mkdirs();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(new Date());
            savePath += ymd + "/";
            saveUrl += ymd + "/";
            File dirFile = new File(savePath);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }

            MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) ServletActionContext.getRequest();
            String newFileName = wrapper.getFileNames("imgFile")[0];
            File file = wrapper.getFiles("imgFile")[0];
            
            if (file.length() > maxSize) {
                out.println(getError("上传文件大小超过限制。"));
                return;
            }
                
            saveUrl += newFileName;

            FileOutputStream fos = new FileOutputStream(savePath + newFileName);
            byte[] buffer = new byte[1024];
            InputStream in = new FileInputStream(file);

            try {
                int num = 0;
                while ((num = in.read(buffer)) > 0) {
                    fos.write(buffer, 0, num);
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
            } finally {
                try {
                    if (in != null)
                        in.close();
                    if (fos != null)
                        fos.close();
                } catch (IOException e) {
                }
            }

            JSONObject obj = new JSONObject();
            obj.put("error", 0);
            obj.put("url", saveUrl);
            out.println(obj.toJSONString());

            // FileItemFactory factory = new DiskFileItemFactory();
            // ServletFileUpload upload = new ServletFileUpload(factory);
            // upload.setHeaderEncoding("UTF-8");
            // List items = upload.parseRequest(request);
            // Iterator itr = items.iterator();
            // while (itr.hasNext()) {
            // FileItem item = (FileItem) itr.next();
            // String fileName = item.getName();
            // long fileSize = item.getSize();
            // if (!item.isFormField()) {
            // // 检查文件大小
            // if (item.getSize() > maxSize) {
            // out.println(getError("上传文件大小超过限制。"));
            // return;
            // }
            // // 检查扩展名
            // String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
            // if (!Arrays.<String> asList(extMap.get(dirName).split(",")).contains(fileExt)) {
            // out.println(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
            // return;
            // }
            //
            // SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            // String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
            // try {
            // File uploadedFile = new File(savePath, newFileName);
            // item.write(uploadedFile);
            // } catch (Exception e) {
            // out.println(getError("上传文件失败。"));
            // return;
            // }
            //
            // JSONObject obj = new JSONObject();
            // obj.put("error", 0);
            // obj.put("url", saveUrl + newFileName);
            // out.println(obj.toJSONString());
            // }
            // }
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        }
    }

    private String getError(String message) {
        JSONObject obj = new JSONObject();
        obj.put("error", 1);
        obj.put("message", message);
        return obj.toJSONString();
    }
}
