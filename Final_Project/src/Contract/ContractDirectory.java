/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contract;

import Common.Item;
import Farmer.FarmerProfile;
import Market.Market;
import java.util.ArrayList;
import CropFolder.Crop;

/**
 *
 * @author amitanveri
 */
public class ContractDirectory {

    ArrayList<Contract> contracts;

    public ContractDirectory() {
        this.contracts = new ArrayList<>();
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public Contract NewContract(Market market, FarmerProfile farmer, Item item) {
        Contract contract = searchContract(market, item.getCrop(), farmer);
        if (contract != null) {
            contract.getSelectedItem().addQuantity(item.getQuantity());
            return contract;
        }
        contract = new Contract(market, farmer, item);
        contracts.add(contract);
        market.addMarketContract(contract);
        farmer.addFarmerContract(contract);
        return contract;
    }

    public Contract searchContract(Market market, Crop crop, FarmerProfile farmerProfile) {

        for (Contract contract : contracts) {
            if (contract.getMarket().equals(market) && contract.getSelectedItem().getCrop().equals(crop) && contract.getFarmer().equals(farmerProfile)) {
                return contract;
            }
        }
        return null;
    }

//    private void createSupplyList() {
//        for(Contract contract:contracts){
//            for(Item item: contract.getSelectedCrops()){
//                if(MasterSupplyList.keySet().contains(item.getCrop())){
//                   MasterSupplyList.get(item.getCrop()).addQuantity(item.getQuantity());
//                }
//                else{
//                    MasterSupplyList.put(item.getCrop(),item.getQuantity());
//                }
//            }
//        }
//    }
}
