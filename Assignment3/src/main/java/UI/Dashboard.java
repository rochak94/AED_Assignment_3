/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import universitymodel.CourseCatalog.Course;
import universitymodel.CourseSchedule.CourseOffering;
import universitymodel.Department.College;
import universitymodel.Department.CollegeDirectory;
import universitymodel.Department.Department;
import universitymodel.Employment.EmploymentProfile;
import universitymodel.Faculty.FacultyProfile;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author kulbi
 */
public class Dashboard extends javax.swing.JFrame {

    static CollegeDirectory collegeDir;
    /**
     * Creates new form Department_StudentSalary
     */
    public Dashboard() {
        initComponents();
        generateData();

    }

       public static void generateData(){
         Faker faker = new Faker();
         FakeValuesService fakeValuesService = new FakeValuesService(
      new Locale("en-GB"), new RandomService());
     
    collegeDir = new CollegeDirectory();
    
    //Generating 6 colleges for our model
    for(int i=0;i<6;i++){
        collegeDir.addCollege(new College(fakeValuesService.bothify("College ????")));
    }
    
    for(College coll:collegeDir.getCollegeList()) //Generating 5 departments for each college
    {
        
        Department dept;
        int max = ThreadLocalRandom.current().nextInt(4,7);
        for(int i=0;i<max;i++){
        dept = new Department(fakeValuesService.bothify("Dept ??"),coll);
        }

    }    
    
    
     //Generating a bunch of courses(random number ) and assigning them to catalogs of each department
 
   for(College c:collegeDir.getCollegeList()) {
       for(Department d:c.getDeptList()){
          int i = ThreadLocalRandom.current().nextInt(18,20);
           for( ; i< 25; i++){
        String courseName = fakeValuesService.bothify("Course ??");
        String courseNo = fakeValuesService.bothify("###");
         d.getCatalog().addCourse(new Course(courseName,courseNo,2));
    }
  }
       
 }
    
    

    //Generating a bunch of students

    for(College c: collegeDir.getCollegeList()){
        for(Department d:c.getDeptList()){
            int i = ThreadLocalRandom.current().nextInt(20,60);
            for(; i < 100;i++){ //generating max of students per dept
                StudentProfile stu = new StudentProfile(faker.name().name());
                stu.setPromotionCount(ThreadLocalRandom.current().nextInt(5,10));
                stu.setDept(d);
                d.addStudent(stu);
            }
        }
    }
    
    for(College c: collegeDir.getCollegeList()){
        for(Department d:c.getDeptList()){
        for(StudentProfile student:d.getStudentList()){
            int currentSalary = ThreadLocalRandom.current().nextInt(90000, 350000);
            int startSalary = ThreadLocalRandom.current().nextInt(31000, 125000);
            if(startSalary > currentSalary){
                startSalary = startSalary / 2;
            }
            EmploymentProfile prof=new EmploymentProfile(student,currentSalary);
            prof.setStartSalary(startSalary);
            
            
           student.setEmpProfile(prof);
            Double randomGpa = ThreadLocalRandom.current().nextDouble(2.3, 4.0);
            student.setStudentGrades(randomGpa);
        }
    }
   }
    for(College c: collegeDir.getCollegeList()){
        for(Department d:c.getDeptList()){
            int i = ThreadLocalRandom.current().nextInt(10,40);
            for(i=0;i<60;i++){//Random number of faculty
            d.addFacultyProfile(new FacultyProfile(faker.name().name()));
            }
       }
  }
    
    //Generating course offerings and seat assignments
    String[] semesters = {"Spring", "Summer","fall"};
    for(College c: collegeDir.getCollegeList()){
        for(Department d:c.getDeptList()){
            for(Course co:d.getCatalog().getCourseList()){
                int classSize = ThreadLocalRandom.current().nextInt(30, 60); //Class size
                FacultyProfile fac = d.getFacultyList().get(ThreadLocalRandom.current().nextInt(d.getFacultyList().size()));
                
                CourseOffering cf = new CourseOffering(co,classSize,fac,d);
                cf.setSemester(semesters[ThreadLocalRandom.current().nextInt(semesters.length)]);
                d.addCourseOffering(cf);
            }
        }
    }
    
    //Assigning random Seat assignments to students
    for(College c: collegeDir.getCollegeList()){
        for(Department d:c.getDeptList()){
            for(StudentProfile stud: d.getStudentList()){
                int max = ThreadLocalRandom.current().nextInt(6, 10);
                for(int i=0;i<max;i++){
                    CourseOffering cf = d.getSchedule().get(ThreadLocalRandom.current().nextInt(d.getSchedule().size()));
                    cf.addStudent(stud);
                }
            }
        }
    }
    
    
    
    
    for(College c: collegeDir.getCollegeList()){
        for(Department d:c.getDeptList()){
        d.computeAverageSalary();
        }
    }
     
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        controlPanel = new javax.swing.JPanel();
        btnDepartmentReport = new javax.swing.JButton();
        btnCourseReport = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Department Vs Student Salary");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        controlPanel.setBackground(new java.awt.Color(153, 153, 153));
        controlPanel.setForeground(new java.awt.Color(153, 153, 153));

        btnDepartmentReport.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDepartmentReport.setText("Department Analytics");
        btnDepartmentReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentReportActionPerformed(evt);
            }
        });

        btnCourseReport.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCourseReport.setText("Course Analytics");
        btnCourseReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseReportActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("College-Wide Analytics");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDepartmentReport, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCourseReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addContainerGap())
        );

        controlPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCourseReport, btnDepartmentReport, jButton1});

        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDepartmentReport, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCourseReport, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        controlPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCourseReport, btnDepartmentReport, jButton1});

        jSplitPane1.setLeftComponent(controlPanel);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(viewPanel);

        getContentPane().add(jSplitPane1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
//    private void showReport2(){
//          
//        DefaultCategoryDataset  data = new DefaultCategoryDataset();
//        
//        
//        for(Department dept:collegeA.getDeptList()){
//            data.setValue(dept.getAverageSalary(),"Average Salary",dept.getName());
//        }
//        
//        JFreeChart jchar = ChartFactory.createBarChart("Record", "Department", "Student Avg. salary", data, PlotOrientation.VERTICAL, true, true, false);
//        CategoryPlot plot = jchar.getCategoryPlot();
//        plot.setRangeGridlinePaint(Color.black);
//        
//        ChartFrame chartFrame = new ChartFrame("Record", jchar,true);
//        chartFrame.setVisible(false);
//        chartFrame.setSize(500, 400);
//        ChartPanel chartPanel = new ChartPanel(jchar);
//        
//        pnlReport2.removeAll();
//        pnlReport2.add(chartPanel);
//        pnlReport2.updateUI();
//    }
    private void btnDepartmentReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentReportActionPerformed
        // TODO add your handling code here:
        DepartmentReportPanel departmentReportPanel = new UI.DepartmentReportPanel(collegeDir);
        jSplitPane1.setRightComponent(departmentReportPanel);
    }//GEN-LAST:event_btnDepartmentReportActionPerformed

    private void btnCourseReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseReportActionPerformed
        // TODO add your handling code here:
        CourseReportPanel crPanel = new CourseReportPanel(collegeDir);
        jSplitPane1.setRightComponent(crPanel);
    }//GEN-LAST:event_btnCourseReportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CollegeReportPanel collReportPanel = new CollegeReportPanel(collegeDir);
        jSplitPane1.setRightComponent(collReportPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dashboard obj = new Dashboard();
                obj.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCourseReport;
    private javax.swing.JButton btnDepartmentReport;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
