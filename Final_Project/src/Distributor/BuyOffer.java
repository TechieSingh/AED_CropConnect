/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import Common.Item;
import Market.Market;
/**
 *
 * @author prarthana
 */
//Represents the offer made my Distributor admin office to farmer
public class BuyOffer {
    Market market;
    DistributorAdmin distributorAdmin;
    Item item;
    double unitPrice;

    public BuyOffer(Market market, DistributorAdmin distributorAdmin, Item item, double unitPrice) {
        this.market = market;
        this.distributorAdmin = distributorAdmin;
        this.item = item;
        this.unitPrice = unitPrice;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public DistributorAdmin getDistributorAdmin() {
        return distributorAdmin;
    }

    public void setDistributorAdmin(DistributorAdmin distributorAdmin) {
        this.distributorAdmin = distributorAdmin;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    @Override
    public String toString(){
        return getDistributorAdmin().getDistributor().getDistributorName();
    }
    
    
    
}
