package com.company;

import java.util.Scanner;

public class StudentValidation {
    Scanner sc=new Scanner(System.in);

    public int validateAge(Scanner sc) {
        int age;
        while (true) {
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                if (age >= 18 && age <= 25) {
                    break;
                } else {
                    System.out.println("Invalid age! Please enter a value between 18 and 25.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // Clear invalid input
            }
        }
        sc.nextLine(); // Clear the buffer
        return age;
    }

    public double validateGrade(Scanner sc) {
        double grade;
        while (true) {
            if (sc.hasNextDouble()) {
                grade = sc.nextDouble();
                if (grade >= 0.0 && grade <= 4.0) {
                    break;
                } else {
                    System.out.println("Invalid grade! Please enter a value between 0.0 and 4.0.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
            }
        }
        sc.nextLine();
        return grade;
    }
}
