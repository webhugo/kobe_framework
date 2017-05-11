package com.oureda.project.controller;

import com.oureda.framework.annotation.Controller;
import com.oureda.framework.annotation.Inject;
import com.oureda.framework.annotation.Routing;
import com.oureda.framework.handleRouter.Data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by webhugo on 17-5-10.
 */
@Controller
public class HelloWord{
    @Inject
    private HelloService helloService;

    @Routing(value = "/index",method = Routing.METHOD.GET)
    public Data index(){
        helloService.sayHello();
        Data data = new Data();
        data.setData("data");
        return data;
    }

}
