package com.tiza.web.dao;

import com.tiza.web.entity.Connector;
import com.tiza.web.entity.Equipment;
import com.tiza.web.entity.StationInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: StationDao
 * Author: DIYILIU
 * Update: 2017-12-07 13:55
 */

@Repository
public class StationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<StationInfo> queryStations(String lastTime) throws ParseException {
        String sql = "SELECT id," +
                "       operatorid," +
                "       stationid," +
                "       name," +
                "       equipmentownerid," +
                "       district," +
                "       address," +
                "       servicetel," +
                "       stationtype," +
                "       stationstatus," +
                "       parknums," +
                "       gcj02lng," +
                "       gcj02lat," +
                "       construction" +
                "  FROM bs_chargestation";
        List param = new ArrayList();

        if (StringUtils.isNotEmpty(lastTime)) {
            sql += "WHERE MODIFYTIME > ?";
            param.add(DateUtils.parseDate(lastTime, "yyyy-MM-dd HH:mm:ss"));
        }

        return jdbcTemplate.query(sql, param.toArray(), (ResultSet rs, int rowNum) -> {
            StationInfo stationInfo = new StationInfo();

            stationInfo.setId(rs.getLong("id"));
            stationInfo.setOperationID(rs.getString("operatorid"));
            stationInfo.setStationID(rs.getString("stationid"));
            stationInfo.setStationName(rs.getString("name"));
            stationInfo.setEquipmentOwnerID(rs.getString("equipmentownerid"));
            stationInfo.setAreaCode(rs.getString("district"));
            stationInfo.setAddress(rs.getString("address"));
            stationInfo.setServiceTel(rs.getString("servicetel"));
            stationInfo.setStationType(rs.getInt("stationtype"));
            stationInfo.setStationStatus(rs.getInt("stationstatus"));
            stationInfo.setParkNums(rs.getInt("parknums"));
            stationInfo.setStationLng(rs.getDouble("gcj02lng"));
            stationInfo.setStationLat(rs.getDouble("gcj02lat"));
            stationInfo.setConstruction(rs.getInt("construction"));

            return stationInfo;
        });
    }

    public List<Equipment> queryEquipments(String lastTime, Long stationId) throws ParseException {
        String sql = "SELECT id," +
                "       equipmentid," +
                "       manufacturerid," +
                "       equipmentmodel," +
                "       productiondate," +
                "       equipmenttype," +
                "       power," +
                "       equipmentname" +
                "  FROM bs_chargepile" +
                " WHERE stationid = " + stationId;

        List param = new ArrayList();

        if (StringUtils.isNotEmpty(lastTime)) {
            sql += "WHERE MODIFYTIME > ?";
            param.add(DateUtils.parseDate(lastTime, "yyyy-MM-dd HH:mm:ss"));
        }

        return jdbcTemplate.query(sql, param.toArray(), (ResultSet rs, int rowNum) -> {
            Equipment equipment = new Equipment();

            equipment.setId(rs.getLong("id"));
            equipment.setEquipmentID(rs.getString("equipmentid"));
            equipment.setManufacturerID(rs.getString("manufacturerid"));
            equipment.setEquipmentModel(rs.getString("equipmentmodel"));
            equipment.setProductionDate(DateFormatUtils.format(rs.getDate("productiondate"), "yyyy-MM-dd"));
            equipment.setEquipmentType(rs.getInt("equipmenttype"));
            equipment.setPower(rs.getDouble("power"));
            equipment.setEquipmentName(rs.getString("equipmentname"));

            return equipment;
        });
    }

    public List<Connector> queryConnectors(Long equipmentId) {
        String sql = "SELECT id," +
                "       connectorid," +
                "       connectortype," +
                "       voltageupperlimits," +
                "       voltagelowerlimits," +
                "       electricitycurrent," +
                "       nationalstandard," +
                "       power" +
                "  FROM bs_chargeconnector" +
                " WHERE pileid = ?";

        return jdbcTemplate.query(sql, new Object[]{equipmentId}, (ResultSet rs, int rowNum) -> {
            Connector connector = new Connector();

            connector.setId(rs.getLong("id"));
            connector.setConnectorID(rs.getString("connectorid"));
            connector.setConnectorType(rs.getInt("connectortype"));
            connector.setVoltageUpperLimits(rs.getInt("voltageupperlimits"));
            connector.setVoltageLowerLimits(rs.getInt("voltagelowerlimits"));
            connector.setCurrent(rs.getDouble("electricitycurrent"));
            connector.setNationalStandard(rs.getInt("nationalstandard"));
            connector.setPower(rs.getDouble("power"));

            return connector;
        });
    }
}
