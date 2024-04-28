/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import Contract.ContractDirectory;
import Farmer.Transaction;
import Market.MarketDirectory;
import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 * @author Prarthana
 * 
 */
public class Distributor {

    String distributorName;
    InventoryOffice inventoryOffice;
    TransportOffice transportOffice;
    DistributorAdmin distributorAdmin;
    DistributorUserAccountDirectory distributorUserAccountDirectory;
    ArrayList<Transaction> distributorTransaction;
    ArrayList<FmcgTransaction> fmcgTransactions;

    //todo communication between these 3 offices
    public Distributor(String distributorName, Person p) {
        this.distributorName = distributorName;
        this.inventoryOffice = new InventoryOffice(this);
        this.transportOffice = new TransportOffice(this);
        this.distributorAdmin = new DistributorAdmin(p,this);
        this.distributorUserAccountDirectory = new DistributorUserAccountDirectory();
        this.distributorTransaction = new ArrayList<>();
        this.fmcgTransactions = new ArrayList<>();
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public InventoryOffice getInventoryOffice() {
        return inventoryOffice;
    }

    public void setInventoryOffice(InventoryOffice inventoryOffice) {
        this.inventoryOffice = inventoryOffice;
    }

    public TransportOffice getTransportOffice() {
        return transportOffice;
    }

    public void setTransportOffice(TransportOffice transportOffice) {
        this.transportOffice = transportOffice;
    }

    public DistributorAdmin getDistributorAdmin() {
        return distributorAdmin;
    }

    public void setDistributorAdmin(DistributorAdmin adminDepartment) {
        this.distributorAdmin = adminDepartment;
    }

    public DistributorUserAccountDirectory getDistributorUserAccountDirectory() {
        return distributorUserAccountDirectory;
    }

    public void setDistributorUserAccountDirectory(DistributorUserAccountDirectory distributorUserAccountDirectory) {
        this.distributorUserAccountDirectory = distributorUserAccountDirectory;
    }

    public ArrayList<Transaction> getDistributorTransaction() {
        return distributorTransaction;
    }

    public void setDistributorTransaction(ArrayList<Transaction> distributorTransaction) {
        this.distributorTransaction = distributorTransaction;
    }

    public void addDistributorTransaction(Transaction transaction){
        distributorTransaction.add(transaction);
    }

    public void addFmcgTransaction(FmcgTransaction transaction) {
        fmcgTransactions.add(transaction);
    }

    public ArrayList<FmcgTransaction> getFmcgTransactions() {
        return fmcgTransactions;
    }

    public void setFmcgTransactions(ArrayList<FmcgTransaction> fmcgTransactions) {
        this.fmcgTransactions = fmcgTransactions;
    }
    
    
    
}
