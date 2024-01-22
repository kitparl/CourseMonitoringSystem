package com.usecases;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.Course;
import java.util.Scanner;

public class CreateCourse {
    public static final String TEXT_RESET = "\u001B[0m";
    // Declaring the color
    // Custom declaration
    public static final String TEXT_YELLOW = "\u001B[33m";
    public void createCourse() {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);


        // this is for colour console
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(TEXT_YELLOW +"----------------------------Insert Course------------------------------"+TEXT_RESET);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
//        System.out.print("Enter Course ID : "); int courseId = sc.nextInt();
        System.out.print("Enter Course Name : "); String courseName = sc.next();

        System.out.print("Enter Fees : "); int Fees = sc.nextInt();
        System.out.print("Enter Course Description : "); String courseDescription = sc2.nextLine();

        AdminDao dao = new AdminDaoImpl();

        Course course = new Course();
//        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setFees(Fees);
        course.setCourseDescription(courseDescription);

        String result = dao.createCourse(course);
        System.out.println();
        System.out.println(result);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
}
