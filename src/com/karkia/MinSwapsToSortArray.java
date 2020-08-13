package com.karkia;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'minimumSwaps' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY popularity as parameter.
     */

    public static int minimumSwaps(List<Integer> popularity) {
        // Write your code here
        int minSwapCount = 0;
        boolean visited[] = new boolean[popularity.size()];

        for (int i = 0; i < popularity.size(); i++) {
            int j = i, cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = popularity.get(j) - 1;
                cycle++;
            }

            if (cycle != 0)
                minSwapCount += cycle - 1;
        }
        return minSwapCount;
    }

    public int sort(List<Integer> popularity) {
        Integer[] arr = popularity.toArray(Integer[]::new);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) continue;
            count++;
            int tmp = arr[i];
            arr[i] = arr[tmp - 1];
            arr[tmp - 1] = tmp;
            i--;
        }
        return count;
    }

}

public class MinSwapsToSortArray {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int popularityCount = Integer.parseInt(scanner.nextLine());

        List<Integer> popularity = IntStream.range(0, popularityCount).mapToObj(i -> {
            return scanner.nextLine().replaceAll("\\s+$", "");
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.minimumSwaps(popularity);
        System.out.println(result);
    }
}
