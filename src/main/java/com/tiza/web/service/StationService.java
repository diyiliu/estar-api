package com.tiza.web.service;

import com.tiza.web.model.bean.StationInfo;

import java.util.List;

/**
 * Description: StationService
 * Author: DIYILIU
 * Update: 2017-12-07 13:55
 */

public interface StationService {

    List<StationInfo> queryStation(String operatorId, String lastTime) throws Exception;
}
