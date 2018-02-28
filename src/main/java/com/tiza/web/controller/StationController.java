package com.tiza.web.controller;

import com.tiza.support.util.PaginationHelper;
import com.tiza.support.util.RedisUtil;
import com.tiza.web.model.RespResult;
import com.tiza.web.model.Token;
import com.tiza.web.model.bean.StationInfo;
import com.tiza.web.service.StationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Resource
    private RedisUtil redisUtil;

    /**
     * 查询充电站信息
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("query_stations_info")
    public RespResult queryStations(HttpServletRequest request) throws Exception {
        RespResult result = new RespResult();

        String operatorId = (String) request.getAttribute("operatorId");

        String lastTime = request.getParameter("lastTime");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");

        int page = 1;
        int limit = 10;
        if (StringUtils.isNotEmpty(pageNo)) {
            page = Integer.parseInt(pageNo);
        }
        if (StringUtils.isNotEmpty(pageSize)) {
            limit = Integer.parseInt(pageSize);
        }

        PaginationHelper.page(page, limit);
        List<StationInfo> stationInfoList = stationService.queryStation(operatorId, lastTime);

        Map dataMap = new HashMap();
        dataMap.put("PageNo", page);
        dataMap.put("PageSize", limit);
        dataMap.put("PageCount", PaginationHelper.getCount());
        dataMap.put("ItemSize", PaginationHelper.getTotal());
        dataMap.put("StationInfos", stationInfoList);

        result.setRet(0);
        result.setMsg("查询充电站信息成功");
        result.setData(dataMap);

        return result;
    }



}
