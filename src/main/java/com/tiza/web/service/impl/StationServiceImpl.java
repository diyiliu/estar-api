package com.tiza.web.service.impl;

import com.tiza.web.dao.StationDao;
import com.tiza.web.model.bean.Connector;
import com.tiza.web.model.bean.Equipment;
import com.tiza.web.model.bean.StationInfo;
import com.tiza.web.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: StationServiceImpl
 * Author: DIYILIU
 * Update: 2017-12-07 13:59
 */

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao stationDao;

    @Override
    public List<StationInfo> queryStation(String operatorId, String lastTime) throws Exception{

        List<StationInfo> stationInfoList = stationDao.queryStations(operatorId, lastTime);

        for (StationInfo stationInfo: stationInfoList){

            Long stationId = stationInfo.getId();
            List<Equipment> equipmentList = stationDao.queryEquipments(lastTime, stationId);
            for (Equipment equipment: equipmentList){

                Long equipmentId = equipment.getId();
                List<Connector> connectorList = stationDao.queryConnectors(equipmentId);
                equipment.setConnectorInfos(connectorList);
            }

            stationInfo.setEquipmentInfos(equipmentList);
        }

        return stationInfoList;
    }
}
