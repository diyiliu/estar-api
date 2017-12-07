package com.tiza.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * Description: Equipment
 * Author: DIYILIU
 * Update: 2017-12-07 14:15
 */
public class Equipment {

    @JsonIgnore
    private Long id;

    private String equipmentID;
    private String manufacturerID;
    private String equipmentModel;
    private String productionDate;
    private Integer equipmentType;
    private Double power;
    private String equipmentName;
    private List<Connector> connectorInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Integer equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public List<Connector> getConnectorInfos() {
        return connectorInfos;
    }

    public void setConnectorInfos(List<Connector> connectorInfos) {
        this.connectorInfos = connectorInfos;
    }
}
