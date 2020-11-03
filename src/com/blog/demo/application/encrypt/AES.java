package com.blog.demo.application.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/*
 * https://blog.csdn.net/chennai1101/article/details/84553049
 */
public class AES {
	private static final String Algorithm = "AES";
	private static final String Transformation = "AES/CBC/PKCS5Padding";
	private static final byte[] Password = "1234567812345678".getBytes();
	private static final byte[] IvParameter = "1234567887654321".getBytes();

	public static void main(String[] args) {
		AES.encryptTransformation(ByteTool.TestStr, Password);
		AES.decryptTransformation(DatatypeConverter.parseHexBinary("8642be6ffca8e366e01c06478a23906e531131079ab0e6da7ff5888a033fb5221a26d2161f66e60bcee53b2ee1314cc2"), Password);
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
