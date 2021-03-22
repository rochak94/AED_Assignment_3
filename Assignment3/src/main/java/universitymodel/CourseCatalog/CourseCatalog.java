/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.CourseCatalog;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Skanda
 */
public class CourseCatalog {
    String courseDescription;
    ArrayList<Course> courseList;
    Date updatedAt;
    
    public CourseCatalog(){
        courseList = new ArrayList<>();
    }
    
    public void addCourse(Course c){
       this.courseList.add(c);
       this.updatedAt = new Date();
    }
    
    public Course getCourse(String name){
        for(Course course:courseList){
            if(course.getName().equals(name)){
                return course;
            }
        }
        return null;
    }
    

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
