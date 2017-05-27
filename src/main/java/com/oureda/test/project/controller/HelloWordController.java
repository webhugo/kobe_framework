package com.oureda.test.project.controller;

import com.oureda.framework.annotation.Controller;
import com.oureda.framework.annotation.Inject;
import com.oureda.framework.annotation.Routing;
import com.oureda.framework.handleRouter.*;
import com.oureda.test.project.service.HelloService;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by webhugo on 17-5-10.
 */
@Controller
public class HelloWordController {
    @Inject
    private HelloService helloService;

    @Routing(value = "/data", method = Routing.METHOD.GET)
    public Data data() {
        helloService.sayHello();
        Data data = new Data();
        data.setData("data");
        return data;
    }


    @Routing(value = "/view", method = Routing.METHOD.GET)
    public View view(Param param) {
        List<FormParam> formParamList = param.getFormParamList();
        for (FormParam formParam : formParamList) {
        }
        helloService.sayHello();
        View view = new View();
        view.setPath("index.jsp");
        Map<String, Object> map = new HashMap<>();
        map.put("test", "test");
        view.setModel(map);
        return view;
    }


    @Routing(value = "/jsp", method = Routing.METHOD.GET)
    public View view() {
        // TODO 17-5-12
        return new View("upload.jsp");
    }

    @Routing(value = "/upload", method = Routing.METHOD.POST)
    public View upload(Param param) throws IOException {
        // TODO 17-5-12
        List<FileParam> fileParamList = param.getFileParamList();
        return new View("index.jsp");
    }
}
