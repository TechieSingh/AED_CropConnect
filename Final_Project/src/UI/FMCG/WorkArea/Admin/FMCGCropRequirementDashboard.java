/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.FMCG.WorkArea.Admin;

import Common.Item;
import Contract.Contract;
import Contract.ContractDirectory;
import CropFolder.Crop;
import FMCG.MasterRequirment;
import FMCG.Requirement;
import FMCG.RequirementOfficer;
import Farmer.FarmerProfile;
import Market.Market;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Sagar
 */
public class FMCGCropRequirementDashboard extends javax.swing.JPanel {

    /**
     * Creates new form ViewCropRequirements
     */

    JPanel processControlStack;
    ChartPanel pieChartPanel;
    RequirementOfficer requirementOfficer;
    Requirement requirement;
    Crop selectedCrop;
    Market market;
    MasterRequirment masterRequirment;
    //Item item;
    ContractDirectory contractDirectory;
    double totalRequirementQty = 0;
    double totalCommittedQty = 0;
    //ChartPanel pieChartPanel;
    
    public FMCGCropRequirementDashboard(JPanel jp, RequirementOfficer requirementOfficer, Market market, Requirement requirement) {
        initComponents();
        processControlStack = jp;
        this.market = market;
        this.requirementOfficer = requirementOfficer;
        this.requirement = requirement;
        this.masterRequirment = market.getMasterRequirment();
        this.contractDirectory = contractDirectory;
        this.selectedCrop = requirement.getItem().getCrop();
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
    // Assuming enteredQty affects the total requirements.
    totalRequirementQty += enteredQty;  // Update the total requirement quantity

    // Create a new dataset for the updated chart
    DefaultPieDataset updatedDataset = new DefaultPieDataset();
    
    // Assuming we need to redistribute this enteredQty across various FMCGs or just showing the total
    // Here, I'm simply updating the chart to show the new total; adapt this logic to your specific needs
    for (Requirement req : masterRequirment.getRequirements()) {
        if (req.getItem().getCrop().equals(selectedCrop)) {
            updatedDataset.setValue(req.getFmcg().getFmcgName(), req.getItem().getQuantity());
        }
    }

    // Create the chart with updated dataset
    JFreeChart chart = ChartFactory.createPieChart(
            "Total Requirement Distribution", // Chart title
            updatedDataset, // Dataset
            true, // Include legend
            true, // Include tooltips
            false); // Exclude URLs

    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));

    // Revalidate and repaint the chart to reflect new data
    ChartPanel newChartPanel = new ChartPanel(chart);
    newChartPanel.setPreferredSize(new java.awt.Dimension(300, 300));

    // Remove the old chart and add the updated one
    requirementPieChart.removeAll();
    requirementPieChart.add(newChartPanel);
    requirementPieChart.revalidate();
    requirementPieChart.repaint();

    // Update the total requirement text field to reflect new total
    txtTotalRequirement.setText(String.valueOf(totalRequirementQty));
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
        jLabel2 = new javax.swing.JLabel();
        Qunatitybox = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblTotalRequirement = new javax.swing.JLabel();
        txtTotalRequirement = new javax.swing.JTextField();
        lblTotalCommitted = new javax.swing.JLabel();
        txtTotalCommitted = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 550));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Crop Requirment");

        committedPieChart.setBackground(new java.awt.Color(255, 255, 255));
        committedPieChart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        committedPieChart.setPreferredSize(new java.awt.Dimension(275, 275));
        committedPieChart.setLayout(new java.awt.BorderLayout());

        requirementPieChart.setBackground(new java.awt.Color(255, 255, 255));
        requirementPieChart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        requirementPieChart.setPreferredSize(new java.awt.Dimension(275, 275));
        requirementPieChart.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Quantity:");

        Qunatitybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QunatityboxActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDeleteUser.setText("Update");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTotalRequirement.setText("Total Requirement (in Tons):");

        txtTotalRequirement.setEnabled(false);
        txtTotalRequirement.setPreferredSize(new java.awt.Dimension(64, 26));
        txtTotalRequirement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalRequirementActionPerformed(evt);
            }
        });

        lblTotalCommitted.setText("Total Committed (in Tons):");

        txtTotalCommitted.setEnabled(false);
        txtTotalCommitted.setPreferredSize(new java.awt.Dimension(64, 26));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(362, 362, 362))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTotalRequirement)
                        .addGap(87, 87, 87)
                        .addComponent(txtTotalRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(requirementPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(committedPieChart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTotalCommitted)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Qunatitybox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addGap(492, 492, 492))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRequirement)
                    .addComponent(txtTotalRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalCommitted)
                    .addComponent(txtTotalCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(committedPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requirementPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Qunatitybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeleteUser)
                        .addComponent(btnSave)))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void QunatityboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QunatityboxActionPerformed
        // TODO add your handling code here:
        //Qunatitybox.setText(market.getMasterRequirment().searchRequirement(requirementOfficer.getRequirementOffice().getFmcg(), selectedCrop, market));
    }//GEN-LAST:event_QunatityboxActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        processControlStack.remove(this);
        ((java.awt.CardLayout) processControlStack.getLayout()).previous(processControlStack);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtTotalRequirementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalRequirementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalRequirementActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        try {
            if(Qunatitybox.getText().isBlank()){
               JOptionPane.showMessageDialog(null,"Please enter a number!","Warning",JOptionPane.WARNING_MESSAGE);                        
             }else{
                // Attempt to parse the input string to a double
                double enteredQty = Double.parseDouble(Qunatitybox.getText());
                    Item item = new Item(requirement.getItem().getCrop(),enteredQty);
                    //update requirment
                    updateChartPanel(enteredQty);
              }                        
            } catch (NumberFormatException e) {
                // If parsing fails (NumberFormatException is thrown), return false
                JOptionPane.showMessageDialog(null,"Please enter a valid number.","Warning",JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Qunatitybox;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel committedPieChart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalCommitted;
    private javax.swing.JLabel lblTotalRequirement;
    private javax.swing.JPanel requirementPieChart;
    private javax.swing.JTextField txtTotalCommitted;
    private javax.swing.JTextField txtTotalRequirement;
    // End of variables declaration//GEN-END:variables
}
