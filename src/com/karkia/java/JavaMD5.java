package com.karkia.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        scanner.close();

        // encode with MD5
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(inputStr.getBytes());
        byte[] digest = md5.digest();

        // print encoded value
        for (byte b : digest) {
            System.out.format("%02x", b);
        }
    }
}
