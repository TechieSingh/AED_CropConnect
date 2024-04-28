/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdmin.WorkArea;

import Business.EcoSystem;
import CropFolder.CropDirectory;
import CropFolder.Crop;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sagar
 */
public class ManageCrops extends javax.swing.JPanel {

    /**
     * Creates new form ManageCrops
     */
    JPanel sysadminProcessStack;
    EcoSystem ecosystem;
    CropDirectory cropdirectory;
    public ManageCrops(EcoSystem eco, JPanel jp) {
        initComponents();
        sysadminProcessStack = jp;
        ecosystem = eco;
        cropdirectory = ecosystem.getCropDirectory();
        populateCrops();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCropsList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblCrop = new javax.swing.JLabel();
        lblGrade = new javax.swing.JLabel();
        txtCropName = new javax.swing.JTextField();
        txtGrade = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblManageCrops = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        tblCropsList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Crop Name", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCropsList);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Crop Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        lblCrop.setText("Crop Name:");

        lblGrade.setText("Grade:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(lblCrop)
                .addGap(18, 18, 18)
                .addComponent(txtCropName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(lblGrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCrop)
                    .addComponent(lblGrade)
                    .addComponent(txtCropName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(20, 20, 20))
        );

        lblManageCrops.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblManageCrops.setText("Manage Crops");

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBack)
                            .addGap(318, 318, 318)
                            .addComponent(lblManageCrops))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManageCrops)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        sysadminProcessStack.remove(this);
        ((java.awt.CardLayout) sysadminProcessStack.getLayout()).previous(sysadminProcessStack);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            if (!txtCropName.getText().isBlank() && !txtGrade.getText().isBlank()){
            cropdirectory.newCrop(String.valueOf(txtCropName.getText()), String.valueOf(txtGrade.getText()));
            populateCrops();
            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill all details.","Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Exception in Add Crop button: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            int selectedRow = tblCropsList.getSelectedRow();
            if(selectedRow>=0)
                {
                    DefaultTableModel model = (DefaultTableModel) tblCropsList.getModel();
                    Crop selectedcrop = (Crop) model.getValueAt(selectedRow, 0);
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the selected Crop?","Warning",dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION)
                       {
                          cropdirectory.deleteCrop(selectedcrop);
                          populateCrops();
                       }
                }
            else
            {
                JOptionPane.showMessageDialog(null,"Please select a row from table first!","Warning",JOptionPane.WARNING_MESSAGE);
            }
            
        } catch (Exception e) {
            System.out.println("Exception in Delete Crop button: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void populateCrops() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblCropsList.getModel();
            model.setRowCount(0);
            for (Crop c : cropdirectory.getCrops()) {

                Object[] row = new Object[2];
                row[0] = c;
                row[1] = c.getGrade();

                ((DefaultTableModel) tblCropsList.getModel()).addRow(row);
            }
        } catch (Exception e) {
            System.out.println("Exception in populating crops: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCrop;
    private javax.swing.JLabel lblGrade;
    private javax.swing.JLabel lblManageCrops;
    private javax.swing.JTable tblCropsList;
    private javax.swing.JTextField txtCropName;
    private javax.swing.JTextField txtGrade;
    // End of variables declaration//GEN-END:variables
}
