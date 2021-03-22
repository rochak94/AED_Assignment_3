/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import universitymodel.Department.College;
import universitymodel.Department.CollegeDirectory;
import universitymodel.Department.Department;
import universitymodel.Student.StudentProfile;

/**
 *
 * @author Skanda
 */
public class DepartmentReportPanel extends javax.swing.JPanel {

    /**
     * Creates new form DepartmentPanelReport
     */
    CollegeDirectory collegeDir;
    public DepartmentReportPanel(CollegeDirectory collegeDir) {
        initComponents();
        this.collegeDir = collegeDir;
        this.collegeComboBox.removeAllItems();
        for(College coll:collegeDir.getCollegeList()){
          this.collegeComboBox.addItem(coll.getName());          
        }
        showReport1();
        showReport2();
    }
    private void showReport1(){
        
        //Average salary by department
         DefaultCategoryDataset  data = new DefaultCategoryDataset();
        College coll = collegeDir.getCollege((String) collegeComboBox.getSelectedItem());
        
        for(Department dept:coll.getDeptList()){
            for(StudentProfile student:dept.getStudentList()){
                //String grade;
                //grade = String.format("%.1f", student.getStudentGrades());
                System.out.println(student.getEmpProfile().getSalary());
            data.setValue(dept.getAverageSalary(),"Departments",dept.getName());
            }
        } 
        JFreeChart jchar = ChartFactory.createBarChart("Departments vs Average Student Salary", "Department", "Student Avg. salary", data, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchar.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame chartFrame = new ChartFrame("Average Student Salary by Department", jchar,true);
        chartFrame.setVisible(false);
        ChartPanel chartPanel = new ChartPanel(jchar);
        chartPanel.setSize(new java.awt.Dimension(pnlReport1.getWidth(), pnlReport1.getHeight()));
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
        
        //Average Salary by student Gpa
         DefaultCategoryDataset  data = new DefaultCategoryDataset();
        College coll = collegeDir.getCollege((String) collegeComboBox.getSelectedItem());
        
        for(Department dept:coll.getDeptList()){
            for(StudentProfile student:dept.getStudentList()){

            
            data.setValue(dept.computeSalaryGrowth(),"Departments",dept.getName());
            }
        } 
        JFreeChart jchar = ChartFactory.createBarChart("Departments vs Graduate's Salary Growth in 5 years(%)", "Department", "Student Avg. salary", data, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchar.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame chartFrame = new ChartFrame("Average Salary Growth of Graduates by Department(%)", jchar,true);
        chartFrame.setVisible(false);
        chartFrame.setSize(1000, 1000);
        ChartPanel chartPanel = new ChartPanel(jchar);
        chartPanel.setDomainZoomable(true);
        chartPanel.setSize(new java.awt.Dimension(pnlReport2.getWidth(), pnlReport2.getHeight()));
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
        pnlReport2.add(chartPanel, BorderLayout.SOUTH);
        

        pnlReport2.add(chartPanel);
        pnlReport2.updateUI();
        pnlReport2.repaint();
        pnlReport2.setVisible(true);
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
        collegeComboBox = new javax.swing.JComboBox<>();
        pnlReport1 = new javax.swing.JPanel();
        pnlReport2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));
        setAutoscrolls(true);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Select College");
        jLabel1.setAlignmentX(0.5F);
        add(jLabel1);

        collegeComboBox.setMaximumSize(new java.awt.Dimension(200, 50));
        collegeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeComboBoxActionPerformed(evt);
            }
        });
        add(collegeComboBox);

        pnlReport1.setBorder(javax.swing.BorderFactory.createTitledBorder("Report 1"));

        javax.swing.GroupLayout pnlReport1Layout = new javax.swing.GroupLayout(pnlReport1);
        pnlReport1.setLayout(pnlReport1Layout);
        pnlReport1Layout.setHorizontalGroup(
            pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlReport1Layout.setVerticalGroup(
            pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        add(pnlReport1);

        pnlReport2.setBorder(javax.swing.BorderFactory.createTitledBorder("Report 2"));

        javax.swing.GroupLayout pnlReport2Layout = new javax.swing.GroupLayout(pnlReport2);
        pnlReport2.setLayout(pnlReport2Layout);
        pnlReport2Layout.setHorizontalGroup(
            pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlReport2Layout.setVerticalGroup(
            pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        add(pnlReport2);
    }// </editor-fold>//GEN-END:initComponents

    private void collegeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeComboBoxActionPerformed
        // TODO add your handling code here:
        showReport1();
        showReport2();
        
    }//GEN-LAST:event_collegeComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> collegeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlReport1;
    private javax.swing.JPanel pnlReport2;
    // End of variables declaration//GEN-END:variables
}
