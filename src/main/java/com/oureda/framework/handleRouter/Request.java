package com.oureda.framework.handleRouter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by webhugo on 17-5-10.
 */
public class Request {
    public String requestPath;
    public String requestMethod;

    public Request(String requestPath, String requestMethod) {
        this.requestPath = requestPath;
        this.requestMethod = requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }



    @Override
    public int hashCode() {
        return this.requestMethod.hashCode()+this.requestPath.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestPath='" + requestPath + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                '}';
    }
}
