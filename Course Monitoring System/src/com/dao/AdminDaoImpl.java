package com.dao;

import com.exceptions.AdminException;
import com.model.Batch;
import com.model.Course;
import com.model.CoursePlan;
import com.model.Faculty;
import com.utility.DBUtil;

import javax.swing.event.ListDataEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao{

    // Take input and Insert data to database
    @Override
    public String createCourse(Course course) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into course(courseName,fee,courseDescription) values (?,?,?)");
//            ps.setInt(1,course.getCourseId());
            ps.setString(1,course.getCourseName());
            ps.setInt(2,course.getFees());
            ps.setString(3,course.getCourseDescription());

            int x = ps.executeUpdate();

            if(x>0){
                msg = "Course Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }


        return msg;
    }

    @Override
    public String createFaculty(Faculty faculty) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email,username,password) values (?,?,?,?,?,?)");
            ps.setString(1,faculty.getFacultyName());
            ps.setString(2,faculty.getFacultyAddress());
            ps.setLong(3,faculty.getMobile());
            ps.setString(4,faculty.getEmail());
            ps.setString(5,faculty.getUsername());
            ps.setString(6,faculty.getPassword());


            int x = ps.executeUpdate();

            if(x>0){
                msg = "Faculty Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }


        return msg;
    }

    @Override
    public String createBatch(Batch batch) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into batch(courseId,facultyId,numberofStudents,batchstartDate,duration) values (?,?,?,?,?)");
