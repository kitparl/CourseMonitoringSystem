package com.usecases;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exceptions.AdminException;

import java.util.Scanner;

public class UpdateFaculty {
    public void updateFaculty() {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.print("Enter Your Faculty Id : "); int facultyId = sc1.nextInt();

        System.out.println();
        System.out.println("Now Enter Updates Values : ");
        System.out.println();
        sc1.nextLine();
        System.out.print("Enter Faculty Name : "); String facultyName = sc1.nextLine();

        System.out.print("Enter Faculty Address : "); String facultyAddress = sc2.nextLine();
        System.out.print("Enter Mobile Number : "); long mobile = sc1.nextLong();
        System.out.print("Enter Email Address : "); String email = sc1.next();
        System.out.print("Enter Username : "); String username = sc1.next();
        System.out.print("Enter Password : "); String password = sc1.next();

        AdminDao dao = new AdminDaoImpl();
        String result = null;
        try {
            result = dao.updateFaculty(facultyId,facultyName,facultyAddress,mobile,email,username,password);
        } catch (AdminException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);

    }
}
