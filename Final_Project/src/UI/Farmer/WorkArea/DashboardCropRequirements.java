/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Farmer.WorkArea;

import Common.Item;
import Contract.Contract;
import Contract.ContractDirectory;
import CropFolder.Crop;
import FMCG.MasterRequirment;
import FMCG.Requirement;
import Farmer.FarmerProfile;
import Market.Market;
import UI.FMCG.WorkArea.Admin.*;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Aditya
 */
public class DashboardCropRequirements extends javax.swing.JPanel {

    /**
     * Creates new form ViewCropRequirements
     */

    JPanel farmerProcessStack;
    ChartPanel pieChartPanel;
    FarmerProfile farmerprofile;
    Requirement requirement;
    Crop selectedCrop;
    Market market;
    MasterRequirment masterRequirment;
    //Item item;
    ContractDirectory contractDirectory;
    double totalRequirementQty = 0;
    double totalCommittedQty = 0;
    
    public DashboardCropRequirements(JPanel jp, FarmerProfile farmerprofile, Market market, Requirement requirement, ContractDirectory contractDirectory) {
        initComponents();
        farmerProcessStack = jp;
        this.market = market;
        this.farmerprofile = farmerprofile;
        this.requirement = requirement;
        this.masterRequirment = market.getMasterRequirment();
        this.contractDirectory = contractDirectory;
        this.selectedCrop = requirement.getItem().getCrop();
//        ChartPanel pieChartPanel = PieChartGenerator.createPieChartPanel();
//        panel1pie1.add(pieChartPanel);
//        panel1pie1.revalidate();
//        panel1pie1.repaint();
          createPieChartPanel();  
    }
     
    public void createPieChartPanel() {
        // Create a sample dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Requirement tempReq: masterRequirment.getRequirements()){
            if(tempReq.getItem().getCrop().equals(selectedCrop)){
                dataset.setValue(tempReq.getFmcg().getFmcgName(), tempReq.getItem().getQuantity());
                totalRequirementQty += tempReq.getItem().getQuantity();
            }
        }
        // Create the chart using the dataset
        JFreeChart chart1 = ChartFactory.createPieChart("Total Requirement", // Title
                dataset, // Dataset
                true, // Include legend
                true, // Include tooltips
                false); // Exclude URLs
        
        // Get the plot (PiePlot) of the chart
        PiePlot plot1 = (PiePlot) chart1.getPlot();
        plot1.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {2}"));
        // Add a text annotation for total quantity
        String annotationText1 = "Total Quantity: " + totalRequirementQty;
        TextTitle annotationTitle1 = new TextTitle(annotationText1);
        annotationTitle1.setFont(new Font("SansSerif", Font.BOLD, 12));
        chart1.addSubtitle(annotationTitle1);
        // Create a ChartPanel with both charts
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setPreferredSize(new java.awt.Dimension(300, 300)); // Set size of the ChartPanel

        requirementPieChart.add(chartPanel1);
        requirementPieChart.revalidate();
        requirementPieChart.repaint();
        txtTotalRequirement.setText(String.valueOf(totalRequirementQty));
        
      
        // Create the second sample dataset
        DefaultPieDataset dataset2 = new DefaultPieDataset();
        for(Contract tempContract: market.getMarketContracts()){
            if(tempContract.getSelectedItem().getCrop().equals(requirement.getItem().getCrop())){
                totalCommittedQty += tempContract.getSelectedItem().getQuantity();
            }   
        }
        dataset2.setValue("Total Committed", totalCommittedQty);
        dataset2.setValue("Total Uncommitted", totalRequirementQty-totalCommittedQty);
        
        // Create the second chart using the second dataset
        JFreeChart chart2 = ChartFactory.createPieChart(
                "Total Committed", // Title
                dataset2, // Dataset
                true, // Include legend
                true, // Include tooltips
                false); // Exclude URLs
               
        PiePlot plot2 = (PiePlot) chart2.getPlot();
        plot2.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));
        // Add a text annotation for total quantity
        String annotationText2 = "Total Committed: " + totalCommittedQty;
        TextTitle annotationTitle2 = new TextTitle(annotationText2);
        annotationTitle2.setFont(new Font("SansSerif", Font.BOLD, 12));
        chart2.addSubtitle(annotationTitle2);

        // Create a ChartPanel for the second chart
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setPreferredSize(new java.awt.Dimension(300, 300)); // Set size of the ChartPanel
        
        committedPieChart.add(chartPanel2);
        committedPieChart.revalidate();
        committedPieChart.repaint();
        txtTotalCommitted.setText(String.valueOf(totalCommittedQty));
        //txtSurplus.setText(String.valueOf(totalCommittedQty-totalRequirementQty));
    }

