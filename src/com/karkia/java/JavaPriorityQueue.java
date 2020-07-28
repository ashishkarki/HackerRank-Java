package com.karkia.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-priority-queue/problem
/*
 * Create the Student and Priorities classes here.
 */
class Priorities {

    public List<Student> getStudents(List<String> events) {
        return null;
    }
}

public class JavaPriorityQueue {
    static class Student {
        private int id;
        private String name;
        private double cgpa;

        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }
    }

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        //List<Student> students = priorities.getStudents(events);
//
//        if (students.isEmpty()) {
//            System.out.println("EMPTY");
//        } else {
//            for (Student st : students) {
//                System.out.println(st.getName());
//            }
//        }
    }
}
