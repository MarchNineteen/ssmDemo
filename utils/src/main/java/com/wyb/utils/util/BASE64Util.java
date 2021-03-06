package com.wyb.utils.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author chang
 * @date 2016/11/3
 */
public class BASE64Util {


        public static String BASE64(String text) {
            if (StringUtils.isBlank(text)) {
                return null;
            }
            try {
                String asB64 = Base64.encodeBase64String(text.getBytes("utf-8"));
                return asB64;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static String dBASE64(String text) {
            if (StringUtils.isBlank(text))return null;
            byte[] byteT = Base64.decodeBase64(text);
            try {
                return new String(byteT, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }
}
