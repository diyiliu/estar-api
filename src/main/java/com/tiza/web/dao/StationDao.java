package com.tiza.web.dao;

import com.tiza.support.util.Pagination;
import com.tiza.support.util.PaginationHelper;
import com.tiza.web.model.bean.Connector;
import com.tiza.web.model.bean.Equipment;
import com.tiza.web.model.bean.StationInfo;
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
public class StationDao extends PageDao {

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StationInfo> queryStations(String lastTime) throws ParseException {
        String sql = "SELECT t.id," +
                "       t.operatorid," +
                "       t.stationid," +
                "       t.name," +
                "       t.equipmentownerid," +
                "       t.district," +
                "       t.address," +
                "       t.stationtel," +
                "       t.servicetel," +
                "       t.stationtype," +
                "       t.stationstatus," +
                "       t.parknums," +
                "       t.gcj02lng," +
                "       t.gcj02lat," +
                "       t.guide," +
                "       t.construction," +
                "       t.matchcars," +
                "       t.parkinfo," +
                "       t.businesshours," +
                "       t.electricityfee," +
                "       t.servicefee," +
                "       t.parkfee," +
                "       t.payment," +
                "       t.supportorder," +
                "       t.remark" +
                "  FROM bs_chargestation t";
        List param = new ArrayList();

        if (StringUtils.isNotEmpty(lastTime)) {
            sql += "  LEFT JOIN bs_chargepile e" +
                    "    ON e.stationid = t.id" +
                    " WHERE t.modifytime > ?" +
                    "    OR e.modifytime > ?";

            param.add(DateUtils.parseDate(lastTime, "yyyy-MM-dd HH:mm:ss"));
            param.add(DateUtils.parseDate(lastTime, "yyyy-MM-dd HH:mm:ss"));
        }

        Pagination pagination = PaginationHelper.getPagination();
        if (pagination != null){
            sql = buildPageSql(sql, param.toArray(), pagination);
        }

        return jdbcTemplate.query(sql, param.toArray(), (ResultSet rs, int rowNum) -> {
            StationInfo stationInfo = new StationInfo();

            stationInfo.setId(rs.getLong("id"));
            stationInfo.setOperatorID(rs.getString("operatorid"));
            stationInfo.setStationID(rs.getString("stationid"));
            stationInfo.setStationName(rs.getString("name"));
            stationInfo.setEquipmentOwnerID(rs.getString("equipmentownerid"));
            stationInfo.setAreaCode(rs.getString("district"));
            stationInfo.setAddress(rs.getString("address"));
            stationInfo.setStationTel(rs.getString("stationtel"));
            stationInfo.setServiceTel(rs.getString("servicetel"));
            stationInfo.setStationType(rs.getInt("stationtype"));
            stationInfo.setStationStatus(rs.getInt("stationstatus"));
            stationInfo.setParkNums(rs.getInt("parknums"));
            stationInfo.setStationLng(rs.getDouble("gcj02lng"));
            stationInfo.setStationLat(rs.getDouble("gcj02lat"));
            stationInfo.setSiteGuide(rs.getString("guide"));
            stationInfo.setConstruction(rs.getInt("construction"));
            stationInfo.setMatchCars(rs.getString("matchcars"));
            stationInfo.setParkInfo(rs.getString("parkinfo"));
            stationInfo.setBusineHours(rs.getString("businesshours"));
            stationInfo.setElectricityFee(rs.getString("electricityfee"));
            stationInfo.setServiceFee(rs.getString("servicefee"));
            stationInfo.setParkFee(rs.getString("parkfee"));
            stationInfo.setPayment(rs.getString("payment"));
            stationInfo.setSupportOrder(rs.getInt("supportorder"));
            stationInfo.setRemark(rs.getString("remark"));

            return stationInfo;
        });
    }

    public List<Equipment> queryEquipments(String lastTime, Long stationId) throws ParseException {
        String sql = "SELECT id," +
                "       equipmentid," +
                "       manufacturerid," +
                "       manufacturername," +
                "       equipmentmodel," +
                "       productiondate," +
                "       equipmenttype," +
                "       lng," +
                "       lat," +
                "       power," +
                "       equipmentname" +
                "  FROM bs_chargepile" +
                " WHERE stationid = ?";

        List param = new ArrayList();
        param.add(stationId);

        if (StringUtils.isNotEmpty(lastTime)) {
            sql += " AND modifytime > ?";
            param.add(DateUtils.parseDate(lastTime, "yyyy-MM-dd HH:mm:ss"));
        }

        return jdbcTemplate.query(sql, param.toArray(), (ResultSet rs, int rowNum) -> {
            Equipment equipment = new Equipment();

            equipment.setId(rs.getLong("id"));
            equipment.setEquipmentID(rs.getString("equipmentid"));
            equipment.setManufacturerID(rs.getString("manufacturerid"));
            equipment.setManufacturerName(rs.getString("manufacturername"));
            equipment.setEquipmentModel(rs.getString("equipmentmodel"));
            equipment.setProductionDate(DateFormatUtils.format(rs.getDate("productiondate"), "yyyy-MM-dd"));
            equipment.setEquipmentType(rs.getInt("equipmenttype"));
            equipment.setEquipmentLng(rs.getDouble("lng"));
            equipment.setEquipmentLat(rs.getDouble("lat"));
            equipment.setPower(rs.getDouble("power"));
            equipment.setEquipmentName(rs.getString("equipmentname"));

            return equipment;
        });
    }

    public List<Connector> queryConnectors(Long equipmentId) {
        String sql = "SELECT id," +
                "       connectorid," +
                "       connectorName," +
                "       connectortype," +
                "       voltageupperlimits," +
                "       voltagelowerlimits," +
                "       electricitycurrent," +
                "       nationalstandard," +
                "       power," +
                "       parkno" +
                "  FROM bs_chargeconnector" +
                " WHERE pileid = ?";

        return jdbcTemplate.query(sql, new Object[]{equipmentId}, (ResultSet rs, int rowNum) -> {
            Connector connector = new Connector();

            connector.setId(rs.getLong("id"));
            connector.setConnectorID(rs.getString("connectorid"));
            connector.setConnectorName(rs.getString("connectorName"));
            connector.setConnectorType(rs.getInt("connectortype"));
            connector.setVoltageUpperLimits(rs.getInt("voltageupperlimits"));
            connector.setVoltageLowerLimits(rs.getInt("voltagelowerlimits"));
            connector.setCurrent(rs.getDouble("electricitycurrent"));
            connector.setNationalStandard(rs.getInt("nationalstandard"));
            connector.setPower(rs.getDouble("power"));
            connector.setParkNo(rs.getString("parkno"));

            return connector;
        });
    }
}
