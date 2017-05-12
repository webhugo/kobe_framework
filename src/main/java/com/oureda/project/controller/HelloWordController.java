package com.oureda.project.controller;

import com.oureda.framework.annotation.Controller;
import com.oureda.framework.annotation.Inject;
import com.oureda.framework.annotation.Routing;
import com.oureda.framework.handleRouter.Data;
import com.oureda.framework.handleRouter.Param;
import com.oureda.framework.handleRouter.View;
import com.oureda.project.service.HelloService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by webhugo on 17-5-10.
 */
@Controller
public class HelloWordController {
    @Inject
    private HelloService helloService;

    @Routing(value = "/data",method = Routing.METHOD.GET)
    public Data data(){
        helloService.sayHello();
        Data data = new Data();
        data.setData("data");
        return data;
    }


    @Routing(value = "/view",method = Routing.METHOD.GET)
    public View view(Param param){
        System.out.println("param: "+param.getMap());
        helloService.sayHello();
        View view = new View();
        view.setPath("index.jsp");
        Map<String,Object> map = new HashMap<>();
        map.put("test","test");
        view.setModel(map);
        System.out.println(view);
        return view;
    }

}
