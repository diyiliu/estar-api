package com.tiza.web.model.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tiza.support.util.JacksonUtil;

import javax.persistence.*;
import java.util.List;

/**
 * Description: ChargeOrder
 * Author: DIYILIU
 * Update: 2018-03-12 10:02
 */

@Entity
@Table(name = "bs_chargeorder")
public class ChargeOrder {

    @Id
    private Long id;

    @Column(name = "orderSeq")
    private String startChargeSeq;

    @Column(name = "orderStatus")
    private Integer startChargeSeqStat;

    @Column(name = "stopCode")
    private String identCode;

    private String connectorID;

    private Integer connectorStatus;

    private Double currentA;

    private Double currentB;

    private Double currentC;

    private Double VoltageA;

    private Double VoltageB;

    private Double VoltageC;

    private Double soc;

    private String startTime;

    private String endTime;

    private Double totalPower;

    @JsonProperty("totalElecMoney")
    private Double elecMoney;

    @JsonProperty("totalSeviceMoney")
    private Double serviceMoney;

    private Double totalMoney;

    private Integer stopReason;

    @Column(name = "checkTotalPower")
    private Double totalOrderPower;

    @Column(name = "checkTotalPower")
    private Double totalOrderMoney;

    private String chargeDetail;

    @Transient
    private Double sumPeriod;

    @Transient
    private List<ChargeDetail> chargeDetails;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartChargeSeq() {
        return startChargeSeq;
    }

    public void setStartChargeSeq(String startChargeSeq) {
        this.startChargeSeq = startChargeSeq;
    }

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getStartChargeSeqStat() {
        return startChargeSeqStat;
    }

    public void setStartChargeSeqStat(Integer startChargeSeqStat) {
        this.startChargeSeqStat = startChargeSeqStat;
    }

    public Integer getConnectorStatus() {
        return connectorStatus;
    }

    public void setConnectorStatus(Integer connectorStatus) {
        this.connectorStatus = connectorStatus;
    }

    public Double getCurrentA() {
        return currentA;
    }

    public void setCurrentA(Double currentA) {
        this.currentA = currentA;
    }

    public Double getCurrentB() {
        return currentB;
    }

    public void setCurrentB(Double currentB) {
        this.currentB = currentB;
    }

    public Double getCurrentC() {
        return currentC;
    }

    public void setCurrentC(Double currentC) {
        this.currentC = currentC;
    }

    public Double getVoltageA() {
        return VoltageA;
    }

    public void setVoltageA(Double voltageA) {
        VoltageA = voltageA;
    }

    public Double getVoltageB() {
        return VoltageB;
    }

    public void setVoltageB(Double voltageB) {
        VoltageB = voltageB;
    }

    public Double getVoltageC() {
        return VoltageC;
    }

    public void setVoltageC(Double voltageC) {
        VoltageC = voltageC;
    }

    public Double getSoc() {
        return soc;
    }

    public void setSoc(Double soc) {
        this.soc = soc;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(Double totalPower) {
        this.totalPower = totalPower;
    }

    public Double getElecMoney() {
        return elecMoney;
    }

    public void setElecMoney(Double elecMoney) {
        this.elecMoney = elecMoney;
    }

    public Double getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(Double serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getSumPeriod() {
        return sumPeriod;
    }

    public void setSumPeriod(Double sumPeriod) {
        this.sumPeriod = sumPeriod;
    }

    public List<ChargeDetail> getChargeDetails() {
        return chargeDetails;
    }

    public void setChargeDetails(List<ChargeDetail> chargeDetails) {
        this.chargeDetails = chargeDetails;
        setChargeDetail(JacksonUtil.toJson(chargeDetails));
    }

    public String getIdentCode() {
        return identCode;
    }

    public void setIdentCode(String identCode) {
        this.identCode = identCode;
    }

    public String getChargeDetail() {
        return chargeDetail;
    }

    public void setChargeDetail(String chargeDetail) {
        this.chargeDetail = chargeDetail;
    }

    public Integer getStopReason() {
        return stopReason;
    }

    public void setStopReason(Integer stopReason) {
        this.stopReason = stopReason;
    }

    public Double getTotalOrderPower() {
        return totalOrderPower;
    }

    public void setTotalOrderPower(Double totalOrderPower) {
        this.totalOrderPower = totalOrderPower;
    }

    public Double getTotalOrderMoney() {
        return totalOrderMoney;
    }

    public void setTotalOrderMoney(Double totalOrderMoney) {
        this.totalOrderMoney = totalOrderMoney;
    }
}
