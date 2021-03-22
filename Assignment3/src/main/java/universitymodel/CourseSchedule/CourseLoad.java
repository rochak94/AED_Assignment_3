/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author Skanda
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    
    public CourseLoad(String s){
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }
    public SeatAssignment addSeatAssignment(CourseOffering co){

        SeatAssignment sa = new SeatAssignment(co);
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<SeatAssignment> getSeatassignments() {
        return seatassignments;
    }

    public void setSeatassignments(ArrayList<SeatAssignment> seatassignments) {
        this.seatassignments = seatassignments;
    }
    
}
