package com.tiza.web.controller;

import com.tiza.support.util.CommonUtil;
import com.tiza.web.dao.CertificateDao;
import com.tiza.web.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Description: CertificateController
 * Author: DIYILIU
 * Update: 2017-12-06 13:32
 */

@RestController
public class CertificateController {

    @Autowired
    private CertificateDao certificateDao;

    @PostMapping("/query_token")
    public Map queryToken(@RequestParam("OperatorID") String operatorId,
                          @RequestParam("OperatorSecret") String operatorSecret) throws Exception{

        Map respMap = new HashMap();
        respMap.put("OperatorID", operatorId);

        Operator operator = certificateDao.findOperator(operatorId);
        if (operator != null && operatorSecret.equals(operator.getSecret())){
            respMap.put("SuccStat", 0);
            respMap.put("FailReason", 0);

            respMap.put("AccessToken", generateToken());
            respMap.put("TokenAvailableTime", 3600);
        }else {
            respMap.put("SuccStat", 1);
            if (operator == null){
                respMap.put("FailReason", 1);
            }else{
                respMap.put("FailReason", 2);
            }
        }

        return respMap;
    }


    /**
     * 生成Token
     *
     * @return
     */
    private String generateToken() throws Exception {
        String uuid = UUID.randomUUID().toString();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(uuid.getBytes("UTF-8"));

        return CommonUtil.toHex(bytes);
    }
}