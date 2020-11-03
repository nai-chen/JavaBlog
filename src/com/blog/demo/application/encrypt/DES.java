package com.blog.demo.application.encrypt;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

/*
 * https://blog.csdn.net/chennai1101/article/details/84553049
 */
public class DES {
	private static final String Algorithm = "DES";
	private static final String Transformation = "DES/CBC/PKCS5Padding";
	private static final byte[] Password = "13578642".getBytes();
	private static final byte[] IvParameter = "12345678".getBytes();
	
	public static void main(String[] args) {
		DES.encrypt(ByteTool.TestStr, Password);
		DES.decrypt(DatatypeConverter.parseHexBinary("4bf8e50bb824399876b476d415017c8656e89652550bcb2ffdd42d36edd7de2072a7ed4cc5cbfbde"), Password);
		
		DES.encryptTransformation(ByteTool.TestStr, Password);
		DES.decryptTransformation(DatatypeConverter.parseHexBinary("7eb90b79d6d43b006add77fe406d8727ab01e09aa506618ea995319216e6ead632fdfced012ed865"), Password);
	}
	

    public static void encrypt(String value, byte[] password) {
        try {
            DESKeySpec desKey = new DESKeySpec(password);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
            SecretKey securekey = keyFactory.generateSecret(desKey);

            SecureRandom random = new SecureRandom();
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);

            System.out.println(Algorithm + ":" + DatatypeConverter.printHexBinary(cipher.doFinal(value.getBytes())));
        } catch (Exception e) {
        }
    }

    public static void decrypt(byte[] value, byte[] password) {
        try {
            DESKeySpec desKey = new DESKeySpec(password);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
            SecretKey securekey = keyFactory.generateSecret(desKey);

            SecureRandom random = new SecureRandom();
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);

            System.out.println(Algorithm + ":" + new String(cipher.doFinal(value)));
        } catch (Exception e) {
        }

    }
	
    public static void encryptTransformation(String value, byte[] password) {
        try {
            DESKeySpec desKey = new DESKeySpec(password);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
            SecretKey securekey = keyFactory.generateSecret(desKey);

            IvParameterSpec iv = new IvParameterSpec(IvParameter);
            Cipher cipher = Cipher.getInstance(Transformation);
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);

            System.out.println(Algorithm + ":" + DatatypeConverter.printHexBinary(cipher.doFinal(value.getBytes())));
        } catch (Exception e) {
        }
    }

    public static void decryptTransformation(byte[] value, byte[] password) {
        try {
            DESKeySpec desKey = new DESKeySpec(password);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Algorithm);
            SecretKey securekey = keyFactory.generateSecret(desKey);

            IvParameterSpec iv = new IvParameterSpec(IvParameter);
            Cipher cipher = Cipher.getInstance(Transformation);
            cipher.init(Cipher.DECRYPT_MODE, securekey, iv);

            System.out.println(Algorithm + ":" + new String(cipher.doFinal(value)));
        } catch (Exception e) {
        }
    }

}
