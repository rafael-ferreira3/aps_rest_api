package br.com.aps_rest_api.helpers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

    public static String toMD5(String txt){
        if(txt != null){
            MessageDigest messageDigest= null;
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            messageDigest.update(txt.getBytes(),0,txt.length());
            return new BigInteger(1,messageDigest.digest()).toString(16);
        }
        return null;
    }

}
