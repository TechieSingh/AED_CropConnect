/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmer;

import Contract.Contract;
import Common.Item;
import Distributor.BuyOffer;
import Distributor.Distributor;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
 public class TransactionDirectory {

    ArrayList<Transaction> transactions = new ArrayList<>();

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public Transaction addNewTransaction(FarmerProfile farmerProfile, Distributor distributor, Item item, BuyOffer buyoffer, Contract contract){
        Transaction transaction = new Transaction(farmerProfile, distributor,item, buyoffer, contract);
        transactions.add(transaction);
        farmerProfile.addTransaction(transaction);
        distributor.addDistributorTransaction(transaction);
        return transaction; 
    }
}
