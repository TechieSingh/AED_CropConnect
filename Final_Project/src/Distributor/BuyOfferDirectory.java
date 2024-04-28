/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import Common.Item;
import Market.Market;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 */
public class BuyOfferDirectory {

    private ArrayList<BuyOffer> buyOffers = new ArrayList<>();

    public ArrayList<BuyOffer> getBuyOffers() {
        return buyOffers;
    }

    public BuyOffer newBuyOffer(Market market, DistributorAdmin distributorAdmin, Item item, double unitPrice) {
         BuyOffer buyOffer = new BuyOffer(market,distributorAdmin,item,unitPrice);
         distributorAdmin.addBuyOffer(buyOffer);
         buyOffers.add(buyOffer);
         return buyOffer;
    }
    
    public BuyOffer searchBuyOffer(Item item){
        for(BuyOffer buyOffer:buyOffers){
           if(buyOffer.getItem().equals(item)){
               return buyOffer;
           } 
        }
        return null;
    }
    

}
