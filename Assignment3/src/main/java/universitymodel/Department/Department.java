/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Department;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import universitymodel.CourseCatalog.CourseCatalog;
import universitymodel.CourseSchedule.CourseOffering;
import universitymodel.Faculty.FacultyDirectory;
import universitymodel.Faculty.FacultyProfile;
import universitymodel.Student.StudentDirectory;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class Department {
    //list of courses create a coursecatalog object
    //student directory instance
    //faculty directory instance
    //Array list of degree objects
    //courseschedule object
	int UniversityIDNumber;
	Date enrollmentDate;
	String name;
        StudentDirectory studentList;
	String profile;
        College college;
        CourseCatalog catalog;
        Double averageSalary;
        
        List<CourseOffering> schedule;
        
        FacultyDirectory facultyDirectory;

    public List<CourseOffering> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<CourseOffering> schedule) {
        this.schedule = schedule;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultyDirectory;
    }

    public void setFacultyDirectory(FacultyDirectory facultyDirectory) {
        this.facultyDirectory = facultyDirectory;
    }
        
        
        public Department(String name,College college){
            this.facultyDirectory = new FacultyDirectory();
            this.name = name;
            this.college = college;
            this.catalog = new CourseCatalog();
            college.addDepartment(this);
            studentList = new StudentDirectory();
            schedule = new ArrayList<>();
        }
        
        public void addCourseOffering(CourseOffering courseOffering)
        {
            this.schedule.add(courseOffering);
        }
        
        public List<FacultyProfile> getFacultyList(){
            return this.facultyDirectory.getFacultyList();
        }
        
        public void addFacultyProfile(FacultyProfile fac){
            this.getFacultyList().add(fac);
        }

        public void addStudent(StudentProfile student){
            this.studentList.addStudent(student);
        }
        
        
        public void computeAverageSalary(){
            Double averageSalary = 0.0;
            
            for(StudentProfile student:this.studentList.getStudentList()){
                averageSalary+=student.getEmpProfile().getSalary();
            }
            this.averageSalary = averageSalary/this.studentList.getStudentList().size();
        }
      public int computeSalaryGrowth(){
            
            int percent = 0;
            for(StudentProfile student:this.studentList.getStudentList()){
                
                int startSalary = student.getEmpProfile().getStartSalary();
                int currSalary = student.getEmpProfile().getSalary();
                int diff = currSalary - startSalary;
                percent += (diff/startSalary)*100;
                if(percent < 0){
                    percent += Math.abs(percent);
                }
            }
            return (percent/this.studentList.getStudentList().size());
        }  
        
        
        
        
        
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public CourseCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(CourseCatalog catalog) {
        this.catalog = catalog;
    }

    public List<StudentProfile> getStudentList() {
        return studentList.getStudentList();
    }

    public void setStudentList(StudentDirectory studentList) {
        this.studentList = studentList;
    }

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }
    
        
        
	public int getUniversityIDNumber() {
		return UniversityIDNumber;
	}
	public void setUniversityIDNumber(int universityIDNumber) {
		UniversityIDNumber = universityIDNumber;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public String getDepartmentName() {
		return name;
	}
	public void setDepartmentName(String departmentName) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	
	
	
	
	
	
}
