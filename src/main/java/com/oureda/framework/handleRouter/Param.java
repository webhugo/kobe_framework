package com.oureda.framework.handleRouter;

import java.util.List;
import java.util.Map;

/**
 * Created by webhugo on 17-5-11.
 */
public class Param {
    List<FileParam> fileParamList;
    List<FormParam> formParamList;

    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

    public Param(List<FileParam> fileParamList, List<FormParam> formParamList) {
        this.fileParamList = fileParamList;
        this.formParamList = formParamList;
    }

    public List<FileParam> getFileParamList() {
        return fileParamList;
    }

    public void setFileParamList(List<FileParam> fileParamList) {
        this.fileParamList = fileParamList;
    }

    public List<FormParam> getFormParamList() {
        return formParamList;
    }

    public void setFormParamList(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }
}
