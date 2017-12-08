package com.tiza.web.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Description: Connector
 * Author: DIYILIU
 * Update: 2017-12-07 14:12
 */
public class Connector {

    @JsonIgnore
    private Long id;
    private String connectorID;
    private String connectorName;
    private Integer connectorType;
    private Integer voltageUpperLimits;
    private Integer voltageLowerLimits;
    private Integer nationalStandard;
    private Double current;
    private Double power;
    private String parkNo;

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

    public Integer getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(Integer connectorType) {
        this.connectorType = connectorType;
    }

    public Integer getVoltageUpperLimits() {
        return voltageUpperLimits;
    }

    public void setVoltageUpperLimits(Integer voltageUpperLimits) {
        this.voltageUpperLimits = voltageUpperLimits;
    }

    public Integer getVoltageLowerLimits() {
        return voltageLowerLimits;
    }

    public void setVoltageLowerLimits(Integer voltageLowerLimits) {
        this.voltageLowerLimits = voltageLowerLimits;
    }

    public Integer getNationalStandard() {
        return nationalStandard;
    }

    public void setNationalStandard(Integer nationalStandard) {
        this.nationalStandard = nationalStandard;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo;
    }
}
