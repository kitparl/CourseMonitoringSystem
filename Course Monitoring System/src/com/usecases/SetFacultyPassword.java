package com.usecases;

import com.dao.FacultyDao;
import com.dao.FacultyDaoImpl;
import com.model.Faculty;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SetFacultyPassword {
    public String setFacultyPassword() {
        String pwd = null;
        Scanner sc = new Scanner(System.in);
        System.out.println();
//        System.out.println("Enter Updated Password");
//        System.out.println();
        System.out.print("Enter New Password : ");
        String newPassword = sc.next();
        System.out.print("Confirm Password : ");
        String confirmPassword = sc.next();

        FacultyDao dao = new FacultyDaoImpl();
//        Faculty f = new Faculty();

        if (newPassword.equals(confirmPassword)) {
            pwd = newPassword;
        }
        else{
            System.out.println("Password not matched....");
            System.out.println();
            System.exit(0);
        }
        return pwd;
    }
}
