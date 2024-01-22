package com.usecases;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exceptions.AdminException;

import java.util.Scanner;

public class UpdateCourse {
    public void updateCourse() {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);


        System.out.print("Enter Course ID : ");
        int courseId = sc.nextInt();

        // waiting..... wala code

        System.out.print("Enter Update Course Name : ");
        String courseName = sc2.nextLine();

        System.out.print("Enter Update Fees : ");
        long fee = sc.nextLong();

        System.out.print("Enter Update Course Description : ");
        String description = sc3.nextLine();

        AdminDao dao = new AdminDaoImpl();

        try {
            String msg = dao.updateCourse(courseId,courseName,fee,description);

            System.out.println(msg);

        } catch (AdminException e) {
            throw new RuntimeException(e);
        }


    }
}
