package com.karkia.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        //return n -> n % 2 != 0;
        return n -> ((n & 1) == 1);
    }

    public PerformOperation isPrime() {
        return n -> {
            if (n < 2) {
                return false;
            } else if (n == 2) {
                return true;
            } else if (n % 2 == 0) {
                return false;
            }


            for (int i = 3; i <= Math.floor(Math.sqrt(n)); i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return n -> {
            String originalStr = Integer.toString(n);
            String reversedStr = new StringBuffer(originalStr).reverse().toString();

            return originalStr.equals(reversedStr);
        };
    }
}

public class JavaLambdaExpressions {

    public static void main(String[] args) throws IOException {
        MyMath myMath = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation performOperation;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                performOperation = myMath.isOdd();
                ret = myMath.checker(performOperation, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                performOperation = myMath.isPrime();
                ret = myMath.checker(performOperation, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                performOperation = myMath.isPalindrome();
                ret = myMath.checker(performOperation, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
