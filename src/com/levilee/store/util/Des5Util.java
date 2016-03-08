package com.levilee.store.util;

import java.io.IOException;
import java.security.SecureRandom;
 
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
 

 
public class Des5Util {
 
    private final static String DES = "DES";
 
    public static void main(String[] args) throws Exception {
        String data = "asd12345678904151651651685456456";//����
        String key = "A1B2C3D4E5F6G7H8I9K0";
        System.out.println(encrypt(data, key));
    /*    System.out.println(data.length());
        System.out.println(encrypt(data, key).length());*/
        String mima = "kMVvfQL61Ek=";//����
        System.err.println(decrypt(mima, key));
 
    }
     
    /**
     * Description ���ݼ�ֵ���м���
     * @param data 
     * @param key  ���ܼ�byte����
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }
 
    /**
     * Description ���ݼ�ֵ���н���
     * @param data
     * @param key  ���ܼ�byte����
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws IOException,
            Exception {
        if (data == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf,key.getBytes());
        return new String(bt);
    }
 
    /**
     * Description ���ݼ�ֵ���м���
     * @param data
     * @param key  ���ܼ�byte����
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // ����һ�������ε������Դ
        SecureRandom sr = new SecureRandom();
 
        // ��ԭʼ��Կ���ݴ���DESKeySpec����
        DESKeySpec dks = new DESKeySpec(key);
 
        // ����һ����Կ������Ȼ��������DESKeySpecת����SecretKey����
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher����ʵ����ɼ��ܲ���
        Cipher cipher = Cipher.getInstance(DES);
 
        // ����Կ��ʼ��Cipher����
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
     
     
    /**
     * Description ���ݼ�ֵ���н���
     * @param data
     * @param key  ���ܼ�byte����
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // ����һ�������ε������Դ
        SecureRandom sr = new SecureRandom();
 
        // ��ԭʼ��Կ���ݴ���DESKeySpec����
        DESKeySpec dks = new DESKeySpec(key);
 
        // ����һ����Կ������Ȼ��������DESKeySpecת����SecretKey����
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
 
        // Cipher����ʵ����ɽ��ܲ���
        Cipher cipher = Cipher.getInstance(DES);
 
        // ����Կ��ʼ��Cipher����
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
 
        return cipher.doFinal(data);
    }
}
