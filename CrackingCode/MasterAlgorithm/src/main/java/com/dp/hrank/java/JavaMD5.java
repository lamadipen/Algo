package com.dp.hrank.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaMD5 {

    public static void main(String... args) throws NoSuchAlgorithmException {
        String str = "Hello";

        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(str.getBytes());
        byte[] digest = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
    }
}
