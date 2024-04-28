/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmer;

import Contract.Contract;
import Common.Item;
import Distributor.BuyOffer;
import Distributor.Distributor;

/**
 *
 * @author prart
 */
public class Transaction {

    FarmerProfile farmerProfile;
    Distributor distributor;
    Item item;
    BuyOffer buyOffer;
    Contract contract;
    boolean transit; 
    boolean inventoryApproved;
    
    public Transaction(FarmerProfile farmerProfile, Distributor distributor, Item item, BuyOffer buyOffer, Contract contract) {
        this.farmerProfile = farmerProfile;
        this.distributor = distributor;
        this.item = item;
        this.buyOffer = buyOffer;
        this.contract = contract;
        this.transit = false;
        this.inventoryApproved = false;
        
    }
   
    public FarmerProfile getFarmerProfile() {
        return farmerProfile;
    }

    public void setFarmerProfile(FarmerProfile farmerProfile) {
        this.farmerProfile = farmerProfile;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BuyOffer getBuyOffer() {
        return buyOffer;
    }

    public void setBuyOffer(BuyOffer buyOffer) {
        this.buyOffer = buyOffer;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public boolean isTransit() {
        return transit;
    }

    public void setTransit() {
        this.transit = true;
    }

    public boolean isInventoryApproved() {
        return inventoryApproved;
    }

    public void setInventoryApproved() {
        this.inventoryApproved = true;
    }
    
    
}
