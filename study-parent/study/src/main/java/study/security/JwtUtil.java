package study.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * JWT校验工具类
 * <ol>
 * <li>iss: jwt签发者</li>
 * <li>sub: jwt所面向的用户</li>
 * <li>aud: 接收jwt的一方</li>
 * <li>exp: jwt的过期时间，这个过期时间必须要大于签发时间</li>
 * <li>nbf: 定义在什么时间之前，该jwt都是不可用的</li>
 * <li>iat: jwt的签发时间</li>
 * <li>jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击</li>
 * </ol>
 */
public class JwtUtil {

    public static void main(String[] args) {
        String name = "chenlaoshi";
        String var1 = JwtUtil.createJWT(name);
        System.out.println(var1);
        System.out.println(JwtUtil.parseJWT(var1));

    }

    private static final SecretKey PRIVATE_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // private static final String KEY1 = "somethinghereshouldbelong";


    /**
     * 由字符串生成加密key
     * @return
     */
    private static SecretKey generalKey(){
        //使用自定义key
        //String stringKey = KEY1 + Constant.JWT_SECRET;
        //String stringKey = KEY1;
        //byte[] encodedKey = Base64.decodeBase64(stringKey);
        //SecretKey key = Keys.hmacShaKeyFor(encodedKey);

        return PRIVATE_KEY;
    }

    /**
     * 创建jwt
     * @param subject
     * @return
     * @throws Exception
     */
    public static String createJWT(String subject){

        SecretKey key = generalKey();
        Date now = new Date();
        Date thirtyMinutes = new Date(System.currentTimeMillis() + 30*60*1000);

        String jws = Jwts.builder()
                .setSubject(subject) // 主题
                .setIssuedAt(now) // 签发时间
                .setExpiration(thirtyMinutes) // 过期时间
                .signWith(key)
                .compact();

        return  jws;

    }

    /**
     * 解密jwt
     * @param jwt 密钥
     * @return 主题
     * @throws Exception 如果发生 JwtException，说明该密钥无效
     */
    public static String parseJWT (String jwt) throws JwtException {
        SecretKey key = generalKey();

        try {
            return Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
        }catch (JwtException ex){
            System.out.println("签证失效");
            return null;
        }
    }

}