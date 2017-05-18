package kr.withever.humanlibrary.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by youngjinkim on 2017. 5. 16..
 */
public class AESEncryptionUtil {


    private static final String ENCRYPT_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String ENCRYPTION_KEY = "1pq01pq01pq01pq0";

    private Key generateKeySpec() throws UnsupportedEncodingException {
        byte[] keyBytes = ENCRYPTION_KEY.getBytes("UTF-8");
        return new SecretKeySpec(keyBytes, "AES");
    }

    public String encrypt(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, generateKeySpec(), new IvParameterSpec(ENCRYPTION_KEY.getBytes()));
        byte[] encryptBytes = cipher.doFinal(str.getBytes());
        byte[] encodedBytes = Base64.encodeBase64(encryptBytes);
        return new String(encodedBytes);
    }

    public String decrypt(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, generateKeySpec(), new IvParameterSpec(ENCRYPTION_KEY.getBytes()));
        byte[] decodedBytes = Base64.decodeBase64(str);
        byte[] decryptBytes = cipher.doFinal(decodedBytes);
        return new String(decryptBytes);
    }
}
