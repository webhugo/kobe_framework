package com.oureda.framework;

import com.google.gson.Gson;
import com.oureda.framework.handleRouter.Handler;
import com.oureda.framework.handleRouter.HandlerResult;
import com.oureda.framework.load.InitController;
import com.oureda.framework.load.LoadAllBean;
import com.oureda.framework.util.ClassUtil;
import com.oureda.framework.util.ReflectUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by webhugo on 17-5-10.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Init.init();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String requestMethod = request.getMethod().toUpperCase();
            String requestPath = request.getPathInfo();
            Handler handler = InitController.getHandler(requestMethod, requestPath);
            System.out.println(handler);
            if (handler != null) {
                Class<?> controllerClass = handler.getControllerClass();
                Object controllerBean = InitController.getController(controllerClass);

                Object result;
                Method actionMethod = handler.getMethod();

                result = ReflectUtil.invokeMethod(controllerBean, actionMethod);
                if (result != null)
                    HandlerResult.handleResult(result, request, response);
            }
        } finally {
            System.out.println("destroy");
        }
    }
}
