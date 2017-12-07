package com.tiza.web.controller;

import com.tiza.web.entity.StationInfo;
import com.tiza.web.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: StationController
 * Author: DIYILIU
 * Update: 2017-12-07 13:54
 */

@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @PostMapping("query_stations_info")
    public List<StationInfo> queryStations(@RequestParam("LastQueryTime") String lastTime) throws Exception{

        return stationService.queryStation(lastTime);
    }
}
