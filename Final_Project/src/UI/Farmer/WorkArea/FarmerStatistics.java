/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Farmer.WorkArea;

import Common.Item;
import CropFolder.Crop;
import Distributor.BuyOffer;
import FMCG.MasterRequirment;
import FMCG.Requirement;
import FMCG.SeasonNew;
import Farmer.FarmerProfile;
import Farmer.Transaction;
import Market.Market;
import Market.MarketDirectory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sagar
 */
public class FarmerStatistics extends javax.swing.JPanel {

    /**
     * Creates new form FarmerStatistics
     */
    JPanel farmerProcessStack;
    MarketDirectory marketDirectory;
    FarmerProfile farmerProfile;

    public FarmerStatistics(MarketDirectory marketDirectory, JPanel jp, FarmerProfile profile) {
        initComponents();
        farmerProcessStack = jp;
        this.marketDirectory = marketDirectory;
        farmerProfile = profile;
        populateTotalEarnings();
        populateCmbCrops();
        populateCmbMarkets();
        populateCmbMarkets1();
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
        txtTotalEarnings = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCrops = new javax.swing.JComboBox<>();
        lblAvgSellingPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbMarkets = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTopCrops = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbMarkets1 = new javax.swing.JComboBox<>();
        tblCropQuantity = new javax.swing.JScrollPane();
        tblCropQuanitty = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setText("Total Earnings :");

        jLabel2.setText("Average Selling Price of Crop:");

        cmbCrops.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCrops.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCropsActionPerformed(evt);
            }
        });

        jLabel3.setText("Top 3 Crops By Offers");

        cmbMarkets.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMarkets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarketsActionPerformed(evt);
            }
        });

        jLabel4.setText("Select Market:");

        tblTopCrops.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Crop Name", "Buy Offers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTopCrops);

        jLabel5.setText("Previous Market Requirements:");

        jLabel6.setText("Select Market:");

        cmbMarkets1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMarkets1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarkets1ActionPerformed(evt);
            }
        });

        tblCropQuanitty.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Quantity (Tons)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCropQuantity.setViewportView(tblCropQuanitty);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtTotalEarnings, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmbCrops, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(lblAvgSellingPrice)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbMarkets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbMarkets1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tblCropQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotalEarnings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCrops, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvgSellingPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMarkets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(cmbMarkets1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tblCropQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCropsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCropsActionPerformed
        String selectedCropName = (String) cmbCrops.getSelectedItem();
        if (selectedCropName != null) {
            double avgPrice = calculateAveragePricePerCrop(selectedCropName, farmerProfile);
            lblAvgSellingPrice.setText(String.format("%.2f", avgPrice));
        } else {
            lblAvgSellingPrice.setText("");
        }
    }//GEN-LAST:event_cmbCropsActionPerformed

    private void cmbMarketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarketsActionPerformed
        String selectedMarketName = (String) cmbMarkets.getSelectedItem();
        if (selectedMarketName != null) {
            Market selectedMarket = marketDirectory.searchMarkets(selectedMarketName);
            if (selectedMarket != null) {
                marketSelected(selectedMarket);
            }
        }
    }//GEN-LAST:event_cmbMarketsActionPerformed

    private void cmbMarkets1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarkets1ActionPerformed
        String selectedMarketName = (String) cmbMarkets1.getSelectedItem();
        if (selectedMarketName != null) {
            Market selectedMarket = marketDirectory.searchMarkets(selectedMarketName);
            if (selectedMarket != null && selectedMarket.getSeason() == SeasonNew.END) {
                populateCropQuantitiesTable(selectedMarket);
            }
        }
    }//GEN-LAST:event_cmbMarkets1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCrops;
    private javax.swing.JComboBox<String> cmbMarkets;
    private javax.swing.JComboBox<String> cmbMarkets1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblAvgSellingPrice;
    private javax.swing.JTable tblCropQuanitty;
    private javax.swing.JScrollPane tblCropQuantity;
    private javax.swing.JTable tblTopCrops;
    private javax.swing.JTextField txtTotalEarnings;
    // End of variables declaration//GEN-END:variables

    private void populateTotalEarnings() {
        double totalEarnings = 0.0;
        for (Transaction transaction : farmerProfile.getFarmerTransactions()) {
            Item item = transaction.getItem();
            double unitPrice = transaction.getBuyOffer().getUnitPrice();
            double quantity = item.getQuantity();
            totalEarnings += unitPrice * quantity;
        }
        txtTotalEarnings.setText("" + totalEarnings);
    }

    private void populateCmbCrops() {
        HashSet<String> cropNames = new HashSet<>();
        for (Transaction transaction : farmerProfile.getFarmerTransactions()) {
            String cropName = transaction.getItem().getCrop().getCropName();
            cropNames.add(cropName);
        }

        cmbCrops.removeAllItems();
        boolean isFirstItem = true;
        for (String cropName : cropNames) {
            cmbCrops.addItem(cropName);
            if (isFirstItem) {
                cmbCrops.setSelectedItem(cropName);  // Automatically select the first item
                isFirstItem = false;
            }
        }

        if (!isFirstItem) { // if at least one item was added
            String selectedCropName = (String) cmbCrops.getSelectedItem();
            if (selectedCropName != null) {
                double avgPrice = calculateAveragePricePerCrop(selectedCropName, farmerProfile);
                lblAvgSellingPrice.setText(String.format("%.2f", avgPrice));
            } else {
                lblAvgSellingPrice.setText("");
            }  // Call this to update the price display immediately
        }
    }

    private double calculateAveragePricePerCrop(String cropName, FarmerProfile farmerProfile) {
        double totalRevenue = 0;
        double totalQuantity = 0;
        for (Transaction transaction : farmerProfile.getFarmerTransactions()) {
            if (transaction.getItem().getCrop().getCropName().equals(cropName)) {
                totalRevenue += transaction.getBuyOffer().getUnitPrice() * transaction.getItem().getQuantity();
                totalQuantity += transaction.getItem().getQuantity();
            }
        }
        return totalRevenue / totalQuantity;
    }

    private void populateCmbMarkets() {
        cmbMarkets.removeAllItems(); // Clear existing items
        for (Market market : marketDirectory.getMarkets()) {
            cmbMarkets.addItem(market.getMarketName());
        }

        if (cmbMarkets.getItemCount() > 0) {
            cmbMarkets.setSelectedIndex(0);  // Set the first item as selected
        } else {
            clearMarketSelection();  // Clear or reset UI if there are no markets to select
        }
    }

    private void clearMarketSelection() {
        DefaultTableModel model = (DefaultTableModel) tblTopCrops.getModel();
        model.setRowCount(0);  // Clear the table since there's no market selected
    }

    private void marketSelected(Market market) {
        DefaultTableModel model = (DefaultTableModel) tblTopCrops.getModel();
        model.setRowCount(0);  // Clear the existing rows

        HashMap<String, Integer> cropOfferCounts = new HashMap<>();
        for (BuyOffer offer : market.getBuyOfferDirectory().getBuyOffers()) {
            String cropName = offer.getItem().getCrop().getCropName();
            cropOfferCounts.put(cropName, cropOfferCounts.getOrDefault(cropName, 0) + 1);
        }

        List<Map.Entry<String, Integer>> topCrops = cropOfferCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());

        // Populate the table model with the top crops
        for (Map.Entry<String, Integer> entry : topCrops) {
            model.addRow(new Object[]{entry.getKey(), entry.getValue()});
        }
    }

    private void populateCropQuantitiesTable(Market market) {
        HashMap<Crop, Double> cropQuantities = new HashMap<>();
        MasterRequirment masterRequirment = market.getMasterRequirment();
        for (Requirement requirement : masterRequirment.getRequirements()) {
            Item item = requirement.getItem();
            Crop crop = item.getCrop();
            double quantity = item.getQuantity();
            cropQuantities.merge(crop, quantity, Double::sum);
        }
        updateCropQuantitiesTable(cropQuantities);
    }

    private void updateCropQuantitiesTable(HashMap<Crop, Double> cropQuantities) {
        DefaultTableModel model = (DefaultTableModel) tblCropQuanitty.getModel();
        model.setRowCount(0);
        for (Map.Entry<Crop, Double> entry : cropQuantities.entrySet()) {
            model.addRow(new Object[]{entry.getKey().getCropName(), entry.getValue()});
        }
    }

    private void populateCmbMarkets1() {
        cmbMarkets1.removeAllItems(); // Clear existing items
        Market defaultMarket = null;
        for (Market market : marketDirectory.getMarkets()) {
            if (market.getSeason() == SeasonNew.END) {
                cmbMarkets1.addItem(market.getMarketName());
                if (defaultMarket == null) {
                    defaultMarket = market;  // Set the first END phase market as default
                }
            }
        }

        if (defaultMarket != null) {
            cmbMarkets1.setSelectedItem(defaultMarket.getMarketName());
            populateCropQuantitiesTable(defaultMarket);
        }
    }

}
