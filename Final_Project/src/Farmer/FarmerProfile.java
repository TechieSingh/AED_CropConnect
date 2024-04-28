/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmer;

import Contract.Contract;
import PersonUserProfile.Person;
import PersonUserProfile.Profile;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
public class FarmerProfile extends Profile {
    private ArrayList<Contract> farmerContracts;
    private ArrayList<Transaction> farmerTransactions;
    //private MarketDirectory marketDirectory;


    FarmerProfile(Person p) {
        super(p);
        farmerContracts = new ArrayList<>();
        farmerTransactions = new ArrayList<>();
        //this.marketDirectory = marketDirectory;
    }


    public ArrayList<Contract> getFarmerContracts() {
        return farmerContracts;
    }

    public void setFarmerContracts(ArrayList<Contract> farmerContracts) {
        this.farmerContracts = farmerContracts;
    }

    public ArrayList<Transaction> getFarmerTransactions() {
        return farmerTransactions;
    }

    public void setFarmerTransactions(ArrayList<Transaction> farmerTransactions) {
        this.farmerTransactions = farmerTransactions;
    }

//    public MarketDirectory getMarketDirectory() {
//        return marketDirectory;
//    }
//
//    public void setMarketDirectory(MarketDirectory marketDirectory) {
//        this.marketDirectory = marketDirectory;
//    }
    
    public void addTransaction(Transaction transaction){
        this.farmerTransactions.add(transaction);
    }
    
    public void addFarmerContract(Contract contract){
        this.farmerContracts.add(contract);
    }
    
    @Override
    public String getRole() {
        return "Farmer";
    }
    
    

}
