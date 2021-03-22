/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitymodel.CourseCatalog;

/**
 *
 * @author Skanda
 */
public class Course {
    String no;
    String name;
    int credits;
    int price = 1500; //per credit hour
    public Course(String name, String no, int credits){
        this.name = name;
        this.no=no;
        this.credits = credits;
        
        
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    
}
