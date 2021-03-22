/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.CourseSchedule;

/**
 *
 * @author Skanda
 */
public class Seat {
    Boolean occupied; 
    int number;
    SeatAssignment seatassignment;
    CourseOffering courseoffer;
    public Seat (CourseOffering co, int n){
        courseoffer = co;
        number = n;
        occupied = false;
        
    }
    
    public Boolean isOccupied(){
        return occupied;

    }


    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatAssignment getSeatassignment() {
        return seatassignment;
    }

    public void setSeatassignment(SeatAssignment seatassignment) {
        this.seatassignment = seatassignment;
    }

    public CourseOffering getCourseoffer() {
        return courseoffer;
    }

    public void setCourseoffer(CourseOffering courseoffer) {
        this.courseoffer = courseoffer;
    }
    
    
    
}
