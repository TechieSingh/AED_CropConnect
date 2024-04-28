/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Distributor.WorkArea;

import Common.Item;
import CropFolder.CropDirectory;
import Distributor.DistributorAdmin;
import Distributor.DistributorUserAccount;
import Market.MarketDirectory;
import javax.swing.JPanel;
import Market.Market;
import javax.swing.table.DefaultTableModel;
import FMCG.ProcurementOffer;
import CropFolder.Crop;
import Distributor.FmcgTransaction;
import Distributor.FmcgTransactionDirectory;
import javax.swing.JOptionPane;
/**
 *
 * @author prarthana
 */
public class ProcurementOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CheckRequirementJPanel
     */
    JPanel processControlStack;
    DistributorAdmin distributorAdmin;
    Market market;
    Crop crop;
    FmcgTransactionDirectory fmcgTransactionDirectory;

    
    public ProcurementOrderJPanel(JPanel processControlStack, DistributorAdmin distributorAdmin, Market market, Crop crop,FmcgTransactionDirectory fmcgTransactionDirectory) {
        initComponents();
        this.processControlStack =processControlStack;
        this.distributorAdmin = distributorAdmin;
        this.market = market;
        this.crop = crop;
        this.fmcgTransactionDirectory = fmcgTransactionDirectory;
        populateTable();
        populateTransactions();
        txtStorage.setText(String.valueOf(distributorAdmin.getDistributor().getInventoryOffice().searchInventory(market.getMarketName()).searchStorage(crop).getTotalCapacity()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        processStack = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblListofUsers = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransaction = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProcurement = new javax.swing.JTable();
        txtStorage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        processStack.setBackground(new java.awt.Color(224, 245, 166));
        processStack.setLayout(null);

        btnBack.setText("<-Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        processStack.add(btnBack);
        btnBack.setBounds(790, 30, 73, 23);

        lblListofUsers.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblListofUsers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblListofUsers.setText("Previous Transactions");
        processStack.add(lblListofUsers);
        lblListofUsers.setBounds(30, 340, 840, 17);

        lbl.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl.setText("Procurement Order List");
        processStack.add(lbl);
        lbl.setBounds(30, 10, 840, 28);

        tblTransaction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FMCG Name", "Crop Name", "Quantity", "Grade", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTransaction);

        processStack.add(jScrollPane2);
        jScrollPane2.setBounds(30, 370, 840, 140);

        jButton1.setText("BuyOffer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        processStack.add(jButton1);
        jButton1.setBounds(760, 290, 110, 30);

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        processStack.add(txtQuantity);
        txtQuantity.setBounds(610, 290, 120, 30);

        jLabel1.setText("Quantity:");
        processStack.add(jLabel1);
        jLabel1.setBounds(530, 290, 70, 30);

        jLabel2.setText("Select Crop:");
        processStack.add(jLabel2);
        jLabel2.setBounds(340, 80, 100, 17);

        tblProcurement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "FMCG Name", "Crop Name", "Grade", "Quantity", "Filled Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProcurement);

        processStack.add(jScrollPane3);
        jScrollPane3.setBounds(30, 110, 840, 160);

        txtStorage.setEditable(false);
        txtStorage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStorageActionPerformed(evt);
            }
        });
        processStack.add(txtStorage);
        txtStorage.setBounds(771, 72, 90, 30);

        jLabel3.setText("Stored Quanity:");
        processStack.add(jLabel3);
        jLabel3.setBounds(670, 80, 100, 17);

        jLabel4.setText("Select Market:");
        processStack.add(jLabel4);
        jLabel4.setBounds(50, 80, 100, 17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(processStack, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(processStack, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
//        processControlStack.remove(this);
//        ((java.awt.CardLayout) processControlStack.getLayout()).previous(processControlStack);
        //       ((java.awt.CardLayout)CardSequencePanel.getLayout()).show(CardSequencePanel, "IdentifyEventTypes");
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStorageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStorageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = tblProcurement.getSelectedRow();
            if(selectedRow<0){
                JOptionPane.showMessageDialog(null,"Please select a row from table first!","Warning",JOptionPane.WARNING_MESSAGE);

            }else{
                DefaultTableModel model = (DefaultTableModel) tblProcurement.getModel ();
                //Requirement requirement = (Requirement) model. getValueAt (selectedRow, 0) ;
                ProcurementOffer selectedProcurement = (ProcurementOffer) model.getValueAt (selectedRow, 0);
                double Quantity = Double.parseDouble(txtQuantity.getText());
                Item item = new Item(selectedProcurement.getRequirement().getItem().getCrop(),Quantity);
                FmcgTransaction fmcgTransaction = fmcgTransactionDirectory.newDistributorTransaction(selectedProcurement.getRequirement().getFmcg(), distributorAdmin.getDistributor(), item, selectedProcurement);
                selectedProcurement.addFilledQuantity(Quantity);
                }
            populateTransactions();
            populateTable();
            } catch (Exception e) {
                System.out.println("Exception in view button: " + e.getMessage());
            }         
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblListofUsers;
    private javax.swing.JPanel processStack;
    private javax.swing.JTable tblProcurement;
    private javax.swing.JTable tblTransaction;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtStorage;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {

            DefaultTableModel model =(DefaultTableModel)tblProcurement.getModel();
            model.setRowCount(0);
            for(ProcurementOffer procurmentOffer: market.getProcurementOfferDirectory().getProcurmentOffers()){
                if(procurmentOffer.getRequirement().getItem().getCrop().equals(crop)){
                    if(procurmentOffer.getRequirement().getItem().getQuantity()-procurmentOffer.getFilledQuantity()>0){
                        Object[] row =new Object[6];
                        row[0]=procurmentOffer;
                        row[1]=procurmentOffer.getRequirement().getItem().getCrop().getCropName();
                        row[2]=procurmentOffer.getRequirement().getItem().getCrop().getGrade();
                        row[3]=procurmentOffer.getRequirement().getItem().getQuantity();
                        row[4]=procurmentOffer.getFilledQuantity();
                        row[5]=procurmentOffer.getUnitPrice();
                        model.addRow(row);
                    }
                }
            }
        
    }


    private void populateTransactions() {
        DefaultTableModel model =(DefaultTableModel)tblTransaction.getModel();
        model.setRowCount(0);
        for(FmcgTransaction fmcgTransaction: distributorAdmin.getDistributor().getFmcgTransactions()){
            if(market.equals(fmcgTransaction.getProcurementOffer().getRequirement().getMarket())){
                if(fmcgTransaction.getProcurementOffer().getRequirement().getItem().getCrop().equals(crop)){
                    Object[] row =new Object[5];
                    row[0]=fmcgTransaction.getFmcg().getFmcgName();
                    row[1]=fmcgTransaction.getProcurementOffer().getRequirement().getItem().getCrop().getCropName();
                    row[2]=fmcgTransaction.getProcurementOffer().getRequirement().getItem().getCrop().getGrade();
                    row[3]=fmcgTransaction.getProcurementOffer().getRequirement().getItem().getQuantity();
                    row[4]=fmcgTransaction.getProcurementOffer().getUnitPrice();
                    model.addRow(row);
                }
            }
        }
    }
}
