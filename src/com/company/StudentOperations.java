package com.company;

import java.sql.*;
import java.util.Scanner;

public class StudentOperations {
    Scanner sc=new Scanner(System.in);

    public void CreateStudent(int id,String name,int age,double grade,String course){

        String query="insert into students (id, name, age, grade, course) values (?,?,?,?,?)";
        try(Connection connection= DriverManager.getConnection("jdbc:mariadb://localhost:3306/Students","root","Mayur7218@");
            PreparedStatement prepare=connection.prepareStatement(query)){

            prepare.setInt(1,id);
            prepare.setString(2,name);
            prepare.setInt(3,age);
            prepare.setDouble(4,grade);
            prepare.setString(5,course);

            int rowAffected=prepare.executeUpdate();
            System.out.println(rowAffected + " student is being created");

        }catch (SQLException e) {
            System.out.println("Error in Creating : "+e.getMessage());
        }
    }
    public void RetrieveAll(){
        try(Connection connection=DriverManager.getConnection("jdbc:mariadb://localhost:3306/Students","root","Mayur7218@");
            Statement statement=connection.createStatement();
            ResultSet rm=statement.executeQuery("select * from students")){



            while(rm.next()){
                int id=rm.getInt("id");
                String name=rm.getString("name");
                int age=rm.getInt("age");
                double grade=rm.getDouble("grade");
                String course=rm.getString("course");

                System.out.println("ID :"+id+" Name :"+name+" Age :"+age+" Grade :"+grade+" Course :"+course);
            }

        }catch (SQLException e){
            System.out.println("Error in Retrieving : "+e.getMessage());
        }
    }
    public void RetrieveById(int id){
        String query="select * from students where id =?";
        try(Connection connection=DriverManager.getConnection("jdbc:mariadb://localhost:3306/Students","root","Mayur7218@");
            PreparedStatement prepare=connection.prepareStatement(query)){

            prepare.setInt(1,id);

            ResultSet rm=prepare.executeQuery();
            while(rm.next()){
                 int i=rm.getInt("id");
                 String name=rm.getString("name");
                 int age=rm.getInt("age");
                 double grade=rm.getDouble("grade");
                 String course=rm.getString("course");

                System.out.println("ID :"+i+" Name :"+name+" Age :"+age+" Grade :"+grade+" Course :"+course);
            }
            rm.close();

        }catch (SQLException e){
            System.out.println("Error in retrieving by ID : "+e.getMessage());
        }
    }
    public void UpdateStudent(){
        System.out.print("Enter the Student ID to be updated : ");
        int id=sc.nextInt();
        sc.nextLine();
        String query="update students set name=?, age=?, grade=?, course=? where id=?";
        try( Connection connection=DriverManager.getConnection("jdbc:mariadb://localhost:3306/Students","root","Mayur7218@");
             PreparedStatement prepare=connection.prepareStatement(query)){

            System.out.println("Enter the New Name :");
            String name=sc.nextLine();
            System.out.println("Enter the New Age :");
            int age=sc.nextInt();
            System.out.println("Enter the New Grade :");
            double grade=sc.nextDouble();
            System.out.println("Enter the New Course :");
            String course=sc.next();

            prepare.setString(1,name);
            prepare.setInt(2,age);
            prepare.setDouble(3,grade);
            prepare.setString(4,course);
            prepare.setInt(5,id);

            int resultNo=prepare.executeUpdate();
            if(resultNo>0){
                System.out.println("Successfully Updated!");
            }else{
                System.out.println("No student with id "+id+" is present!");
            }


        }catch (SQLException e){
            System.out.println("Error in Updating records : "+e.getMessage());
        }
    }
    public void DeleteStudent(){
        System.out.print("Enter the Student ID to be deleted : ");
        int id=sc.nextInt();
        sc.nextLine();
        String query="delete from students where id =?";
        try(Connection connection=DriverManager.getConnection("jdbc:mariadb://localhost:3306/Students","root","Mayur7218@");
            PreparedStatement prepare=connection.prepareStatement(query)){

            prepare.setInt(1,id);
            int resultNo=prepare.executeUpdate();
            if(resultNo>0){
                System.out.println("Successfully deleted!");
            }
            else{
                System.out.println("No student with id "+id+" is present!");
            }

        }catch (SQLException e){
            System.out.println("Error in Deleting the record : "+e.getMessage());
        }
    }

}
