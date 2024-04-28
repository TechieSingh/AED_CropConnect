/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.SystemAdmin.WorkArea;

import Business.EcoSystem;
import Farmer.Transaction;
import Farmer.TransactionDirectory;
import Market.Market;
import Market.MarketDirectory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amitanveri
 */
public class FarmerTransactionsJPanel extends javax.swing.JPanel {

    JPanel sysadminProcessStack;
    EcoSystem ecosystem;

    public FarmerTransactionsJPanel(EcoSystem eco, JPanel jp) {
        initComponents();
        ecosystem = eco;
        sysadminProcessStack = jp;
        populateMarketComboBox();
        cmbMarketActionPerformed(null);
    }

    private void populateMarketComboBox() {
        MarketDirectory marketDirectory = ecosystem.getMarketDirectory();
        cmbMarket.removeAllItems(); // Clear existing items
        for (Market market : marketDirectory.getMarkets()) {
            cmbMarket.addItem(market.getMarketName());
        }
        if (cmbMarket.getItemCount() > 0) {
            cmbMarket.setSelectedIndex(0);  // Set default selection to the first item
        }
    }

    private void populateTable(List<Transaction> transactions) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing data

        for (Transaction transaction : transactions) {
            Object[] row = new Object[5];
            row[0] = transaction.getFarmerProfile().getPerson().getFullName();
            row[1] = transaction.getDistributor().getDistributorName();
            row[2] = transaction.getItem().getCrop().getCropName();
            row[3] = transaction.getItem().getQuantity();
            row[4] = transaction.getBuyOffer().getUnitPrice();

            model.addRow(row);
        }
    }

    /**
     * Retrieves all transactions for a specific market from a given transaction
     * directory and returns them. Useful for tracking farmer-to-distributor
     * transactions within specific market settings.
     *
     * @param transactionDirectory directory containing all transactions.
     * @param marketName the name of the market for which transactions are to be
     * retrieved.
     * @return a list of transactions that occurred in the specified market.
     */
    public List<Transaction> getTransactionsForMarket(TransactionDirectory transactionDirectory, String marketName) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactionDirectory.getTransactions()) {
            Market market = transaction.getBuyOffer().getMarket();
            if (market.getMarketName().equals(marketName)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
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
        jLabel2 = new javax.swing.JLabel();
        cmbMarket = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("FARMER TRANSACTIONS");

        jLabel2.setText("Select Market:");

        cmbMarket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarketActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Farmer", "Distributor", "Item", "Quantity", "Price (Per Ton)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("<<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cmbMarket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                        .addGap(227, 227, 227))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMarket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMarketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarketActionPerformed
        String selectedMarketName = (String) cmbMarket.getSelectedItem();
        if (selectedMarketName != null) {
            TransactionDirectory transactionDirectory = ecosystem.getTransactionDirectory();
            List<Transaction> filteredTransactions = getTransactionsForMarket(transactionDirectory, selectedMarketName);
            populateTable(filteredTransactions);
        }
    }//GEN-LAST:event_cmbMarketActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        sysadminProcessStack.remove(this);
        ((java.awt.CardLayout) sysadminProcessStack.getLayout()).previous(sysadminProcessStack);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbMarket;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}