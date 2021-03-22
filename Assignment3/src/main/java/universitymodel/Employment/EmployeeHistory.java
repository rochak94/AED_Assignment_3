/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Employment;

/**
 *
 * @author Skanda
 */
public class EmployeeHistory {
    String role;
   String salary;
    String employeeId;
    String employer;
    int employmentYear;
    int averageSalary =0;
    int averageExpYear =0;
    int companiesWorkedCount =0;
    //Add starts ends
    
    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }
    
    public int getAverageSalary() {
		return averageSalary;
	}

	public void setAverageSalary(int averageSalary) {
		this.averageSalary = averageSalary;
	}

	public int getAverageExpYear() {
		return averageExpYear;
	}

	public void setAverageExpYear(int averageExpYear) {
		this.averageExpYear = averageExpYear;
	}

	public int getCompaniesWorkedCount() {
		return companiesWorkedCount;
	}

	public void setCompaniesWorkedCount(int companiesWorkedCount) {
		this.companiesWorkedCount = companiesWorkedCount;
	}

	public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }



    public int getEmploymentYear() {
        return employmentYear;
    }

    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }
    
    
}
