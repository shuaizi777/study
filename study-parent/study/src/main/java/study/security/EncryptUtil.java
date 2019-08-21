package study.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author shuai.chen
 * @Description AES算法封装
 * @date 2018/10/11 15:18
 */
public class EncryptUtil {


    public static void main(String[] args) {
        String password = "s";
        String secretKey = "ljl520";

        String password2 = EncryptUtil.encryptBase64(password, secretKey);
        System.out.println(password2);

        String password3 = EncryptUtil.decryptBase64(password2, secretKey);
        System.out.println(password3);
    }


    /**
     * 加密算法
     */
    private static final String ENCRY_ALGORITHM = "AES";

    /**
     * 加密算法/加密模式/填充类型
     * 本例采用AES加密，ECB加密模式，PKCS5Padding填充
     */
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";

    /**
     * 设置iv偏移量
     * 本例采用ECB加密模式，不需要设置iv偏移量
     */
    private static final String IV_ = null;

    /**
     * 设置加密字符集
     * 本例采用 UTF-8 字符集
     */
    private static final String CHARACTER = "UTF-8";

    /**
     * 设置加密密码处理长度。
     * 不足此长度补0；
     */
    private static final int PWD_SIZE = 16;

    /**
     * getBytes(String charsetName): 使用指定的字符集将字符串编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
     * getBytes(): 使用平台的默认字符集将字符串编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
     */

    /**
     * 密匙 byte序列化处理
     * 将明文密码扩展或保留成为16位字符串，将这16位字符串通过UTF-8编码为 byte 序列，并将结果存储到一个新的 byte 数组中返回
     * @param password 待处理的密码
     * @return
     *      处理后的密码 byte序列
     */
    public static byte[] pwdHandler(String password)  {
        try{
            byte[] data = null;
            if (password == null) {
                password = "";
            }
            StringBuffer sb = new StringBuffer(PWD_SIZE);
            sb.append(password);
            while (sb.length() < PWD_SIZE) {
                sb.append("0");//不足16位右补0至16位
            }
            if (sb.length() > PWD_SIZE) {
                sb.setLength(PWD_SIZE);//超过16位自左向右保留前16位
            }

            //使用指定的字符集将字符串编码为 byte 序列，并将结果存储到一个新的 byte 数组中
            data = sb.toString().getBytes("UTF-8");

            return data;
        }catch(Throwable e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    //======================>原始加密<======================

    /**
     * 原始加密
     * @param clearTextBytes 明文字节数组，待加密的字节数组
     * @param pwdBytes 加密密码字节数组
     * @return 返回加密后的密文字节数组，加密错误返回null
     */
    public static byte[] encrypt(byte[] clearTextBytes, byte[] pwdBytes) {
        try {
            // 1 获取加密密钥
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);

            // 2 获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);

            // 查看数据块位数 默认为16（byte） * 8 =128 bit
            //System.out.println("数据块位数(byte)：" + cipher.getBlockSize());

            // 3 初始化Cipher实例。设置执行模式以及加密密钥
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            // 4 执行
            byte[] cipherTextBytes = cipher.doFinal(clearTextBytes);

            // 5 返回密文字符集
            return cipherTextBytes;
        }catch (Exception e) {
            e.printStackTrace();
        }
        // 加密错误 返回null
        return null;
    }

    /**
     * 原始解密
     * @param cipherTextBytes 密文字节数组，待解密的字节数组
     * @param pwdBytes 解密密码字节数组
     * @return 返回解密后的明文字节数组，解密错误返回null
     */
    public static byte[] decrypt(byte[] cipherTextBytes, byte[] pwdBytes) {

        try {
            // 1 获取解密密钥
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);

            // 2 获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);

            // 查看数据块位数 默认为16（byte） * 8 =128 bit
            //System.out.println("数据块位数(byte)：" + cipher.getBlockSize());

            // 3 初始化Cipher实例。设置执行模式以及加密密钥
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            // 4 执行
            byte[] clearTextBytes = cipher.doFinal(cipherTextBytes);

            // 5 返回明文字符集
            return clearTextBytes;

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 解密错误 返回null
        return null;
    }

    //======================>BASE64<======================

    /**
     * BASE64加密
     * @param clearText 明文，待加密的内容
     * @param password 密码，加密的密码
     * @return 返回密文，加密后得到的内容。加密错误返回null
     */
    public static String encryptBase64(String clearText, String password) {
        try {
            // 1 获取加密密文字节数组
            byte[] cipherTextBytes = encrypt(clearText.getBytes(CHARACTER), pwdHandler(password));

            // 2 对密文字节数组进行BASE64 encoder 得到 BASE6输出的密文
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String cipherText = base64Encoder.encode(cipherTextBytes);

            // 3 返回BASE64输出的密文
            return cipherText;
      //      return Base64Test.encodeBase64String(cipherTextBytes); //修改的地方
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 加密错误 返回null
        return null;
    }

    /**
     * BASE64解密
     * @param cipherText 密文，带解密的内容
     * @param password 密码，解密的密码
     * @return 返回明文，解密后得到的内容。解密错误返回null
     */
    public static String decryptBase64(String cipherText, String password) {
        try {
            // 1 对 BASE64输出的密文进行BASE64 decodebuffer 得到密文字节数组
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] cipherTextBytes = base64Decoder.decodeBuffer(cipherText);
    //        byte[] cipherTextBytes =Base64Test.decodeBase64(cipherText); //修改地方
            // 2 对密文字节数组进行解密 得到明文字节数组
            byte[] clearTextBytes = decrypt(cipherTextBytes, pwdHandler(password));

            // 3 根据 CHARACTER 转码，返回明文字符串
            return new String(clearTextBytes, CHARACTER);
        }catch (Exception e) {
            e.printStackTrace();
        }
        // 解密错误返回null
        return null;
    }
}
