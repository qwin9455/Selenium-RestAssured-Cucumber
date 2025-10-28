package com.nsw.revenue.utils;

import java.util.Base64;

public class Base64Util {

    public static String encryptString(String originalString) {
        byte[] stringBytes = originalString.getBytes();
        return Base64.getEncoder().encodeToString(stringBytes);
    }

    public static String decryptString(String str) {
        byte[] decodedBytes = Base64.getDecoder().decode(str);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        System.out.println(encryptString("tolentinomyka"));
        System.out.println(encryptString("LT_99s2yBahNPzWiWHGSMrgowuVN3trfSmgVxKCQSITd6HM0ZQ"));
    }
}
