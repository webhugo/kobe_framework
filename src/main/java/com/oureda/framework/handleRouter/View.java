package com.oureda.framework.handleRouter;

import java.util.Map;

/**
 * Created by webhugo on 17-5-11.
 */
public class View {
    private String path;
    private Map<String,Object> model;

    public View() {
    }

    public View(String path) {
        this.path = path;
    }

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "View{" +
                "path='" + path + '\'' +
                ", model=" + model +
                '}';
    }
}
