package com.karkia.ThirtyDaysOfCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day28_RegExDB {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String regExPattern = "[a-z].@gmail.com";
        Pattern pattern = Pattern.compile(regExPattern);
        List<String> matchingEmails = new ArrayList<>();

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");
            String firstName = firstNameEmailID[0];
            String emailID = firstNameEmailID[1];

            Matcher matcher = pattern.matcher(emailID);
            if (matcher.find()) {
                matchingEmails.add(firstName);
            }
        }

        scanner.close();

        List<String> sortedFirstNames = matchingEmails.stream().sorted().collect(Collectors.toList());
        sortedFirstNames.forEach(name -> System.out.println(name));
    }
}

