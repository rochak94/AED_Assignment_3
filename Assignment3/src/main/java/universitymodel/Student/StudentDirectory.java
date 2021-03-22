/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Student;

import java.util.ArrayList;

/**
*
* @author Kulbir 
* 
*/
public class StudentDirectory {
        
    ArrayList<StudentProfile> studentList;
    
    public StudentDirectory(){
        studentList = new ArrayList<>();
    }
    
    public void addStudent(StudentProfile student){
        studentList.add(student);
    }

    public ArrayList<StudentProfile> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<StudentProfile> studentList) {
        this.studentList = studentList;
    }
    
    
    
    
	String studentHistory_Fee ="";
	String studentHistory_courseCredit="";
	String studentHistory_course="";
	
	public String getStudentHistory_Fee() {
		return studentHistory_Fee;
	}
	public void setStudentHistory_Fee(String studentHistory_Fee) {
		this.studentHistory_Fee = studentHistory_Fee;
	}
	public String getStudentHistory_courseCredit() {
		return studentHistory_courseCredit;
	}
	public void setStudentHistory_courseCredit(String studentHistory_courseCredit) {
		this.studentHistory_courseCredit = studentHistory_courseCredit;
	}
	public String getStudentHistory_course() {
		return studentHistory_course;
	}
	public void setStudentHistory_course(String studentHistory_course) {
		this.studentHistory_course = studentHistory_course;
	}
	
	
}
