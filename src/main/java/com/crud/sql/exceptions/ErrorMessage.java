package com.crud.sql.exceptions;

public class ErrorMessage {

    private String path;
    private String method;
    private Integer status;
    private String message;

    public ErrorMessage(){}

    public ErrorMessage(String path, String method, Integer status, String message) {
        this.path = path;
        this.method = method;
        this.status = status;
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
