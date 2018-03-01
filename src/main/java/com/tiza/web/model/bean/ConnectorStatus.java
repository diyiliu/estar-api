package com.tiza.web.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Description: ConnectorStatus
 * Author: DIYILIU
 * Update: 2018-02-28 16:00
 */
public class ConnectorStatus {

    @JsonIgnore
    private Long id;

    private String connectorID;

    private Integer status;

    private Integer parkStatus;

    private Integer LockStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(Integer parkStatus) {
        this.parkStatus = parkStatus;
    }

    public Integer getLockStatus() {
        return LockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        LockStatus = lockStatus;
    }
}
