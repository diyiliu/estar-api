package com.tiza.support.util;

/**
 * Description: CommonUtil
 * Author: DIYILIU
 * Update: 2017-12-06 14:10
 */

public class CommonUtil {

    public static String toHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer();
        for (byte b : bytes) {
            buf.append(String.format("%02X", b < 0 ? b + 256 : b));
        }

        return buf.toString();
    }
}
