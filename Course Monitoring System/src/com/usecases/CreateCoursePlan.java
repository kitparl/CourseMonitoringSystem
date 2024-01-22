package com.usecases;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.model.CoursePlan;

import java.util.Scanner;

public class CreateCoursePlan {

    public static final String TEXT_RESET = "\u001B[0m";
    // Declaring the color
    // Custom declaration
    public static final String TEXT_YELLOW = "\u001B[33m";


    public void createCoursePlan() {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

    // this is for colour console
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(TEXT_YELLOW +"----------------------------Insert Course Plan------------------------------"+TEXT_RESET);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println();
//        System.out.print("Enter Plan ID : "); int planId = sc.nextInt();
        System.out.print("Enter Batch ID : "); int batchId = sc.nextInt();
        System.out.print("Enter Day Number : "); int daynumber = sc.nextInt();
        System.out.print("Enter Topic : "); String topic = sc2.nextLine();
        System.out.print("Enter Status (completed/pending) : "); String status = sc.next();

    AdminDao dao = new AdminDaoImpl();

    CoursePlan cp = new CoursePlan();
//    cp.setPlanId(planId);
    cp.setBatchId(batchId);
    cp.setDaynumber(daynumber);
    cp.setTopic(topic);
    cp.setStatus(status);



    String result = dao.createCoursePlan(cp);
        System.out.println();
        System.out.println(result);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
}
}

