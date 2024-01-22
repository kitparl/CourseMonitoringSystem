package com.dao;

import com.exceptions.AdminException;
import com.model.Batch;
import com.model.Course;
import com.model.CoursePlan;
import com.model.Faculty;

import java.util.List;

public interface AdminDao {
String createCourse(Course course);
String createFaculty(Faculty faculty);
String createBatch(Batch faculty);
String createCoursePlan(CoursePlan cp);


    String updateCourse(int courseId, String courseName, long fees, String description) throws AdminException;
    String updateFaculty(int facultyId, String facultyName, String facultyAddress, long mobile, String email, String username, String password) throws AdminException;
    String updateBatch(int batchId, int CourseId, int facultyId, long numberofStudents,String batchstartDate, int duration) throws AdminException;
    String updateCoursePlan(int planId, int batchId, int dayNumber, String topic, String status);


    void viewCourse();
    void viewFaculty();
    void viewBatch();
    void viewCoursePlan();


}
