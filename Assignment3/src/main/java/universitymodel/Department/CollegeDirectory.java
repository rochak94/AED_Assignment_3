/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.Department;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class CollegeDirectory {
    List<College> collegeList;
    
    public CollegeDirectory(){
        collegeList = new ArrayList<>();
    }
    
    public void addCollege(College coll){
        this.collegeList.add(coll);
    }
    
    public College getCollege(String collegeName){
        for(College coll:collegeList){
            if(coll.getName().equalsIgnoreCase(collegeName)){
                return coll;
            }
        }
        return null;
    }

    public List<College> getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(List<College> collegeList) {
        this.collegeList = collegeList;
    }
    
    
}
