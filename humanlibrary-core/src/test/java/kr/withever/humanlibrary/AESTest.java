package kr.withever.humanlibrary;

import kr.withever.humanlibrary.util.AESEncryptionUtil;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

/**
 * Created by youngjinkim on 2017. 5. 16..
 */
public class AESTest {

    private static final String ADDESS = "서울시 양천구 목1동 목동현대하이페리온";

    @Test
    public void encryptAndDecrypt() throws NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException {
        AESEncryptionUtil aesEncryptionUtil = new AESEncryptionUtil();
        String encrypt = aesEncryptionUtil.encrypt(ADDESS);
        String decrypt = aesEncryptionUtil.decrypt(encrypt);
        assertEquals(ADDESS, decrypt);
    }

}
