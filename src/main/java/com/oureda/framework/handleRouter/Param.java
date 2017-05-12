package com.oureda.framework.handleRouter;

import java.util.Map;

/**
 * Created by webhugo on 17-5-11.
 */
public class Param {
    private Map<String,Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Param(Map<String, Object> map) {
        this.map = map;
    }
}
