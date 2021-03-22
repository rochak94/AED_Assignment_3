/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.CourseSchedule;

import java.util.ArrayList;
import universitymodel.CourseCatalog.Course;
import universitymodel.Department.Department;
import universitymodel.Faculty.FacultyProfile;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class CourseOffering {
    Course course;
    ArrayList<SeatAssignment> seatlist;
    FacultyProfile facultyassignment;
    Department department;
    int classSize;
    String semester;
    int year;
    public CourseOffering(Course c,int size,FacultyProfile faculty,Department department) {
        this.course = c;
        this.classSize = size;
        this.seatlist = new ArrayList();     
        this.facultyassignment = faculty;
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    



    public boolean addStudent(StudentProfile student){
        if(this.seatlist.size() <= classSize){
            SeatAssignment seat = new SeatAssignment(this);
            seat.setStudent(student);
            seat.isOccupied = true;
            this.seatlist.add(seat);
            student.getClasses().add(seat);
            return true;
        }
        return false;
    }



    public int getTotalCourseRevenues() {

        int sum = 0;

        for (SeatAssignment s : seatlist) {
            if (s.getIsOccupied() == true) {
                sum = sum + course.getPrice();
            }

        }
        return sum;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<SeatAssignment> getSeatlist() {
        return seatlist;
    }

    public void setSeatlist(ArrayList<SeatAssignment> seatlist) {
        this.seatlist = seatlist;
    }

    public FacultyProfile getFacultyassignment() {
        return facultyassignment;
    }

    public void setFacultyassignment(FacultyProfile facultyassignment) {
        this.facultyassignment = facultyassignment;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
}
