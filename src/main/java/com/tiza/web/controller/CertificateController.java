package com.tiza.web.controller;

import com.tiza.support.util.CommonUtil;
import com.tiza.support.util.RedisUtil;
import com.tiza.web.dao.CertificateDao;
import com.tiza.web.model.Token;
import com.tiza.web.model.bean.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.MessageDigest;
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
    private final static long TOKEN_AVAILABLE_TIME = 30 * 60;

    @Autowired

    private CertificateDao certificateDao;

    @Resource
    private RedisUtil redisUtil;

    @PostMapping("/query_token")
    public Map queryToken(@RequestParam("OperatorID") String operatorId,
                          @RequestParam("OperatorSecret") String operatorSecret) throws Exception {

        Map respMap = new HashMap();
        respMap.put("OperatorID", operatorId);

        Operator operator = certificateDao.findOperator(operatorId);
        if (operator != null && operatorSecret.equals(operator.getSecret())) {
            String token = generateToken();

            respMap.put("SuccStat", 0);
            respMap.put("FailReason", 0);

            respMap.put("AccessToken", token);
            respMap.put("TokenAvailableTime", TOKEN_AVAILABLE_TIME);

            Token t = new Token();
            t.setToken(token);
            t.setOperatorId(operatorId);
            t.setDatetime(System.currentTimeMillis());
            t.setTokenAvailableTime(TOKEN_AVAILABLE_TIME);

            redisUtil.set(token, t);
        } else {
            respMap.put("SuccStat", 1);
            if (operator == null) {
                respMap.put("FailReason", 1);
            } else {
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
