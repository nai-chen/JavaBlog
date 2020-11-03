package com.blog.demo.application.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/*
 * https://blog.csdn.net/chennai1101/article/details/84553049
 */
public class DESede {
	private static final String Algorithm = "DESede";
	private static final String Transformation = "DESede/CBC/PKCS5Padding";
	private static final byte[] Password = "123456781234567812345678".getBytes();
	private static final byte[] IvParameter = "12345678".getBytes();;

	public static void main(String[] args) {
		DESede.encryptTransformation(ByteTool.TestStr, Password);
		DESede.decryptTransformation(DatatypeConverter.parseHexBinary("c37551bb77f741d0b00f2f4e819bbdbcfac4e0c0095b9b9e231bf4e19a1d904bffafd60765749948"), Password);
	}
	
    public static void encryptTransformation(String value, byte[] password) {	
        try {
            SecretKey securekey = new SecretKeySpec(password, Algorithm);

            IvParameterSpec iv = new IvParameterSpec(IvParameter);
            Cipher cipher = Cipher.getInstance(Transformation);
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);

            System.out.println(Algorithm + ":" + DatatypeConverter.printHexBinary(cipher.doFinal(value.getBytes())));
        } catch (Exception e) {
        }
    }

    public static void decryptTransformation(byte[] value, byte[] password) {
        try {
            SecretKey securekey = new SecretKeySpec(password, Algorithm);

            IvParameterSpec iv = new IvParameterSpec(IvParameter);
            Cipher cipher = Cipher.getInstance(Transformation);
            cipher.init(Cipher.DECRYPT_MODE, securekey, iv);

            System.out.println(Algorithm + ":" + new String(cipher.doFinal(value)));
        } catch (Exception e) {
        }
    }
}
