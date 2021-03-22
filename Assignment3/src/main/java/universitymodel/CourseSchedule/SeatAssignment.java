/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.CourseSchedule;

import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class SeatAssignment {

        CourseLoad courseload;
        double grade;
        CourseOffering courseOffer;
        StudentProfile student;
        boolean isOccupied;
    public SeatAssignment(CourseOffering courseOffer){
        this.courseOffer = courseOffer;
        this.isOccupied = false;
        
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    
    public CourseOffering getCourseOffer() {
        return courseOffer;
    }

    public void setCourseOffer(CourseOffering courseOffer) {
        this.courseOffer = courseOffer;
    }

        
    
    public void assignSeatToStudent(CourseLoad cl){
        courseload = cl;
    }

    public StudentProfile getStudent() {
        return student;
    }

    public void setStudent(StudentProfile student) {
        this.student = student;
    }



    public CourseLoad getCourseload() {
        return courseload;
    }

    public void setCourseload(CourseLoad courseload) {
        this.courseload = courseload;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    
    
}
