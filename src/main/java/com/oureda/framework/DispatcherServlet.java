package com.oureda.framework;

import com.google.gson.Gson;
import com.oureda.framework.config.Config;
import com.oureda.framework.handleRouter.Handler;
import com.oureda.framework.handleRouter.HandlerResult;
import com.oureda.framework.handleRouter.Param;
import com.oureda.framework.handleRouter.RequestParamHelper;
import com.oureda.framework.load.InitController;
import com.oureda.framework.load.LoadAllBean;
import com.oureda.framework.util.ClassUtil;
import com.oureda.framework.util.ReflectUtil;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by webhugo on 17-5-10.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        Init.init();

        ServletContext servletContext = servletConfig.getServletContext();

        registerServlet(servletContext);

    }

    private void registerServlet(ServletContext servletContext) {
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping("/index.jsp");
        jspServlet.addMapping(Config.map.get(Config.JSP_PATH) + "*");

        RequestParamHelper.init(servletContext);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String requestMethod = request.getMethod().toUpperCase();
            String requestPath = request.getRequestURI();

            Param param = null;

            try {
                param = RequestParamHelper.createParam(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            Handler handler = InitController.getHandler(requestMethod, requestPath);

            if (handler != null) {
                Class<?> controllerClass = handler.getControllerClass();
                Object controllerBean = InitController.getController(controllerClass);

                Object result;
                Method actionMethod = handler.getMethod();
                if (actionMethod.getParameterTypes().length != 0) {
                    result = ReflectUtil.invokeMethod(controllerBean, actionMethod, param);
                } else {
                    result = ReflectUtil.invokeMethod(controllerBean, actionMethod);
                }
                if (result != null) {
                    HandlerResult.handleResult(result, request, response);
                }

            }
        } finally {

        }
    }

}
