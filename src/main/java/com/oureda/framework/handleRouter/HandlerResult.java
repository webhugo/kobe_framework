package com.oureda.framework.handleRouter;

import com.oureda.framework.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by webhugo on 17-5-11.
 */
public class HandlerResult {
    public static void handleResult(Object result, HttpServletRequest request,
                                    HttpServletResponse response) {
        if (result instanceof Data) {
            Object data = ((Data) result).getData();
            if (data != null) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String json = JsonUtil.toJson(data);
                PrintWriter printWriter = null;
                try {
                    printWriter = response.getWriter();
                    printWriter.write("json");
                    printWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (printWriter != null)
                        printWriter.close();
                }

            }
        } else if (result instanceof View) {

        }
    }
}
