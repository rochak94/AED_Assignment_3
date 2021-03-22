/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Student;

import java.util.ArrayList;
import java.util.List;
import universitymodel.CourseSchedule.CourseOffering;
import universitymodel.CourseSchedule.SeatAssignment;
import universitymodel.Department.Department;
import universitymodel.Employment.EmploymentProfile;

/**
 *
 * @author Kulbir 
 * 
 */
public class StudentProfile {
    

    String name ="";
    int studentId=0;
    double studentGrades= 0.0;
    double studentAttendace =0.0;
    EmploymentProfile empProfile;
    Transcript transcript;
    int promotionCount;

    public int getPromotionCount() {
        return promotionCount;
    }

    public void setPromotionCount(int promotionCount) {
        this.promotionCount = promotionCount;
    }
    
    List<SeatAssignment> classes;
    Department dept;
    
    public StudentProfile(String name){
        this.name = name;
        this.classes= new ArrayList<>();
        transcript = new Transcript();    
    }
    
    public boolean tookCourse(String cName){
        for(SeatAssignment cf:classes){
            if(cf.getCourseOffer().getCourse().getName().equalsIgnoreCase(cName)){
                return true;
            }
        }
        return false;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public List<SeatAssignment> getClasses() {
        return classes;
    }

    public void setClasses(List<SeatAssignment> classes) {
        this.classes = classes;
    }
    
    
    public String getStudentName() {
		return name;
	}
	public void setStudentName(String studentName) {
		this.name = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public double getStudentGrades() {
		return studentGrades;
	}
	public void setStudentGrades(double studentGrades) {
		this.studentGrades = studentGrades;
	}
	public double getStudentAttendace() {
		return studentAttendace;
	}
	public void setStudentAttendace(double studentAttendace) {
		this.studentAttendace = studentAttendace;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmploymentProfile getEmpProfile() {
        return empProfile;
    }

    public void setEmpProfile(EmploymentProfile empProfile) {
        this.empProfile = empProfile;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }
    
    
    
    
}
