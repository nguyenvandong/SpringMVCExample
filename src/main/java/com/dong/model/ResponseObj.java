package com.dong.model;

import java.util.Map;

/**
 * Created by DONG on 9/28/2017.
 */
public class ResponseObj {
    private String statusCode;
    private Map<String, Object> header;
    private Map<String, Object> body;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, Object> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Object> header) {
        this.header = header;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
