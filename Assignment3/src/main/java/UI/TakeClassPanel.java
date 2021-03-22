/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universitymodel.CourseSchedule.CourseOffering;
import universitymodel.Department.College;
import universitymodel.Department.CollegeDirectory;
import universitymodel.Department.Department;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class TakeClassPanel extends javax.swing.JPanel {

    /**
     * Creates new form TakeClassPanel
     */
    CollegeDirectory collegeDirectory;
    StudentProfile panelStudent;
    public TakeClassPanel(CollegeDirectory collegeDirectory) {
        initComponents();
        this.collegeDirectory = collegeDirectory;
        btnTakeCourse.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtStudentId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnFindCourses = new javax.swing.JButton();
        btnTakeCourse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Enter Student ID:");

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Name", "Semester", "Year", "Faculty", "Seats Left"
            }
        ));
        jScrollPane1.setViewportView(courseTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Eligible Courses:");

        btnFindCourses.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnFindCourses.setText("Find Courses");
        btnFindCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCoursesActionPerformed(evt);
            }
        });

        btnTakeCourse.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnTakeCourse.setText("Take Course");
        btnTakeCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeCourseActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Student Course Menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTakeCourse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFindCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindCourses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTakeCourse)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCoursesActionPerformed
        // TODO add your handling code here:
        StudentProfile student=null;
        btnTakeCourse.setVisible(false);
        try{
        for(College coll:collegeDirectory.getCollegeList()){
            for(Department d:coll.getDeptList()){
                for(StudentProfile s:d.getStudentList()){
                    if(s.getStudentId() == Integer.parseInt(txtStudentId.getText())){
                        student = s;
                    }
                }
            }
        }
        }catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Enter a valid number for student ID","Fail",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(student == null){
             JOptionPane.showMessageDialog(this,"Student ID not found","Fail",JOptionPane.ERROR_MESSAGE);
        }
        else{
            this.panelStudent = student;
            btnTakeCourse.setVisible(true);
            Department dept = student.getDept();
            DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        
            model.setRowCount(0);
            
            for(CourseOffering cf:dept.getSchedule())
            {
                model.addRow(new Object[]{cf.getCourse().getName(),cf.getSemester(),cf.getYear(),cf.getFacultyassignment().getName(),cf.getClassSize()- cf.getSeatlist().size()});
            }
        }
    }//GEN-LAST:event_btnFindCoursesActionPerformed

    private void btnTakeCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeCourseActionPerformed
        // TODO add your handling code here:
        
        if(courseTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this,"Please select a course from the table","Fail",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            int row = courseTable.getSelectedRow();
            String courseName = courseTable.getModel().getValueAt(row,0).toString();
            String semester = courseTable.getModel().getValueAt(row,1).toString();
            String year = courseTable.getModel().getValueAt(row,2).toString();
            String seats = courseTable.getModel().getValueAt(row,4).toString();
            if(Integer.parseInt(seats) <= 0){
                JOptionPane.showMessageDialog(this,"No Seats Left!","Fail",JOptionPane.ERROR_MESSAGE);
                return;
            }
            CourseOffering target = null;
            for(CourseOffering cf:panelStudent.getDept().getSchedule()){
                if(cf.getCourse().getName().equals(courseName) && String.valueOf(cf.getYear()).equals(year) && cf.getSemester().equals(semester)){
                    target = cf;
                }
            }
            target.addStudent(panelStudent);
            JOptionPane.showMessageDialog(this,"Student Enrolled","Fail",JOptionPane.ERROR_MESSAGE);
            
            Department dept = panelStudent.getDept();
            DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        
            model.setRowCount(0);
            
            for(CourseOffering cf:dept.getSchedule())
            {
                model.addRow(new Object[]{cf.getCourse().getName(),cf.getSemester(),cf.getYear(),cf.getFacultyassignment().getName(),cf.getClassSize()- cf.getSeatlist().size()});
            }
            
        }
    }//GEN-LAST:event_btnTakeCourseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFindCourses;
    private javax.swing.JButton btnTakeCourse;
    private javax.swing.JTable courseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtStudentId;
    // End of variables declaration//GEN-END:variables
}