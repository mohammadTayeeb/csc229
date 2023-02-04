package databaseApp;

import org.apache.commons.lang3.math.NumberUtils;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String year;
    private int gradYr;         //freshmen|sophomore|junior|senior: year status
    private String studentID;
    private String courses = "";
    private int tBalance = 0;   //tuition balance
    private static int courseCost = 600;
    private static int id = 1000;

    //Constructor: prompt user to enter student name and year
    public Student() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the First Name of the Student: ");
        this.firstName = input.nextLine();

        System.out.println("Enter the Last Name of the Student: ");
        this.lastName = input.nextLine();

        System.out.println("Choose a number for a Status: \n1. Freshmen.\n2. Sophomore.\n3. Junior.\n4. Senior.");
        this.year = input.nextLine();
        while ((!NumberUtils.isParsable(year)) || (Integer.parseInt(year) <= 0) || ((Integer.parseInt(year) > 4))) {
            System.out.println("INVALID INPUT!");
            System.out.println("Choose a number for a Status: \n1. Freshmen.\n2. Sophomore.\n3. Junior.\n4. Senior.");
            this.year = input.nextLine();
        }
        this.gradYr = Integer.parseInt(year);
        idSetter();
    }

    //generate an id
    private void idSetter() {
        //Grade level + ID
        id++;
        this.studentID = gradYr + "" + id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    //enroll in courses
    public void enroll() {
        String course;
        do {
            Scanner input = new Scanner(System.in);
            //get inside a loop, user hits ZERO
            System.out.print("Enter Course to enroll [q to quit] : ");
            course = input.nextLine();

            if (course.equals("Q")) {
                course = course.toLowerCase();
            }
            if (!course.equals("q")) {
                courses += "\n" + course;
                tBalance = tBalance + courseCost;
            } else {
                break;
            }
        } while (!course.equals("q"));
    }

    //view balance
    public void checkBal() {
        System.out.println("The Tuition Balance is: $" + tBalance + "\n");
    }

    // pay tuition
    public void payBal() {
        checkBal();
        int payment;
        Scanner input = new Scanner(System.in);
        System.out.println("How much in $ would you like to pay for your tuition?");
        payment = input.nextInt();
        tBalance = tBalance - payment;
        System.out.println("Payment of $" + payment + " has been paid.");
        checkBal();
    }

    //show status
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
                "Grade Level: " + gradYr + "\n" +
                "Student ID: " + studentID + "\n\n" +
                "Courses Enrolled: " + courses + "\n\n" +
                "Balance: $" + tBalance + "\n";
    }
}