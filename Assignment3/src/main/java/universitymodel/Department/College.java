/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Department;

import java.util.ArrayList;
import java.util.List;
import universitymodel.Student.StudentDirectory;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class College {
    //Array list of departments
    //String for college name
    //Arraylist of student profiles here or College Student Directory(create a student directory instance and associate)
    String name;
    ArrayList<Department> deptList;
    StudentDirectory studentDirectory;
    
    
    public College(String name){
        this.name = name;
        deptList = new ArrayList<>();
        studentDirectory = new StudentDirectory();
    }
    
    public Department getDepartment(String deptName){
        for(Department dept:this.deptList){
            if(dept.getName().equalsIgnoreCase(deptName)){
                return dept;
            }
        
        }
        return null;
    }
    
    public void addDepartment(Department dept){
        deptList.add(dept);
    }
    
    public void addStudent(StudentProfile student){
        studentDirectory.addStudent(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Department> getDeptList() {
        return deptList;
    }

    public void setDeptList(ArrayList<Department> deptList) {
        this.deptList = deptList;
    }

    public StudentDirectory getStudentDirectory() {
        return studentDirectory;
    }

    public void setStudentDirectory(StudentDirectory studentDirectory) {
        this.studentDirectory = studentDirectory;
    }
    
    
}
