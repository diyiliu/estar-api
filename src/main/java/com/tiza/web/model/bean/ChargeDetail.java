package com.tiza.web.model.bean;

/**
 * Description: ChargeDetail
 * Author: DIYILIU
 * Update: 2018-03-12 14:45
 */
public class ChargeDetail {

    private String detailStartTime;

    private String detailEndTime;

    private Double elecPrice;

    private Double sevicePrice;

    private Double detailPower;

    private Double detailElecMoney;

    private Double detailSeviceMoney;


    public String getDetailStartTime() {
        return detailStartTime;
    }

    public void setDetailStartTime(String detailStartTime) {
        this.detailStartTime = detailStartTime;
    }

    public String getDetailEndTime() {
        return detailEndTime;
    }

    public void setDetailEndTime(String detailEndTime) {
        this.detailEndTime = detailEndTime;
    }

    public Double getElecPrice() {
        return elecPrice;
    }

    public void setElecPrice(Double elecPrice) {
        this.elecPrice = elecPrice;
    }

    public Double getSevicePrice() {
        return sevicePrice;
    }

    public void setSevicePrice(Double sevicePrice) {
        this.sevicePrice = sevicePrice;
    }

    public Double getDetailPower() {
        return detailPower;
    }

    public void setDetailPower(Double detailPower) {
        this.detailPower = detailPower;
    }

    public Double getDetailElecMoney() {
        return detailElecMoney;
    }

    public void setDetailElecMoney(Double detailElecMoney) {
        this.detailElecMoney = detailElecMoney;
    }

    public Double getDetailSeviceMoney() {
        return detailSeviceMoney;
    }

    public void setDetailSeviceMoney(Double detailSeviceMoney) {
        this.detailSeviceMoney = detailSeviceMoney;
    }
}
