package com.karkia.algorithms.strings;

import java.util.*;

// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
/*
TAKEN FROM: https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Strings/Sherlock%20and%20Valid%20String/Solution.java
Initial Thoughts:
Get every chars' frequency
If there are more than two different frequencies
    NO
if 1 frequency
    YES
if 2 frequency
    if 1 occurs only once and frequency is 1
        yes
    else
        if their difference 1 and one has frequency 1
            yes
        else
            no
examples:
abcde       -> Y
a           -> Y
aabb        -> Y
aaaabbbbc   -> Y
aaaabbbbcd  -> N
aabbcd      -> N
Time Complexity: O(n) //We have to look at every char
Space Complexity: O(n) //We store frequencies in a Hashmap
*/
public class SherlockAndValidString {
    static String isValid(String s) {
        boolean valid = true;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }

        Set<Integer> freqSet = new HashSet<>();
        for (int freq : freqMap.values()) {
            freqSet.add(freq); // find which freqs are unique
        }

        final int setSize = freqSet.size();
        if (setSize == 1) {
            // there is only one type of character, so its valid
            valid = true;
        } else if (setSize > 2) {
            // there are more than 2 freqs, so we cannot remove only one to make them valid
            valid = false;
        } else { // 2 diff. freqs so 1 can be removed
            int f1 = 0; // the value of freq. item like 4
            int f2 = 0;
            int f1Count = 0; // the count of f1 freq item like 4,4,1,1
            int f2Count = 0;

            int setIndex = 0;
            for (int setItem : freqSet) {
                if (setIndex == 0) {
                    f1 = setItem;
                } else {
                    f2 = setItem;
                }
                setIndex++;
            }

            for (int freq : freqMap.values()) {
                if (freq == f1) f1Count++; // like f1Count is 2 for freq '4'
                if (freq == f2) f2Count++;
            }

            if ((f1 == 1 && f1Count == 1) || (f2 == 1 && f2Count == 1)) {
                valid = true;
            } else if ((Math.abs(f1 - f2) == 1) && (f1Count == 1 || f2Count == 1)) {
                valid = true;
            } else {
                valid = false;
            }
        }

        return valid ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();

        System.out.println(isValid(inputStr));
    }
}
