package com.example.shubhamr.collegesearch.RecyclerViews.courseRecyclerView;

public class courseModelClass {

    private String courseName;
    private String courseShortName;

    public courseModelClass(){}

    public courseModelClass(String courseShortName,String courseName){
        this.courseName = courseName;
        this.courseShortName = courseShortName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseShortName() {
        return courseShortName;
    }

    public void setCourseShortName(String courseShortName) {
        this.courseShortName = courseShortName;
    }
}
