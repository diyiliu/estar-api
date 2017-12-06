import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * Description: MainTest
 * Author: DIYILIU
 * Update: 2017-12-06 13:56
 */
public class MainTest {

    @Test
    public void test() throws Exception {
        String uuid = UUID.randomUUID().toString();
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //加密后的字符串
        String newstr = toHex(md5.digest(uuid.getBytes("UTF-8")));

        System.out.println(newstr);
    }

    public static String toHex(byte[] bytes) {
        StringBuffer buf = new StringBuffer();
        for (byte b : bytes) {
            buf.append(String.format("%02X", b < 0 ? b + 256 : b));
        }

        return buf.toString();
    }
}
