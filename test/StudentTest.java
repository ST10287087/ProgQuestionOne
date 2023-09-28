/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import org.junit.BeforeClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import progouestiononeanswer.Student;

public class StudentTest {
    private final ArrayList<String> studentInformation = new ArrayList<>();
    private final InputStream originalSystemIn = System.in;
    
    @BeforeClass
    public static void setUp() {
        // Reset studentInformation and redirect System.in to avoid user input in tests
        studentInformation.clear();
        System.setIn(originalSystemIn);
    }

    @Test
    public void testSaveStudent() {
        // Mock user input
        String input = "John\n123\n18\nMath\njohn@example.com\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Student.SaveStudent();

        assertEquals(1, studentInformation.size());
    }

    @Test
    public void testSearchStudent() {
        // Add a student to the list
        studentInformation.add("STUDENT 1\n--------------------------------------\nSTUDENT ID: 123\nSTUDENT NAME: John\nSTUDENT AGE: 18\nSTUDENT EMAIL: john@example.com\nSTUDENT COURSE: Math\n--------------------------------------");

        // Mock user input
        String input = "123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Student.SearchStudent();

        // Ensure the output contains the success message
        assertTrue(getSystemOut().contains("Student 123 has been found!"));
    }

    @Test
    public void testDeleteStudent() {
        // Add a student to the list
        studentInformation.add("STUDENT 1\n--------------------------------------\nSTUDENT ID: 123\nSTUDENT NAME: John\nSTUDENT AGE: 18\nSTUDENT EMAIL: john@example.com\nSTUDENT COURSE: Math\n--------------------------------------");

        // Mock user input
        String input = "123\ny\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Student.DeleteStudent();

        // Ensure the output contains the success message
        assertTrue(getSystemOut().contains("123 Has been successfully removed from the system"));
        assertEquals(0, studentInformation.size());
    }

    @Test
    public void testStudentReport() {
        // Add a student to the list
        studentInformation.add("STUDENT 1\n--------------------------------------\nSTUDENT ID: 123\nSTUDENT NAME: John\nSTUDENT AGE: 18\nSTUDENT EMAIL: john@example.com\nSTUDENT COURSE: Math\n--------------------------------------");

        // Capture the output of the StudentReport method
        String output = captureSystemOut(() -> Student.StudentReport());

        // Ensure the output contains the student information
        assertTrue(output.contains("STUDENT 1\n--------------------------------------\nSTUDENT ID: 123\nSTUDENT NAME: John\nSTUDENT AGE: 18\nSTUDENT EMAIL: john@example.com\nSTUDENT COURSE: Math\n--------------------------------------"));
    }

    private String getSystemOut() {
        return outContent.toString();
    }

    private String captureSystemOut(Runnable code) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        code.run();

        System.setOut(originalOut);
        return outputStream.toString();
    }
}