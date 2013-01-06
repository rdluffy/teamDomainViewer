package org.kaizoku.cryptography.digest;

import org.kaizoku.encoder.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: A168594
 * Date: 06/01/13
 * Time: 18:56
 * To change this template use File | Settings | File Templates.
 */
public class Digest {
    public final int DIGEST_SHA256 = 1;

    public static String hash_by_SHA256_to_base64(String pure_String){
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA256");
            byte[] result = digest.digest(pure_String.getBytes());
            return Base64.encodeToString(result,Base64.DEFAULT);
        } catch (NoSuchAlgorithmException e) {
            throw  new RuntimeException();
        }

    }

}
