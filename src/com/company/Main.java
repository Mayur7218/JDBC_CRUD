package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StudentOperations so=new StudentOperations();
        StudentValidation sv=new StudentValidation();
        boolean set=true;
        while(set){
            System.out.println("\n1. Create a new Student");
            System.out.println("2. Retrieve all the Students");
            System.out.println("3. Retrieve Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println();
            System.out.println("Choose different number to exit ");

            int option =sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("1. Enter your id");
                    int id=sc.nextInt();
                    System.out.println("2. Enter your name");
                    String name=sc.next();
                    System.out.print("Enter Student Age (18-25): ");
                    int age = sv.validateAge(sc);
                    System.out.print("Enter Student Grade (0.0-4.0): ");
                    double grade = sv.validateGrade(sc);
                    System.out.println("5. Enter your course");
                    String course=sc.next();
                    so.CreateStudent(id,name,age,grade,course);
                    break;
                case 2:
                    so.RetrieveAll();
                    break;
                case 3:
                    System.out.print("Enter the ID : ");
                    int identity=sc.nextInt();
                    so.RetrieveById(identity);
                    break;
                case 4:
                    so.UpdateStudent();
                    break;
                case 5:
                    so.DeleteStudent();
                    break;
                default:
                    set=false;
                    System.out.println("Exit Operations");
                    break;
            }
        }



    }
}