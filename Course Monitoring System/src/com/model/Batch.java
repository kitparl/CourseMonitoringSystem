package com.model;

public class Batch {
    private int batchId;
    private int courseId;
    private int facultyId;
    private int numberofStudents;
    private String batchStartDate;
    private int duration;

    public Batch() {}

    public Batch(int batchId, int courseId, int facultyId, int numberOfStudents, String batchStartDate, int duration) {
        this.batchId = batchId;
        this.courseId = courseId;
        this.facultyId = facultyId;
        this.numberofStudents = numberOfStudents;
        this.batchStartDate = batchStartDate;
        this.duration = duration;
    }


    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getNumberOfStudents() {
        return numberofStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberofStudents = numberOfStudents;
    }

    public String getBatchStartDate() {
        return batchStartDate;
    }

    public void setBatchStartDate(String batchStartDate) {
        this.batchStartDate = batchStartDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchId=" + batchId +
                ", courseId=" + courseId +
                ", facultyId=" + facultyId +
                ", numberOfStudents=" + numberofStudents +
                ", batchStartDate='" + batchStartDate + '\'' +
                ", duration=" + duration +
                '}';
    }
}
