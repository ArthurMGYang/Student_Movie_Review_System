package com.mao.smr.utils;

import java.util.Random;

public class StringUtils {

    /**
     * this is used to generate random salt
     * @param length the salt length
     * @return the random generated salt
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";//contains all the lower case
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
