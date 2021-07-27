package com.webbdong.springboot.security.util;

import com.webbdong.springboot.security.model.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.SuperBuilder;
import org.joda.time.DateTime;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * JWT 工具类
 * @author: Webb Dong
 * @date: 2021-07-27 3:34 PM
 */
public class JwtUtils {

    private static final SignatureAlgorithm RS512 = SignatureAlgorithm.RS512;

    /**
     * 私钥加密 Token
     * @param propertyName 载荷数据的属性名
     * @param json 载荷 JSON 数据
     * @param privateKey 私钥
     * @param expire 过期时间
     * @param timeUnit 过期时间单位
     * @return JWT
     */
    public static String generateJwt(String propertyName,
                                     String json,
                                     PrivateKey privateKey,
                                     int expire,
                                     ExpirationTimeUnit timeUnit) {
        return Jwts.builder()
                .claim(propertyName, json)
                .setId(generateJTI())
                .setExpiration(expirationDate(expire, timeUnit))
                .signWith(privateKey, RS512)
                .compact();
    }

    /**
     * 私钥加密 Token
     * @param claims 载荷数据集合
     * @param privateKey 私钥
     * @param expire 过期时间
     * @param timeUnit 过期时间单位
     * @return JWT
     */
    public static String generateJwt(Map<String, Object> claims,
                                     PrivateKey privateKey,
                                     int expire,
                                     ExpirationTimeUnit timeUnit) {
        return Jwts.builder()
                .setClaims(claims)
                .setId(generateJTI())
                .setExpiration(expirationDate(expire, timeUnit))
                .signWith(privateKey, RS512)
                .compact();
    }

    /**
     * 公钥解析 Token，并且返回指定属性名的数据
     * @param propertyName 载荷数据的属性名
     * @param token 需要解析的 Token
     * @param publicKey 公钥
     * @param requiredType 需要获取的数据类型
     * @return Payload<T>
     */
    public static <T> Payload<T> parseToken(String propertyName,
                                            String token,
                                            PublicKey publicKey,
                                            Class<T> requiredType) {
        final Jws<Claims> claimsJws = parseToken(token, publicKey);
        Payload<T> payload = Payload.<T>builder()
                .id(claimsJws.getBody().getId())
                .data(JsonUtils.parseObj(claimsJws.getBody().get(propertyName, String.class), requiredType))
                .expiration(claimsJws.getBody().getExpiration())
                .build();
        return payload;
    }

    /**
     * 公钥解析 Token
     * @param token 需要解析的 Token
     * @param publicKey 公钥
     * @return Jws<Claims>
     */
    public static Jws<Claims> parseToken(String token, PublicKey publicKey) {
        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token);
    }

    /**
     * 过期时间单位枚举
     */
    public enum ExpirationTimeUnit {
        SECONDS,
        MINUTES,
        HOURS,
        DAYS,
        YEAR
    }

    @Data
    @SuperBuilder
    public static class Payload<T> {

        /**
         * JWT BODY ID
         */
        private String id;

        /**
         * BODY 数据
         */
        private T data;

        /**
         * 过期时间
         */
        private Date expiration;

    }

    /**
     * 根据时间单位和过期时间生成 Date
     * @param expire 过期时间
     * @param timeUnit 时间单位
     * @return 过期 Date
     */
    private static Date expirationDate(int expire, ExpirationTimeUnit timeUnit) {
        switch (timeUnit) {
            case SECONDS:
                return DateTime.now().plusSeconds(expire).toDate();
            case MINUTES:
                return DateTime.now().plusMinutes(expire).toDate();
            case HOURS:
                return DateTime.now().plusHours(expire).toDate();
            case DAYS:
                return DateTime.now().plusDays(expire).toDate();
            case YEAR:
                return DateTime.now().plusYears(expire).toDate();
            default:
                throw new IllegalArgumentException("未知时间单位 : " + timeUnit);
        }
    }

    /**
     * 生成 JTI
     * @return JTI
     */
    private static String generateJTI() {
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }

    private JwtUtils() {}

    @SneakyThrows
    public static void main(String[] args) {
        final String propertyName = "userInfo";
        final UserInfo userInfo = new UserInfo();
        userInfo.setId(6000L);
        userInfo.setNickname("Kobe");

        // 读取私钥转换成 PrivateKey
        final PrivateKey privateKey = RsaUtils.getPrivateKeyFromClassPath("jwt_rsa_private_key.pem");

        final String jwt = JwtUtils.generateJwt(
                propertyName,
                JsonUtils.toJSONString(userInfo),
                privateKey,
                1,
                ExpirationTimeUnit.MINUTES);
        System.out.println(jwt);

        // 读取公钥转换成 PublicKey
        final PublicKey publicKey = RsaUtils.getPublicKeyFromClassPath("jwt_rsa_public_key.pem");
        final Jws<Claims> claimsJws = JwtUtils.parseToken(jwt, publicKey);
        System.out.println(claimsJws.getBody().get(propertyName));

        final Payload<UserInfo> payload = JwtUtils.parseToken(propertyName, jwt, publicKey, UserInfo.class);
        System.out.println(payload);
    }

}
