package com.tiza.web.controller;

import com.tiza.support.util.PaginationHelper;
import com.tiza.web.entity.StationInfo;
import com.tiza.web.service.StationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map queryStations(@RequestParam(value = "LastQueryTime", required = false) String lastTime,
                             @RequestParam(value = "PageNo", required = false) String pageNo,
                             @RequestParam(value = "PageSize", required = false) String pageSize) throws Exception {
        int page = 1;
        int limit = 10;
        if (StringUtils.isNotEmpty(pageNo)) {
            page = Integer.parseInt(pageNo);
        }
        if (StringUtils.isNotEmpty(pageSize)) {
            limit = Integer.parseInt(pageSize);
        }

        PaginationHelper.page(page, limit);
        List<StationInfo> stationInfoList = stationService.queryStation(lastTime);

        Map responseMap = new HashMap();
        responseMap.put("PageNo", page);
        responseMap.put("PageSize", limit);
        responseMap.put("ItemSize", PaginationHelper.getTotal());
        responseMap.put("StationInfos", stationInfoList);

        return responseMap;
    }
}
