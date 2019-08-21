package study.security;

import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/20 16:39
 */
public class MD5Test {

    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {

        byte[] bytes = {1 ,3, 4};
        System.out.println(bytes);
        System.out.println("**************");
        System.out.println(MD5("shauizihhhhh"));

        System.out.println("**************");
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest("shuaizi".getBytes("utf-8")));
        byte[] bb = md5.digest("shuaizi".getBytes("utf-8"));
        System.out.println(md5.digest("shuaizi".getBytes("utf-8")));
        System.out.println(newstr);
        System.out.println(new BigInteger(1, md5.digest()).toString(16));

    }

}
