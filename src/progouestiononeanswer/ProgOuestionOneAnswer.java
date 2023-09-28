/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progouestiononeanswer;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class ProgOuestionOneAnswer {
    /**
     * @ST10287087
     */
   private static Scanner kb = new Scanner(System.in);
    Student student = new Student();
    public static void main(String[] args) {
        firstMenu();
    }
    
    public static void firstMenu()
    {
        int userInputOne;
        System.out.println("\nSTUDENT MANAGMENT MATERIAL");
        System.out.println("***********************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        userInputOne = kb.nextInt();
        switch(userInputOne)
        {
            case 1: System.out.println("Please select one of the following menu items:"
                    + "\n1. Capture a new student"
                    + "\n2. Search for a student"
                    + "\n3. Delete a student"
                    + "\n4. Print a student report"
                    + "\n5. Exit Application");
            int userInputTwo;
            userInputTwo = kb.nextInt();
            switch(userInputTwo)
            {
                case 1: Student.SaveStudent();firstMenu();break;
                case 2: Student.SearchStudent();firstMenu();break;
                case 3: Student.DeleteStudent();firstMenu();break;
                case 4: Student.StudentReport();firstMenu();break;
                case 5: Student.ExitStudentApplication();break;
            }
            default: System.out.println("Thats not an option!"); firstMenu();break;
        }
    }
    
}
