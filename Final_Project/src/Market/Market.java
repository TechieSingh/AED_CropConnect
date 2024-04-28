/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Market;

import Contract.Contract;
import Distributor.BuyOfferDirectory;
import Contract.ContractDirectory;
import CropFolder.Crop;
import FMCG.MasterRequirment;
import FMCG.ProcurementOfferDirectory;
//import FMCG.Season;
import FMCG.SeasonNew;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author amitanveri
 * @author Prarthana
 */
public class Market {

    private String marketName;
    private SeasonNew season;
    private MasterRequirment masterRequirment;
    private ArrayList<Contract> marketContracts;
    private BuyOfferDirectory buyOfferDirectory; //whenever farmer buys remove offer from this directory
    private ProcurementOfferDirectory procurementOfferDirectory;
    
    public Market(String marketName) {
        this.marketName = marketName;
        this.masterRequirment = new MasterRequirment(this);
        this.marketContracts = new ArrayList<>();
        this.buyOfferDirectory = new BuyOfferDirectory();
        this.procurementOfferDirectory = new ProcurementOfferDirectory();
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public MasterRequirment getMasterRequirment() {
        return masterRequirment;
    }

    public void setMasterRequirment(MasterRequirment masterRequirment) {
        this.masterRequirment = masterRequirment;
    }

    public SeasonNew getSeason() {
        return season;
    }
 
    public void setSeason(SeasonNew season) {
        this.season = season;
    }

    public ArrayList<Contract> getMarketContracts() {
        return marketContracts;
    }

    public void setMarketContracts(ArrayList<Contract> marketContracts) {
        this.marketContracts = marketContracts;
    }
    
    public void addMarketContract(Contract contract){
        marketContracts.add(contract);
    }

    public BuyOfferDirectory getBuyOfferDirectory() {
        return buyOfferDirectory;
    }

    public void setBuyOfferDirectory(BuyOfferDirectory buyOfferDirectory) {
        this.buyOfferDirectory = buyOfferDirectory;
    }

    public ProcurementOfferDirectory getProcurementOfferDirectory() {
        return procurementOfferDirectory;
    }

    public void setProcurementOfferDirectory(ProcurementOfferDirectory procurementOfferDirectory) {
        this.procurementOfferDirectory = procurementOfferDirectory;
    }
    
    
    public double getTotalContarctQuantity(Crop crop){
        double quantity =0;
        for(Contract contract:marketContracts){
            if(contract.getSelectedItem().getCrop().equals(crop)){
                quantity +=contract.getSelectedItem().getQuantity();
            }
        }
        return quantity;
    }
    
    @Override
    public String toString(){
        return getMarketName();
    }
}
