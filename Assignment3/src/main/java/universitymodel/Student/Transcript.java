/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import universitymodel.CourseCatalog.Course;
import universitymodel.CourseSchedule.CourseLoad;
import universitymodel.CourseSchedule.SeatAssignment;

/**
 *
 * @author Skanda
 */
public class Transcript {
    HashMap<String, CourseLoad> courseloadlist;
    
    CourseLoad currentcourseload;
    
    public Transcript(){
        
        courseloadlist = new HashMap<String, CourseLoad>();
        
    }

    public CourseLoad newCourseLoad(String sem){
        
        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }
    
    public double getGpa(){
        int counter = 0;
        double totalGpa = 0.0;
        for(CourseLoad load:courseloadlist.values()){
            for(SeatAssignment seat:load.getSeatassignments()){
                totalGpa+=seat.getGrade();
                counter++;
            }
        }
        
        System.out.println(totalGpa);
        System.out.println(counter);
        totalGpa = totalGpa / counter;
        return totalGpa;
    }
    
    public ArrayList courseList(){
        ArrayList<Course> courseList = new ArrayList<>();
        for(CourseLoad load:courseloadlist.values()){
            for(SeatAssignment seat:load.getSeatassignments()){
                courseList.add(seat.getCourseOffer().getCourse());
            }
        }
        return courseList;
    }
    public CourseLoad getCurrentCourseLoad(){
        
        return currentcourseload;
        
    }
        public CourseLoad getCourseLoadBySemester(String semester){
        
        return courseloadlist.get(semester);
        
    }

    public HashMap<String, CourseLoad> getCourseloadlist() {
        return courseloadlist;
    }

    public void setCourseloadlist(HashMap<String, CourseLoad> courseloadlist) {
        this.courseloadlist = courseloadlist;
    }

    public CourseLoad getCurrentcourseload() {
        return currentcourseload;
    }

    public void setCurrentcourseload(CourseLoad currentcourseload) {
        this.currentcourseload = currentcourseload;
    }
        
}
