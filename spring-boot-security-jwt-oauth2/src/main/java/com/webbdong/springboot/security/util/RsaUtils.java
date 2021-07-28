package com.webbdong.springboot.security.util;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA 工具类
 * @author: Webb Dong
 * @date: 2021-07-27 6:03 PM
 */
public class RsaUtils {

    /**
     * 默认的密钥长度
     */
    private static final int DEFAULT_KEY_SIZE = 2048;

    private static final String ALGORITHM = "RSA";

    /**
     * 从文件中读取公钥
     * @param classPathFileName 公钥保存路径
     * @return 公钥对象
     */
    public static PublicKey getPublicKey(String classPathFileName) throws Exception {
        return getPublicKey(readFile(classPathFileName));
    }

    /**
     * 从文件中读取密钥
     * @param classPathFileName 私钥保存路径
     * @return 私钥对象
     */
    public static PrivateKey getPrivateKey(String classPathFileName) throws Exception {
        return getPrivateKey(readFile(classPathFileName));
    }

    /**
     * 从文件中读取公钥
     * @param classPathFileName 公钥保存路径，在 ClassPath 下的文件路径
     * @return 公钥对象
     */
    public static PublicKey getPublicKeyFromClassPath(String classPathFileName) throws Exception {
        return getPublicKey(readFileFromClassPath(classPathFileName));
    }

    /**
     * 从文件中读取密钥
     * @param classPathFileName 私钥保存路径，在 ClassPath 下的文件路径
     * @return 私钥对象
     */
    public static PrivateKey getPrivateKeyFromClassPath(String classPathFileName) throws Exception {
        return getPrivateKey(readFileFromClassPath(classPathFileName));
    }

    /**
     * 根据密文，生存 RSA 公钥和私钥，并写入指定文件，默认密钥长度 2048
     * @param publicKeyFilename 公钥文件路径
     * @param privateKeyFilename 私钥文件路径
     * @param secret 生成密钥的密文
     */
    public static void generateKeys(String publicKeyFilename,
                                   String privateKeyFilename,
                                   String secret) throws NoSuchAlgorithmException, IOException {
        generateKeys(publicKeyFilename, privateKeyFilename, secret, DEFAULT_KEY_SIZE);
    }

    /**
     * 根据密文，生存 RSA 公钥和私钥，并写入指定文件
     * @param publicKeyFilename 公钥文件路径
     * @param privateKeyFilename 私钥文件路径
     * @param secret 生成密钥的密文
     * @param keySize 密钥长度
     */
    public static void generateKeys(String publicKeyFilename,
                                   String privateKeyFilename,
                                   String secret,
                                   int keySize) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        SecureRandom secureRandom = (secret != null ? new SecureRandom(secret.getBytes()) : new SecureRandom());
        keyPairGenerator.initialize(keySize, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        // 获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        writeFile(publicKeyFilename, publicKeyBytes);
        // 获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFilename, privateKeyBytes);
    }

    /**
     * 获取公钥
     * @param bytes 公钥的字节形式
     * @return 公钥对象
     */
    private static PublicKey getPublicKey(byte[] bytes) throws Exception {
        bytes = Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
        return factory.generatePublic(spec);
    }

    /**
     * 获取密钥
     * @param bytes 私钥的字节形式
     * @return 私钥对象
     */
    private static PrivateKey getPrivateKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        bytes = Base64.getDecoder().decode(bytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
        return factory.generatePrivate(spec);
    }

    private static byte[] readFile(String fileName) throws Exception {
        return Files.readAllBytes(new File(fileName).toPath());
    }

    private static byte[] readFileFromClassPath(String classPathFileName) throws IOException {
        return IOUtils.toByteArray(RsaUtils.class.getClassLoader().getResourceAsStream(classPathFileName));
    }

    private static void writeFile(String destPath, byte[] bytes) throws IOException {
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        Files.write(dest.toPath(), bytes);
    }

    private RsaUtils() {}

    @SneakyThrows
    public static void main(String[] args) {
        RsaUtils.generateKeys(
                "D:\\Developer\\jwt_rsa_public_key.pem",
                "D:\\Developer\\jwt_rsa_private_key.pem",
                null);
    }

}
