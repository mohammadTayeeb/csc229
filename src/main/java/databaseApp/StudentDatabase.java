package databaseApp;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

public class StudentDatabase {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sC;   //number of students to enroll
        System.out.println("Enter the number of Students you would like to enroll: ");
        sC = input.nextLine();   //number of students to enroll
        while ((!NumberUtils.isParsable(sC)) || (Integer.parseInt(sC) < 0)) {
            System.out.println("Invalid input! ENTER an Integer please.");
            System.out.println("Enter the number of Students you would like to enroll: ");
            sC = input.nextLine();
        }
        int sCount = Integer.parseInt(sC);

        Student[] students = new Student[sCount];   //array of the student objects

        //create a number of new students
        for (int i = 0; i < sCount; i++) {
            students[i] = new Student();
            students[i].enroll();
            students[i].payBal();
            //System.out.println(students [i].showInfo());
        }
        System.out.println("""
                     INFORMATION OF ALL STUDENTS LISTED BELOW
                ==================================================""");
        int count = 1;
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student: " + count + "\n");
            System.out.println(students[i].toString());
            count++;
        }
    }
}

