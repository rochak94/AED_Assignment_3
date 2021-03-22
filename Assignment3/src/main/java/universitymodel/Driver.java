/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import universitymodel.CourseCatalog.Course;
import universitymodel.CourseSchedule.CourseLoad;
import universitymodel.CourseSchedule.CourseOffering;
import universitymodel.CourseSchedule.SeatAssignment;
import universitymodel.Department.College;
import universitymodel.Department.Department;
import universitymodel.Employment.EmploymentProfile;
import universitymodel.Faculty.FacultyProfile;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class Driver {
    
    public static void main(String args[]){
    
    Faker faker = new Faker();
    College collegeA = new College("CollegeA");
    
    Department deptA = new Department("DeptA",collegeA); 
    Department deptB = new Department("DeptB",collegeA); 
    Department deptC = new Department("DeptC",collegeA); 
    Department deptD = new Department("DeptD",collegeA); 
    Department deptE = new Department("DeptE",collegeA); 
    Department deptF = new Department("DeptF",collegeA); 
    
     FakeValuesService fakeValuesService = new FakeValuesService(
      new Locale("en-GB"), new RandomService());
     
     //Generating a bunch of courses
    ArrayList<Course> courseList = new ArrayList<>();
    
    for(int i = 0; i< 50; i++){
        String courseName = fakeValuesService.bothify("Course ??");
        String courseNo = fakeValuesService.bothify("###");
        courseList.add(new Course(courseName,courseNo,2));
    }
    
    for(Course course:courseList){
        System.out.println(course.getName());
    }

    //Generating a bunch of students
    ArrayList<StudentProfile> testStudentList = new ArrayList<>();
    
    
    for(int i = 0; i< 15;i++){
        deptA.addStudent(new StudentProfile(faker.name().name()));
        deptB.addStudent(new StudentProfile(faker.name().name()));
        deptC.addStudent(new StudentProfile(faker.name().name()));
        deptD.addStudent(new StudentProfile(faker.name().name()));
        deptE.addStudent(new StudentProfile(faker.name().name()));
        deptF.addStudent(new StudentProfile(faker.name().name()));
    }
    
    for(Department dept:collegeA.getDeptList()){
        for(StudentProfile student:dept.getStudentList()){
            int randomNum = ThreadLocalRandom.current().nextInt(50000, 350000);
            student.setEmpProfile(new EmploymentProfile(student,randomNum));
        }
    }
    
    for(Department dept:collegeA.getDeptList()){
        dept.computeAverageSalary();
     }
    }
}
    

