package com.karkia;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultFunWithAnagrams {

    /*
     * Complete the 'funWithAnagrams' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY text as parameter.
     */

    public static List<String> funWithAnagrams(List<String> text) {
        // Write your code here
        List<String> clonedText = new ArrayList<>(text);

        for (int i = 0; i < text.size() - 1; i++) {
            for (int j = i + 1; j < text.size(); j++) {
                if (areAnagrams(text.get(i), text.get(j))) {
                    if (clonedText.get(i) != null) {
                        clonedText.remove(j);
                    }
                }
            }
        }

        clonedText.sort(Comparator.naturalOrder());

        return clonedText;
    }

    public static boolean areAnagrams(String stringA, String stringB) {
        return stringCleaner(stringA).equalsIgnoreCase(
                stringCleaner(stringB)
        );
    }

    public static String stringCleaner(String inputStr) {
        String[] splitted = inputStr.toLowerCase().split("");
        String sortedJointed = Arrays.stream(splitted).sorted().collect(joining(""));
        return sortedJointed;
    }
}

public class FunWithAnagrams {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int textCount = Integer.parseInt(scanner.nextLine());

        List<String> text = IntStream.range(0, textCount).mapToObj(i -> {
            try {
                return scanner.next();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = ResultFunWithAnagrams.funWithAnagrams(text);

        System.out.println(
                result.stream().collect(joining("\n")) + "\n"
        );
    }
}
