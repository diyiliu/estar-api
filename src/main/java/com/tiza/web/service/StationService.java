package com.tiza.web.service;

import com.tiza.web.entity.StationInfo;

import java.util.List;

/**
 * Description: StationService
 * Author: DIYILIU
 * Update: 2017-12-07 13:55
 */

public interface StationService {

    List<StationInfo> queryStation(String lastTime) throws Exception;
}
