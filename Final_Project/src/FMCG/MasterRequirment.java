/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import Common.Item;
import CropFolder.Crop;
import Market.Market;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author amitanveri
 */
public class MasterRequirment {

    ArrayList<Requirement> requirements = new ArrayList<>();
    Market market;

    public MasterRequirment(Market market) {
        this.market = market;

    }

    public Requirement addRequirement(FMCG fmcg, Item item, Market market) {
        Requirement requirement = searchRequirement(fmcg, item.getCrop(), market);
        if(requirement!=null){
                requirement.getItem().addQuantity(item.getQuantity());
                return requirement;
        }
        requirement = new Requirement(fmcg, item, market);
        requirements.add(requirement);
        return requirement;
    }
    
    public Requirement searchRequirement(FMCG fmcg, Crop crop, Market market){
        for(Requirement requirement: requirements){
            if(requirement.getMarket().equals(market)&&requirement.getItem().getCrop().equals(crop)&&requirement.getFmcg().equals(fmcg)){
                return requirement;
            }
        }
        return null;
    }

    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<Requirement> requirements) {
        this.requirements = requirements;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public ArrayList<Crop> getCropList(){
        ArrayList<Crop> marketCrops = new ArrayList<>();
        for(Requirement req: requirements){
            if(!(marketCrops.contains(req.getItem().getCrop()))){
                marketCrops.add(req.getItem().getCrop());
            }
        }
        return marketCrops;
    }
    
    public double getCropQty(Crop crop){
        double qty = 0;
        for(Requirement req: requirements){
            if(!(req.getItem().getCrop().equals(crop))){
                qty += req.getItem().getQuantity();
            }
        }
    return qty;
    }
}
