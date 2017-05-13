package com.oureda.framework.handleRouter;

import com.oureda.framework.config.Config;
import com.oureda.framework.util.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by webhugo on 17-5-12.
 */
public class RequestParamHelper {
    private static ServletFileUpload servletFileUpload;

    public static void init(ServletContext servletContext) {
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        servletFileUpload = new ServletFileUpload(new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repository));
        int uploadLimit = Integer.valueOf(Config.map.get(Config.FILE_UPLOAD_LIMIT));
        if (uploadLimit != 0) {
            servletFileUpload.setFileSizeMax(uploadLimit * 1024 * 1024);
        }
    }

    public static Param createParam(HttpServletRequest request) throws IOException, FileUploadException {
        Param param = null;
        //判断是否是文件上传
        if (ServletFileUpload.isMultipartContent(request)) {
            param = createFileParam(request);
        }else{
            param = createFormParam(request);
        }
        return param;
    }


    public static Param createFileParam(HttpServletRequest request) throws FileUploadException, IOException {
        List<FormParam> formParamList = new ArrayList<FormParam>();
        List<FileParam> fileParamList = new ArrayList<FileParam>();
        Map<String, List<FileItem>> map = servletFileUpload.parseParameterMap(request);
        for (Map.Entry<String, List<FileItem>> fileItemEntry : map.entrySet()) {
            String fieldName = fileItemEntry.getKey();
            List<FileItem> fileItemList = fileItemEntry.getValue();
            for (FileItem fileItem : fileItemList) {
                if (fileItem.isFormField()) {
                    String fieldValue = fileItem.getString("UTF-8");
                    formParamList.add(new FormParam(fieldName, fieldValue));
                } else {
                    String fileName = FileUtil.getRealFileName(new String(fileItem.getName().getBytes(), "UTF-8"));
                    if (fieldName != null) {
                        long fileSize = fileItem.getSize();
                        String contentType = fileItem.getContentType();
                        InputStream inputSteam = fileItem.getInputStream();
                        fileParamList.add(new FileParam(fieldName, fileName, fileSize, contentType, inputSteam));
                    }
                }
            }
        }
        return new Param(fileParamList, formParamList);
    }

    public static Param createFormParam(HttpServletRequest request){
        List<FormParam> formParamList = new ArrayList<FormParam>();
        formParamList.addAll(parseParameterNames(request));
        return new Param(formParamList);
    }

    private static List<FormParam> parseParameterNames(HttpServletRequest request){
        List<FormParam> formParamList = new ArrayList<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String fieldName = parameterNames.nextElement();
            String fieldValue = request.getParameter(fieldName);
            formParamList.add(new FormParam(fieldName,fieldValue));
        }
        return formParamList;
    }

}
