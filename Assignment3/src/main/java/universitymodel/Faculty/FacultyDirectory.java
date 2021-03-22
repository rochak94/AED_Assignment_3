/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Faculty;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class FacultyDirectory {
    List<FacultyProfile> facultyList;

    public FacultyDirectory(){
        this.facultyList = new ArrayList<FacultyProfile>();
    }
    
    public FacultyProfile getFaculty(String name){
        for(FacultyProfile fac : facultyList){
            if(fac.getName().equals(name)){
                return fac;
            }
        }
        return null;
    }
    public List<FacultyProfile> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<FacultyProfile> facultyList) {
        this.facultyList = facultyList;
    }
    
     
}
