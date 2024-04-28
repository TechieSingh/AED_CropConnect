/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contract;

import Common.Item;
import Farmer.FarmerProfile;
import Farmer.Transaction;
import Market.Market;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
public class Contract {

    Market market;
    FarmerProfile farmer;
    Item selectedItem;
    boolean qualityAssuranceApproval;
    double filledqty;
    
    //ArrayList<Transaction> transactions;

    public Contract(Market market, FarmerProfile farmer, Item item) {
        this.market = market;
        this.farmer = farmer;
        this.selectedItem = item; 
        this.qualityAssuranceApproval = false;
        this.filledqty = 0;
    }

//    public Transaction addNewTransaction(Transaction transaction) {
//        transactions.add(transaction);
//        return transaction;
//    }

//    public Item addNewCrop(Item item) {
//        selectedCrops.add(item);
//        return item;
//    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public FarmerProfile getFarmer() {
        return farmer;
    }

    public void setFarmer(FarmerProfile farmer) {
        this.farmer = farmer;
    }



//    public ArrayList<Transaction> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(ArrayList<Transaction> transactions) {
//        this.transactions = transactions;
//    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    public boolean isQualityAssuranceApproval() {
        return qualityAssuranceApproval;
    }

    public void setQualityAssuranceApproval(boolean qualityAssuranceApproval) {
        this.qualityAssuranceApproval = qualityAssuranceApproval;
    }
    public double getFilledqty() {
        return filledqty;
    }

    public void setFilledqty(double filledqty) {
        this.filledqty = filledqty;
    }
    
    public double addFilledqty(double newQty){
        filledqty+=newQty;
        return filledqty;
    }
    
    @Override
    public String toString(){
        return getSelectedItem().getCrop().getCropName();
    }
}