public void updateChartPanel(double enteredQty) {
        // Create a sample dataset
        DefaultPieDataset updateDatasett = new DefaultPieDataset();
//        for(Contract tempContract: market.getMarketContracts()){
//            if(tempContract.getSelectedItem().getCrop().equals(requirement.getItem().getCrop())){
//                totalCommittedQty += tempContract.getSelectedItem().getQuantity();
//            }
//        }
        totalCommittedQty += enteredQty;
        updateDatasett.setValue("Total Committed", totalCommittedQty);
        updateDatasett.setValue("Total Uncommitted", totalRequirementQty - totalCommittedQty);

        JFreeChart chart = ChartFactory.createPieChart(
                "Total Committed", // Title
                updateDatasett, // Dataset
                true, // Include legend
                true, // Include tooltips
                false); // Exclude URLs


        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1}"));
    
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(300, 300));

        committedPieChart.removeAll();
        committedPieChart.add(chartPanel);
        committedPieChart.revalidate();
        committedPieChart.repaint();
        txtTotalCommitted.setText(String.valueOf(totalCommittedQty));
        //txtSurplus.setText(String.valueOf(totalCommittedQty - totalRequirementQty));
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        committedPieChart = new javax.swing.JPanel();
        requirementPieChart = new javax.swing.JPanel();
        txtQuantity = new javax.swing.JTextField();
        lblCropCommit = new javax.swing.JLabel();
        btnCommit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblTotalRequirement = new javax.swing.JLabel();
        txtTotalRequirement = new javax.swing.JTextField();
        lblTotalCommitted = new javax.swing.JLabel();
        txtTotalCommitted = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 204, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Requirements for the Crop: ");

        committedPieChart.setBackground(new java.awt.Color(255, 255, 255));
        committedPieChart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        committedPieChart.setPreferredSize(new java.awt.Dimension(275, 275));
        committedPieChart.setLayout(new java.awt.BorderLayout());

        requirementPieChart.setBackground(new java.awt.Color(255, 255, 255));
        requirementPieChart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        requirementPieChart.setPreferredSize(new java.awt.Dimension(275, 275));
        requirementPieChart.setLayout(new java.awt.BorderLayout());

        txtQuantity.setPreferredSize(new java.awt.Dimension(64, 26));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        lblCropCommit.setText("Commit Crop Quantity:");

        btnCommit.setBackground(new java.awt.Color(0, 102, 153));
        btnCommit.setForeground(new java.awt.Color(255, 255, 255));
        btnCommit.setText("Commit");
        btnCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommitActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 102, 153));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTotalRequirement.setText("Total Requirement (in Tons):");

        txtTotalRequirement.setEnabled(false);
        txtTotalRequirement.setPreferredSize(new java.awt.Dimension(64, 26));

        lblTotalCommitted.setText("Total Committed (in Tons):");

        txtTotalCommitted.setEnabled(false);
        txtTotalCommitted.setPreferredSize(new java.awt.Dimension(64, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lblTotalRequirement)
                .addGap(18, 18, 18)
                .addComponent(txtTotalRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalCommitted)
                .addGap(18, 18, 18)
                .addComponent(txtTotalCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnBack)
                .addGap(251, 251, 251)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(btnCommit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(requirementPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(committedPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCropCommit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(316, 316, 316)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalCommitted)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalRequirement))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(requirementPieChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(committedPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCropCommit))
                .addGap(12, 12, 12)
                .addComponent(btnCommit)
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCropCommit, txtQuantity});

    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        farmerProcessStack.remove(this);
        ((java.awt.CardLayout) farmerProcessStack.getLayout()).previous(farmerProcessStack);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommitActionPerformed
        // TODO add your handling code here:
        try {
            if(txtQuantity.getText().isBlank()){
               JOptionPane.showMessageDialog(null,"Please enter a number!","Warning",JOptionPane.WARNING_MESSAGE);
                        
             }else{
                
                // Attempt to parse the input string to a double
                double enteredQty = Double.parseDouble(txtQuantity.getText());
                if((enteredQty + totalCommittedQty) > totalRequirementQty){
                    JOptionPane.showMessageDialog(null,"You cannot commit more than the Total Requirement.!","Warning",JOptionPane.WARNING_MESSAGE);
                }else{
                    Item item = new Item(requirement.getItem().getCrop(),enteredQty);
                    Contract newcontract = contractDirectory.NewContract(market, farmerprofile, item);
                    updateChartPanel(enteredQty);
                }
              }                        
            } catch (NumberFormatException e) {
                // If parsing fails (NumberFormatException is thrown), return false
                JOptionPane.showMessageDialog(null,"Please enter a valid number.","Warning",JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btnCommitActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCommit;
    private javax.swing.JPanel committedPieChart;
    private javax.swing.JLabel lblCropCommit;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalCommitted;
    private javax.swing.JLabel lblTotalRequirement;
    private javax.swing.JPanel requirementPieChart;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTotalCommitted;
    private javax.swing.JTextField txtTotalRequirement;
    // End of variables declaration//GEN-END:variables
}
