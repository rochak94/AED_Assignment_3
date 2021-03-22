/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import universitymodel.CourseCatalog.Course;
import universitymodel.CourseSchedule.CourseOffering;
import universitymodel.CourseSchedule.SeatAssignment;
import universitymodel.Department.College;
import universitymodel.Department.CollegeDirectory;
import universitymodel.Department.Department;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class CollegeReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form CourseReportPanel
     */
    CollegeDirectory collegeDir;
    public CollegeReportPanel(CollegeDirectory collegeDir) {
        initComponents();
        this.collegeDir = collegeDir;
        showReport1();
        showReport2();
        showReport3();
   }

    
    private void showReport1(){
         DefaultCategoryDataset  data = new DefaultCategoryDataset();
         
         for(College c:collegeDir.getCollegeList()){
             int averageSalary = 0;
             int count = 0;
             for(Department d:c.getDeptList()){
                 for(StudentProfile s:d.getStudentList()){
                 averageSalary+=s.getEmpProfile().getSalary();
                 count++;
                 }
             }
             averageSalary = averageSalary/count;
             data.setValue(averageSalary,"Colleges",c.getName());
         }  
         
        
        
        JFreeChart jchar = ChartFactory.createBarChart("Colleges vs Average salary of Graduating Students", "College", "Student Avg. salary", data, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchar.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame chartFrame = new ChartFrame("Average Student Salary by their graduating College", jchar,true);
        chartFrame.setVisible(false);
        ChartPanel chartPanel = new ChartPanel(jchar);
        chartPanel.setSize(new java.awt.Dimension(pnlReport1.getWidth(), pnlReport1.getHeight()));
        chartPanel.setDomainZoomable(true);
        //Random colors
        ((BarRenderer)plot.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer r = (BarRenderer)jchar.getCategoryPlot().getRenderer();
        
        Random random = new Random();
         float hue = random.nextFloat();
         float saturation = (random.nextInt(2000) + 1000) / 10000f;
         float luminance = 0.9f;
         Color color = Color.getHSBColor(hue, saturation, luminance);
         
         r.setSeriesPaint(0, color);
         jchar.getPlot().setBackgroundPaint(Color.darkGray);
        pnlReport1.removeAll();
        pnlReport1.setLayout(new BorderLayout());
        pnlReport1.add(chartPanel, BorderLayout.NORTH);
        
        pnlReport1.add(chartPanel);
        pnlReport1.updateUI();
        pnlReport1.repaint();
        pnlReport1.setVisible(true);
    }
    private void showReport2(){
        
       DefaultCategoryDataset  data = new DefaultCategoryDataset();
         
         for(College c:collegeDir.getCollegeList()){
             double averageGpa = 0.0;
             int count = 0;
             for(Department d:c.getDeptList()){
                 for(StudentProfile s:d.getStudentList()){
                 averageGpa+=s.getStudentGrades();
                 count++;
                 }
             }
             averageGpa = averageGpa/count;
             data.setValue(averageGpa,"Colleges",c.getName());
         }  
        
        
        JFreeChart jchar = ChartFactory.createBarChart("Average Grades of Students by Graduating College", "Course", "Student Grades", data, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchar.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame chartFrame = new ChartFrame("Average Grades of Students by Graduating College", jchar,true);
        chartFrame.setVisible(false);
        ChartPanel chartPanel = new ChartPanel(jchar);
        chartPanel.setSize(new java.awt.Dimension(pnlReport2.getWidth(), pnlReport2.getHeight()));
        chartPanel.setDomainZoomable(true);
        //Random colors
        ((BarRenderer)plot.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer r = (BarRenderer)jchar.getCategoryPlot().getRenderer();
        
        Random random = new Random();
         float hue = random.nextFloat();
         float saturation = (random.nextInt(2000) + 1000) / 10000f;
         float luminance = 0.9f;
         Color color = Color.getHSBColor(hue, saturation, luminance);
         
         r.setSeriesPaint(0, color);
         jchar.getPlot().setBackgroundPaint(Color.darkGray);
        
        pnlReport2.removeAll();
        pnlReport2.setLayout(new BorderLayout());
        pnlReport2.add(chartPanel, BorderLayout.NORTH);
        

        pnlReport2.add(chartPanel);
        pnlReport2.updateUI();
        pnlReport2.repaint();
        pnlReport2.setVisible(true);
    }
    
    private void showReport3(){
        
       DefaultCategoryDataset  data = new DefaultCategoryDataset();
         
         for(College c:collegeDir.getCollegeList()){
             int promCount = 0;
             int count = 0;
             for(Department d:c.getDeptList()){
                 for(StudentProfile s:d.getStudentList()){
                 promCount+=s.getPromotionCount();
                 count++;
                 }
             }
             promCount = promCount/count;
             data.setValue(promCount,"Colleges",c.getName());
         }  
        
        
        JFreeChart jchar = ChartFactory.createBarChart("Average Promotion Growth Of Students By Graduating College", "Course", "Average Promotion Count", data, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchar.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
 
        
        ChartFrame chartFrame = new ChartFrame("Average Promotion Growth Of Students", jchar,true);
        chartFrame.setVisible(false);
        ChartPanel chartPanel = new ChartPanel(jchar);
        chartPanel.setSize(new java.awt.Dimension(pnlReport2.getWidth(), pnlReport2.getHeight()));
        chartPanel.setDomainZoomable(true);
        
        //Random colors
        ((BarRenderer)plot.getRenderer()).setBarPainter(new StandardBarPainter());
        BarRenderer r = (BarRenderer)jchar.getCategoryPlot().getRenderer();
        
        Random random = new Random();
         float hue = random.nextFloat();
         float saturation = (random.nextInt(2000) + 1000) / 10000f;
         float luminance = 0.9f;
         Color color = Color.getHSBColor(hue, saturation, luminance);
         
         r.setSeriesPaint(0, color);
         jchar.getPlot().setBackgroundPaint(Color.darkGray);
        
        pnlReport3.removeAll();
        
        
        
        pnlReport3.setLayout(new BorderLayout());
        pnlReport3.add(chartPanel, BorderLayout.NORTH);
        

        pnlReport3.add(chartPanel);
        pnlReport3.updateUI();
        pnlReport3.repaint();
        pnlReport3.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlReport1 = new javax.swing.JPanel();
        pnlReport2 = new javax.swing.JPanel();
        pnlReport3 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("College-Wide Statistics");
        jLabel1.setAlignmentX(0.5F);
        jPanel1.add(jLabel1);

        pnlReport1.setBorder(javax.swing.BorderFactory.createTitledBorder("Report 1"));

        javax.swing.GroupLayout pnlReport1Layout = new javax.swing.GroupLayout(pnlReport1);
        pnlReport1.setLayout(pnlReport1Layout);
        pnlReport1Layout.setHorizontalGroup(
            pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlReport1Layout.setVerticalGroup(
            pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        jPanel1.add(pnlReport1);
        pnlReport1.getAccessibleContext().setAccessibleParent(this);

        pnlReport2.setBorder(javax.swing.BorderFactory.createTitledBorder("Report 2"));

        javax.swing.GroupLayout pnlReport2Layout = new javax.swing.GroupLayout(pnlReport2);
        pnlReport2.setLayout(pnlReport2Layout);
        pnlReport2Layout.setHorizontalGroup(
            pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlReport2Layout.setVerticalGroup(
            pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        jPanel1.add(pnlReport2);
        pnlReport2.getAccessibleContext().setAccessibleParent(this);

        pnlReport3.setBorder(javax.swing.BorderFactory.createTitledBorder("Report 3"));

        javax.swing.GroupLayout pnlReport3Layout = new javax.swing.GroupLayout(pnlReport3);
        pnlReport3.setLayout(pnlReport3Layout);
        pnlReport3Layout.setHorizontalGroup(
            pnlReport3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        pnlReport3Layout.setVerticalGroup(
            pnlReport3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        jPanel1.add(pnlReport3);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlReport1;
    private javax.swing.JPanel pnlReport2;
    private javax.swing.JPanel pnlReport3;
    // End of variables declaration//GEN-END:variables
}
