package com.usecases;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.Faculty;

import java.io.InputStream;
import java.util.Scanner;

public class CreateFaculty {
    public static final String TEXT_RESET = "\u001B[0m";
    // Declaring the color
    // Custom declaration
    public static final String TEXT_YELLOW = "\u001B[33m";
    public void createFaculty() {

        Scanner sc1 = new Scanner(System.in);
//        Scanner sc1 = new Scanner(InputStream input);

        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        Scanner sc5 = new Scanner(System.in);
        Scanner sc6 = new Scanner(System.in);


        // this is for colour console
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(TEXT_YELLOW +"----------------------------Insert Faculty------------------------------"+TEXT_RESET);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
//        System.out.print("Enter Faculty ID : "); int facultyId = sc.nextInt();
        System.out.print("Enter Faculty Name : "); String facultyName = sc1.next();
//        sc1.close();
        System.out.print("Enter Faculty Address : ");String facultyAddress = sc2.nextLine();
//        sc2.close();
        System.out.print("Enter Mobile Number : "); long mobile = sc3.nextLong();
//        sc3.close();
        System.out.print("Enter Email Address : "); String email = sc4.next();
//        sc4.close();
        System.out.print("Enter Username : "); String username = sc5.next();
//        sc5.close();
        System.out.print("Enter Password : "); String password = sc6.next();
//        sc6.close();


        AdminDao dao = new AdminDaoImpl();

        Faculty faculty = new Faculty();

//        faculty.setFacultyId(facultyId);
        faculty.setFacultyName(facultyName);
        faculty.setFacultyAddress(facultyAddress);
        faculty.setMobile(mobile);
        faculty.setEmail(email);
        faculty.setUsername(username);
        faculty.setPassword(password);

        String result = dao.createFaculty(faculty);
        System.out.println();
        System.out.println(result);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }
}
