package com.karkia;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> namePhoneMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();

            namePhoneMap.put(name, phone);
        }
        while (in.hasNext()) {
            String query = in.nextLine();

            String print = namePhoneMap.get(query) == null ? "Not found" : query + "=" + namePhoneMap.get(query);
            System.out.println(print);
        }
    }
}