//            ps.setInt(1,batch.setBatchId());
            ps.setInt(1,batch.getCourseId());
            ps.setInt(2,batch.getFacultyId());
            ps.setInt(3,batch.getNumberOfStudents());
            ps.setString(4,batch.getBatchStartDate());
            ps.setLong(5,batch.getDuration());


            int x = ps.executeUpdate();

            if(x>0){
                msg = "Batch Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return msg;
    }

    @Override
    public String createCoursePlan(CoursePlan cp) {
        String msg = "Not inserted...";

        try(Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("insert into courseplan(batchId,daynumber,topic,status) values (?,?,?,?)");
//            ps.setInt(1,batch.setBatchId());
            ps.setInt(1,cp.getBatchId());
            ps.setInt(2,cp.getDaynumber());
            ps.setString(3,cp.getTopic());
            ps.setString(4,cp.getStatus());


            int x = ps.executeUpdate();

            if(x>0){
                msg = "Batch Inserted Successfully...";
            }
        }catch (SQLException e) {

            throw new RuntimeException(e);
        }
        return msg;
    }

    // Take input and update data to database

    @Override
    public String updateCourse(int courseId, String courseName, long fees, String description) throws AdminException {

        String msg = "Not Updated...";

        try (Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("update course set fee=?,courseName=?, courseDescription=? where courseId=?");

            ps.setLong(1,fees);
            ps.setString(2,courseName);
            ps.setString(3,description);
            ps.setInt(4,courseId);

            ps.executeUpdate();
            msg = "Updated...";

        }catch (SQLException e){
            e.printStackTrace();
        }

        return msg;
    }

    @Override
    public String updateFaculty(int facultyId, String facultyName, String facultyAddress, long mobile, String email, String username, String password) {

        String msg = "Not Updated...";

        try (Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("update faculty set facultyName=?,facultyAddress=?,mobile=?,email=?,password=? where facultyId=?");

            ps.setString(1,facultyName);
            ps.setString(2,facultyAddress);
            ps.setLong(3,mobile);
            ps.setString(4,email);
            ps.setString(5,password);
            ps.setInt(6,facultyId);

            ps.executeUpdate();
            msg = "Updated...";

        }catch (SQLException e){
            e.printStackTrace();
        }

        return msg;
    }

    @Override
    public String updateBatch(int batchId, int CourseId, int facultyId, long numberofStudents, String batchstartDate, int duration) throws AdminException {
                String msg = "Not Updated...";

        try (Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("update batch set courseId=?,facultyId=?,numberofStudents=?,batchstartDate=?,duration=? where batchId=?");

            ps.setInt(1,CourseId);
            ps.setInt(2,facultyId);
            ps.setLong(3,numberofStudents);
            ps.setString(4,batchstartDate);
            ps.setInt(5,duration);
            ps.setInt(6,batchId);

            ps.executeUpdate();
            msg = "Updated...";

        }catch (SQLException e){
            e.printStackTrace();
        }

        return msg;
    }

    @Override
    public String updateCoursePlan(int planId, int batchId, int dayNumber, String topic, String status) {
        String msg = "Not Updated...";

        try (Connection con = DBUtil.provideConnection()){
            PreparedStatement ps = con.prepareStatement("update coursePlan set batchId=?,daynumber=?,topic=?,status = ? where planId=?");

            ps.setInt(1,batchId);
            ps.setInt(2,dayNumber);
            ps.setString(3,topic);
            ps.setString(4,status);
            ps.setInt(5,planId);


            ps.executeUpdate();
            msg = "Updated...";

        }catch (SQLException e){
            e.printStackTrace();
        }

        return msg;
    }


    // view

    @Override
    public void viewCourse() {
    try(Connection con = DBUtil.provideConnection()){

        PreparedStatement ps = con.prepareStatement("select * from course");
        ResultSet set = ps.executeQuery();

            System.out.println("###############################################################################");
        while (set.next()){
            int courseId = set.getInt(1);
            String courseName = set.getString(2);
            long fee = set.getLong(3);
            String courseDescription = set.getString(4);
            System.out.println("| Course Id -> "+courseId+" | Course Name -> "+courseName+" | Fee -> "+fee+" | Course Descripition -> "+courseDescription+" |");
        }
        System.out.println("###############################################################################");

//        ps.setString(1,);


    }catch (SQLException e){
        e.printStackTrace();
    }
    }

    @Override
    public void viewFaculty() {
        try(Connection con = DBUtil.provideConnection()){

            PreparedStatement ps = con.prepareStatement("select * from faculty");
            ResultSet set = ps.executeQuery();

            System.out.println("###############################################################################");
            while (set.next()){
                int facultyid = set.getInt(1);
                String facultyname = set.getString(2);
                String facultyaddress = set.getString(3);

                long mobile = set.getLong(4);
                String email = set.getString(5);
                String username = set.getString(6);
                String password = set.getString(7);

                System.out.println("| Faculty ID -> "+facultyid+" | Faculty Name -> "+facultyname+" | Faculty Address -> "+facultyaddress+" | Mobile Number -> "+mobile+" | Email -> "+email+"| Username -> "+username+"| Password -> "+password+" |");
            }
            System.out.println("###############################################################################");

//        ps.setString(1,);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void viewBatch() {
        try(Connection con = DBUtil.provideConnection()){

            PreparedStatement ps = con.prepareStatement("select * from batch");
            ResultSet set = ps.executeQuery();

            System.out.println("###############################################################################");
            while (set.next()){
                int batchId = set.getInt(1);
                int courseId = set.getInt(2);
                int facultyId = set.getInt(3);

                long numberofStudents = set.getLong(4);
                String batchstartDate = set.getString(5);
                String duration = set.getString(6);

                System.out.println("| Batch ID -> "+batchId+" | Course Id -> "+courseId+" | Faculty Id -> "+facultyId+" | Number of Students -> "+numberofStudents+" | Batch Start Date -> "+batchstartDate+"| Duration -> "+duration+" |");
            }
            System.out.println("###############################################################################");

//        ps.setString(1,);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void viewCoursePlan() {
        try(Connection con = DBUtil.provideConnection()){

            PreparedStatement ps = con.prepareStatement("select * from coursePlan");
            ResultSet set = ps.executeQuery();

            System.out.println("###############################################################################");
            while (set.next()){
                int planId = set.getInt(1);
                int batchId = set.getInt(2);
                int daynumber = set.getInt(3);
                String topic = set.getString(4);
                String status = set.getString(5);

                System.out.println("| Batch ID -> "+planId+" | Course Id -> "+batchId+" | Faculty Id -> "+daynumber+" | Number of Students -> "+topic+" | Batch Start Date -> "+status+" |");
            }
            System.out.println("###############################################################################");

//        ps.setString(1,);


        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}

