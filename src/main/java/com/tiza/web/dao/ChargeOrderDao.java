package com.tiza.web.dao;

import com.tiza.web.model.bean.ChargeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: ChargeOrderDao
 * Author: DIYILIU
 * Update: 2018-03-13 09:23
 */
public interface ChargeOrderDao extends JpaRepository<ChargeOrder, Long> {

    ChargeOrder findByStartChargeSeq(String orderSeq);

    ChargeOrder findByStartChargeSeqAndcAndConnectorID(String orderSeq, String connectorId);
}
