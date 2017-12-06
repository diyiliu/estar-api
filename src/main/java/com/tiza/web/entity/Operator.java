package com.tiza.web.entity;

/**
 * Description: Operator
 * Author: DIYILIU
 * Update: 2017-12-06 10:25
 */
public class Operator {

    private Long id;

    private String operatorId;

    private String name;

    private String secret;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "id=" + id +
                ", operatorId='" + operatorId + '\'' +
                ", name='" + name + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
