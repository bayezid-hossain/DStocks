package com.example.dstocks;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Encryption {

    private void nothing() throws NoSuchAlgorithmException,InvalidKeySpecException,NoSuchPaddingException,BadPaddingException,IllegalBlockSizeException,InvalidKeyException{
        String pubKey = "-----BEGIN PUBLIC KEY-----\n" +
                "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEZV/tit91bVjr/AHV+WnmlFIL\n" +
                "BdhYsmE79+eNb4tobQjq73zhFKaIbxs/y7PsVCWUgFNieJKXbQtMa+4z5N8wGYhV\n" +
                "4KvWPKlKEiw1eGhTxY74L6DRuGjm9jOrNM3h513AEKTqr6Dj8uha5875fuzYtNPc\n" +
                "bOI5WyQFMa85gg3uoQIDAQAB\n" +
                "-----END PUBLIC KEY-----";
        pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");
        byte[] keyBytes = Base64.decode(pubKey,Base64.DEFAULT);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pk = kf.generatePublic(spec);
        String k=encrypt(pk);
        System.out.print(k);
    }
    private String encrypt(PublicKey pk) throws InvalidKeyException,NoSuchAlgorithmException,NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        byte[] cipherText;
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pk);
        cipherText = cipher.doFinal("Hello World!".getBytes());
        return Base64.encodeToString(cipherText,Base64.DEFAULT);
    }
}
