/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.FMCG.WorkArea.Admin;

import Contract.Contract;
import Contract.ContractDirectory;
import CropFolder.Crop;
import FMCG.MasterRequirment;
import FMCG.ProcurementOfficer;
import FMCG.Requirement;
import FMCG.RequirementOfficer;
import Market.Market;
import java.awt.Color;
import java.awt.Font;
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
public class FMCGCropProcurementDashboard extends javax.swing.JPanel {

    /**
     * Creates new form ViewCropRequirements
     */

    JPanel processControlStack;
    ChartPanel pieChartPanel;
    ProcurementOfficer procurementOfficer;
    Requirement requirement;
    Crop selectedCrop;
    Market market;
    MasterRequirment masterRequirment;
    //Item item;
    ContractDirectory contractDirectory;
    double totalRequirementQty = 0;
    double totalCommittedQty = 0;
    
    FMCGCropProcurementDashboard(JPanel jp,ProcurementOfficer procurementOfficer,Market market, Requirement requirement) {
        initComponents();
        processControlStack = jp;
        this.market = market;
        this.procurementOfficer = procurementOfficer;
        this.requirement = requirement;
        this.masterRequirment = market.getMasterRequirment();
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
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblTotalRequirement = new javax.swing.JLabel();
        txtTotalRequirement = new javax.swing.JTextField();
        lblTotalCommitted = new javax.swing.JLabel();
        txtTotalCommitted = new javax.swing.JTextField();
        txtQunatity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 550));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Crop Procurement");

        committedPieChart.setBackground(new java.awt.Color(255, 255, 255));
        committedPieChart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        committedPieChart.setPreferredSize(new java.awt.Dimension(275, 275));
        committedPieChart.setLayout(new java.awt.BorderLayout());

        requirementPieChart.setBackground(new java.awt.Color(255, 255, 255));
        requirementPieChart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        requirementPieChart.setPreferredSize(new java.awt.Dimension(275, 275));
        requirementPieChart.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Quantity:");

        jLabel3.setText("Price:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(342, 342, 342))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTotalRequirement)
                                    .addGap(87, 87, 87)
                                    .addComponent(txtTotalRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(519, 519, 519)
                                    .addComponent(lblTotalCommitted)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTotalCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(committedPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(requirementPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQunatity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSave)
                                    .addComponent(btnUpdate))))
                        .addContainerGap(531, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRequirement)
                    .addComponent(txtTotalRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalCommitted)
                    .addComponent(txtTotalCommitted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requirementPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(committedPieChart, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtQunatity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate))
                        .addGap(4, 4, 4)
                        .addComponent(btnSave)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel committedPieChart;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalCommitted;
    private javax.swing.JLabel lblTotalRequirement;
    private javax.swing.JPanel requirementPieChart;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQunatity;
    private javax.swing.JTextField txtTotalCommitted;
    private javax.swing.JTextField txtTotalRequirement;
    // End of variables declaration//GEN-END:variables
}
