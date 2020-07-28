package com.karkia.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-list/problem
public class JavaList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfElementsInList = in.nextInt();

        List<Integer> inputList = new ArrayList<>();
        while (numOfElementsInList-- > 0) {
            inputList.add(in.nextInt());
        }

        int numOfQueries = in.nextInt();
        for (int i = 0; i < numOfQueries; i++) {
            String action = in.next();
            if (action.equals("Insert")) {
                final int indeX = in.nextInt();
                final int elemY = in.nextInt();
                inputList.add(indeX, elemY);
            } else if (action.equals("Delete")) {
                final int indeX = in.nextInt();
                inputList.remove(indeX);
            }
        }
        in.close();

        // print modified list
        inputList.forEach(item -> System.out.print(item + " "));
    }
}
