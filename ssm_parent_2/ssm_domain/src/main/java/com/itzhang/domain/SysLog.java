package com.itzhang.domain;

import java.util.Date;

/**
 * 创建实体类
 */
public class SysLog {

    private Long id;
    private Date visitTime;
    private String username;
    private String ip;
    //method为类名+方法名
    private String method;

    private String executeResult;
    private String executeMsg;
    private Long executeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }

    public String getExecuteMsg() {
        return executeMsg;
    }

    public void setExecuteMsg(String executeMsg) {
        this.executeMsg = executeMsg;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }
}
