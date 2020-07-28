package com.karkia.algorithms.greedy;

import java.util.*;

// https://www.hackerrank.com/challenges/jim-and-the-orders/problem
// Time Complexity: O(n log(n)) //We sort the input
// Space Complexity: O(n) //We must store all of the input for sorting
public class JimAndTheOrders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCustomers = scanner.nextInt();

        // <customer-num, serve-time(order-num+prep-time)>
        Map<Integer, Integer> customerServeTimesMap = new LinkedHashMap<>();
        for (int i = 1; i <= numCustomers; i++) {
            customerServeTimesMap.put(
                    i,
                    (scanner.nextInt() + scanner.nextInt())
            );
        }

        scanner.close();

        Set<Map.Entry<Integer, Integer>> entrySet = customerServeTimesMap.entrySet();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(entrySet);
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                // sort based on sort time
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entryItem : entryList) {
            System.out.print(entryItem.getKey() + " ");
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int numCustomers = scanner.nextInt();
//
//        int[][] orders = new int[numCustomers][2];
//        for (int i = 0; i < numCustomers; i++) {
//            // orders[i] = [order[i], prep[i]]
//            orders[i][0] = scanner.nextInt();
//            orders[i][1] = scanner.nextInt();
//        }
//
//        // REMEMBER: Start by numbering each of the customers from 1 to n,
//        // front of the line to the back.
//        int[] serveTimes = new int[numCustomers];
//        // serveTime = order-num + prep-time
//        for (int i = 0; i < numCustomers; i++) {
//            // the index "i" represents the customer-num
//            serveTimes[i] = orders[i][0] + orders[i][1];
//        }
//
//        // sort serveTimes in ascending and
//        // if two orders have same serve time, then order them by customer# asc
//        Arrays.sort(serveTimes);
//    }
}
