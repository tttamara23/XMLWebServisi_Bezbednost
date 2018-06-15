package pi.vezbe.service;


import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;


public class Encryptor {
    public static String encrypt(String value) {
        try {
        	String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println(new String(encrypted));

            return new String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encrypted) {
        try {
        	String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        	Cipher cipher = Cipher.getInstance("AES");
        	cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted.getBytes()));
           // System.out.println(decrypted);
            byte[] decoded = Base64.decodeBase64(encrypted.getBytes());
            return decrypted;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    
}