package com.tiza.web.model;

/**
 * Description: Token
 * Author: DIYILIU
 * Update: 2017-12-27 11:18
 */
public class Token {

    private String token;
    private String operatorId;
    private Long datetime;
    private Long tokenAvailableTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Long getDatetime() {
        return datetime;
    }

    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

    public Long getTokenAvailableTime() {
        return tokenAvailableTime;
    }

    public void setTokenAvailableTime(Long tokenAvailableTime) {
        this.tokenAvailableTime = tokenAvailableTime;
    }
}

