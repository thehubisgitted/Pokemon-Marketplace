package com.example.marketclient;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5Encryption {

    public static String encryptPassword(String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger bigInteger = new BigInteger(1,messageDigest);
        return bigInteger.toString(16);
    }
}
