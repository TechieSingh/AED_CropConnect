/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import FMCG.ProcurementOfferDirectory;
import FMCG.EmployeeProfile;
import Market.MarketDirectory;
import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 * @author Prarthana
 * 
 */
public class DistributorAdmin extends EmployeeProfile {

    Distributor distributor;
//    MarketDirectory marketDirectory;
    ProcurementOfferDirectory procurementOfferDirectory;// This directory holds the sales made to FMCG
    ArrayList<BuyOffer> DistributorBuyOffer;
    
    public DistributorAdmin(Person p, Distributor distributor ) {
        super(p);
        this.distributor= distributor;
//        this.marketDirectory = marketDirectory;
        this.procurementOfferDirectory = new ProcurementOfferDirectory();
        this.DistributorBuyOffer = new ArrayList<>();
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

//    public MarketDirectory getMarketDirectory() {
//        return marketDirectory;
//    }
//
//    public void setMarketDirectory(MarketDirectory marketDirectory) {
//        this.marketDirectory = marketDirectory;
//    }

    public ProcurementOfferDirectory getProcurementOfferDirectory() {
        return procurementOfferDirectory;
    }

    public void setProcurementOfferDirectory(ProcurementOfferDirectory procurementOfferDirectory) {
        this.procurementOfferDirectory = procurementOfferDirectory;
    }

    public ArrayList<BuyOffer> getDistributorBuyOffer() {
        return DistributorBuyOffer;
    }

    public void setDistributorBuyOffer(ArrayList<BuyOffer> DistributorBuyOffer) {
        this.DistributorBuyOffer = DistributorBuyOffer;
    }

    public void addBuyOffer(BuyOffer buyOffer){
        DistributorBuyOffer.add(buyOffer);
    }
    
    
    @Override
    public String getRole(){
        return "Distributor Admin";
    }
    
}
