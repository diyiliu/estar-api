package com.tiza.web.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: StationInfo
 * Author: DIYILIU
 * Update: 2017-12-07 14:01
 */
public class StationInfo {

    @JsonIgnore
    private Long id;

    private String operatorID;
    private String stationID;
    private String equipmentOwnerID;

    private String stationName;
    private String countryCode = "CN";
    private String areaCode;
    private String address;

    private String stationTel;
    private String serviceTel;
    private Integer stationType;
    private Integer stationStatus;
    private Integer parkNums;

    private Double stationLng;
    private Double stationLat;
    private String siteGuide;
    private Integer construction;
    // 暂时无内容
    private List<String> pictures = new ArrayList();
    private String matchCars;
    private String parkInfo;
    private String busineHours;
    private String electricityFee;
    private String serviceFee;
    private String parkFee;
    private String payment;
    private Integer supportOrder;
    private String remark;
    private List<Equipment> equipmentInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getEquipmentOwnerID() {
        return equipmentOwnerID;
    }

    public void setEquipmentOwnerID(String equipmentOwnerID) {
        this.equipmentOwnerID = equipmentOwnerID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public Integer getStationType() {
        return stationType;
    }

    public void setStationType(Integer stationType) {
        this.stationType = stationType;
    }

    public Integer getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(Integer stationStatus) {
        this.stationStatus = stationStatus;
    }

    public Integer getParkNums() {
        return parkNums;
    }

    public void setParkNums(Integer parkNums) {
        this.parkNums = parkNums;
    }

    public Double getStationLng() {
        return stationLng;
    }

    public void setStationLng(Double stationLng) {
        this.stationLng = stationLng;
    }

    public Double getStationLat() {
        return stationLat;
    }

    public void setStationLat(Double stationLat) {
        this.stationLat = stationLat;
    }

    public Integer getConstruction() {
        return construction;
    }

    public void setConstruction(Integer construction) {
        this.construction = construction;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<Equipment> getEquipmentInfos() {
        return equipmentInfos;
    }

    public void setEquipmentInfos(List<Equipment> equipmentInfos) {
        this.equipmentInfos = equipmentInfos;
    }

    public String getStationTel() {
        return stationTel;
    }

    public void setStationTel(String stationTel) {
        this.stationTel = stationTel;
    }

    public String getSiteGuide() {
        return siteGuide;
    }

    public void setSiteGuide(String siteGuide) {
        this.siteGuide = siteGuide;
    }

    public String getMatchCars() {
        return matchCars;
    }

    public void setMatchCars(String matchCars) {
        this.matchCars = matchCars;
    }

    public String getParkInfo() {
        return parkInfo;
    }

    public void setParkInfo(String parkInfo) {
        this.parkInfo = parkInfo;
    }

    public String getBusineHours() {
        return busineHours;
    }

    public void setBusineHours(String busineHours) {
        this.busineHours = busineHours;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getParkFee() {
        return parkFee;
    }

    public void setParkFee(String parkFee) {
        this.parkFee = parkFee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getSupportOrder() {
        return supportOrder;
    }

    public void setSupportOrder(Integer supportOrder) {
        this.supportOrder = supportOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
