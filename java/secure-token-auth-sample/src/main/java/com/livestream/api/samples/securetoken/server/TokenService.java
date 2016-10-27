package com.livestream.api.samples.securetoken.server;

import static com.livestream.api.samples.securetoken.Constants.API_SECRET;

import java.io.UnsupportedEncodingException;
import java.security.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import com.livestream.api.samples.securetoken.model.Token;

public class TokenService {

    private static final String SEPARATOR = ":";
    private static final String HMAC_MD5_ALGO = "HmacMD5";
    private static final String CHARSET = "UTF-8";

    public static Token generateToken(String scope, long timestamp)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String concat = API_SECRET + SEPARATOR + scope + SEPARATOR + timestamp;
        SecretKeySpec key = new SecretKeySpec(API_SECRET.getBytes(CHARSET), HMAC_MD5_ALGO);

        Mac mac = Mac.getInstance(HMAC_MD5_ALGO);
        mac.init(key);
        byte[] bytes = mac.doFinal(concat.getBytes(CHARSET));

        return new Token(Hex.encodeHexString(bytes), timestamp);
    }
}
