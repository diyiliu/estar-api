package com.tiza.web.controller;

import com.tiza.support.util.JacksonUtil;
import com.tiza.web.dao.ChargeOrderDao;
import com.tiza.web.model.RespResult;
import com.tiza.web.model.bean.ChargeOrder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: ChargeController
 * Author: DIYILIU
 * Update: 2018-03-12 09:43
 */

@RestController
public class ChargeController {

    @Resource
    private ChargeOrderDao chargeOrderDao;


    /**
     * 推送启动充电结果
     *
     * @return
     */
    @PostMapping("/notification_start_charge_result")
    public RespResult notificationStartChargeResult(@RequestBody String body) throws Exception{
        ChargeOrder chargeOrder = JacksonUtil.toObject(body, ChargeOrder.class);

        ChargeOrder oldOrder = chargeOrderDao.findByStartChargeSeqAndcAndConnectorID(
                chargeOrder.getStartChargeSeq(), chargeOrder.getConnectorID());

        oldOrder.setStartChargeSeqStat(chargeOrder.getStartChargeSeqStat());
        oldOrder.setStartTime(chargeOrder.getStartTime());
        oldOrder.setIdentCode(chargeOrder.getIdentCode());

        chargeOrderDao.save(oldOrder);

        Map map = new HashMap();
        map.put("StartChargeSeq", chargeOrder.getStartChargeSeq());
        map.put("SuccStat", 0);
        map.put("FailReason", 0);

        RespResult result = new RespResult();
        result.setData(map);

        return result;
    }


    /**
     * 推送充电状态
     *
     * @return
     */
    @PostMapping("notification_equip_charge_status")
    public RespResult notificationEquipChargeStatus(@RequestBody String body) throws Exception{
        ChargeOrder chargeOrder = JacksonUtil.toObject(body, ChargeOrder.class);

        ChargeOrder oldOrder = chargeOrderDao.findByStartChargeSeqAndcAndConnectorID(
                chargeOrder.getStartChargeSeq(), chargeOrder.getConnectorID());

        chargeOrder.setId(oldOrder.getId());
        chargeOrderDao.save(chargeOrder);

        Map map = new HashMap();
        map.put("StartChargeSeq", chargeOrder.getStartChargeSeq());
        map.put("SuccStat", 0);
        map.put("FailReason", 0);

        RespResult result = new RespResult();
        result.setData(map);

        return result;
    }


    /**
     * 推送停止充电结果
     *
     * @return
     */
    @PostMapping
    public RespResult notificationStopChargeResult(@RequestBody String body) throws Exception{
        ChargeOrder chargeOrder = JacksonUtil.toObject(body, ChargeOrder.class);

        ChargeOrder oldOrder = chargeOrderDao.findByStartChargeSeqAndcAndConnectorID(
                chargeOrder.getStartChargeSeq(), chargeOrder.getConnectorID());

        oldOrder.setStartChargeSeqStat(chargeOrder.getStartChargeSeqStat());

        chargeOrderDao.save(oldOrder);

        Map map = new HashMap();
        map.put("StartChargeSeq", chargeOrder.getStartChargeSeq());
        map.put("SuccStat", 0);
        map.put("FailReason", 0);

        RespResult result = new RespResult();
        result.setData(map);

        return result;
    }


    /**
     * 推送充电订单信息
     *
     * @return
     */
    @PostMapping
    public RespResult notificationChargeOrderInfo(@RequestBody String body) throws Exception{
        ChargeOrder chargeOrder = JacksonUtil.toObject(body, ChargeOrder.class);

        ChargeOrder oldOrder = chargeOrderDao.findByStartChargeSeqAndcAndConnectorID(
                chargeOrder.getStartChargeSeq(), chargeOrder.getConnectorID());


        oldOrder.setStartTime(chargeOrder.getStartTime());
        oldOrder.setEndTime(chargeOrder.getEndTime());
        oldOrder.setTotalPower(chargeOrder.getTotalPower());
        oldOrder.setElecMoney(chargeOrder.getElecMoney());
        oldOrder.setServiceMoney(chargeOrder.getServiceMoney());
        oldOrder.setTotalMoney(chargeOrder.getTotalMoney());
        oldOrder.setStopReason(chargeOrder.getStopReason());
        oldOrder.setChargeDetail(JacksonUtil.toJson(chargeOrder.getChargeDetails()));

        Map map = new HashMap();
        map.put("StartChargeSeq", chargeOrder.getStartChargeSeq());
        map.put("ConnectorID", chargeOrder.getConnectorID());
        map.put("ConfirmResult", 0);

        RespResult result = new RespResult();
        result.setData(map);

        return result;
    }


    /**
     * 推送订单对账信息
     *
     * @return
     */
    @PostMapping
    public RespResult checkChargeOrders(@RequestBody String body) throws Exception{




        return null;
    }

}
