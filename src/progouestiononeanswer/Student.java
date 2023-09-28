/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progouestiononeanswer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */

public class Student {
    private int studentID;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentCourse;
    private static ArrayList<String> studentInformation = new ArrayList<>();
    private static Scanner kb = new Scanner(System.in);
    private static int studentCounter = 1;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        if (studentAge >= 16) {
            this.studentAge = studentAge;
        } else {
            System.out.println("Invalid age! The student must be 16 years or older.");
        }
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public static void SaveStudent() {
        Student student = new Student();

        System.out.println("Please enter the name of the student you would like to add");
        student.setStudentName(kb.nextLine());

        System.out.println("Please enter the ID of the student you would like to add");
        student.setStudentID(kb.nextInt());
        kb.nextLine();

        System.out.println("Please enter the age of the student you would like to add");
        student.setStudentAge(kb.nextInt());
        kb.nextLine();

        System.out.println("Please enter the course of the new student");
        student.setStudentCourse(kb.nextLine());

        System.out.println("Please enter the Student's email");
        student.setStudentEmail(kb.nextLine());

        String studentInfoList = "STUDENT " + studentCounter
                + "\n--------------------------------------"
                + "\nSTUDENT ID: " + student.getStudentID()
                + "\nSTUDENT NAME: " + student.getStudentName()
                + "\nSTUDENT AGE: " + student.getStudentAge()
                + "\nSTUDENT EMAIL: " + student.getStudentEmail()
                + "\nSTUDENT COURSE: " + student.getStudentCourse()
                + "\n--------------------------------------";
        studentInformation.add(studentInfoList);
        System.out.println("Your details have been successfully saved.");
        studentCounter++;
    }

      public static void SearchStudent()
    {
        String userEnteredID;
        System.out.println("Enter the student id to search");
        userEnteredID = kb.nextLine();
        
       for( String studentInfoList : studentInformation ){
            if (studentInfoList.contains(userEnteredID)) 
            {
                System.out.println( "Student" + userEnteredID + " has been found!");
                return;
            }
        }
        System.out.println("the student "+ userEnteredID + " cannot be located");
        }
    
    
    public static void DeleteStudent()
    {
        String requestedDel;
        String answerConfirmation;
        System.out.println("Please enter the Id of the student you want to remove");
        requestedDel = kb.nextLine();
        System.out.println("Are you sure you want to remove " + requestedDel + " type (y) to delete");
        answerConfirmation = kb.nextLine();
        if("y".equals(answerConfirmation))
        {
            for(String studentInfoList : studentInformation )
            {
                if (studentInfoList.contains(requestedDel))
                {
                    studentInformation.remove(studentInfoList);
                    System.out.println(requestedDel + " Has been successfullly removed from the system"); ProgOuestionOneAnswer.firstMenu();
                }
            }
        } System.out.println("Sorry! student ID " + requestedDel + " could not be found" );
    }
    
    public static void StudentReport()
    {
        for(String studentInfoList : studentInformation )
        {
            System.out.println(studentInfoList);
            
        }
    }
    
    public static void ExitStudentApplication ()
    {
          System.out.println("Exiting Student Management Application.");
        System.exit(0);
    }
}