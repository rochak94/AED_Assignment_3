/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Employment;

import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class EmploymentProfile {
    
    StudentProfile studentRecord;
    int salary;
    int empId;
    String employmentField;
    int startSalary;

    public int getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(int startSalary) {
        this.startSalary = startSalary;
    }

    
    public EmploymentProfile(StudentProfile student, int salary){
        this.studentRecord = student;
        this.salary = salary;
    }
    public StudentProfile getStudentRecord() {
        return studentRecord;
    }

    public void setStudentRecord(StudentProfile studentRecord) {
        this.studentRecord = studentRecord;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmploymentField() {
        return employmentField;
    }

    public void setEmploymentField(String employmentField) {
        this.employmentField = employmentField;
    }
    
    
}
