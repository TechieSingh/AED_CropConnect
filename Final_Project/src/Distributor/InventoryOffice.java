/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import CropFolder.Crop;
import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 */
public class InventoryOffice {

    ArrayList<Inventory> inventorys;
    Distributor distributor;
    ArrayList<InventoryOfficer> inventoryOfficers;

    public InventoryOffice(Distributor distributor) {
        this.distributor = distributor;
        this.inventorys = new ArrayList<>();
        this.inventoryOfficers = new ArrayList<>();
    }

    public ArrayList<Inventory> getInventory() {
        return inventorys;
    }

    public void setInventory(ArrayList<Inventory> inventorys) {
        this.inventorys = inventorys;
    }
    public Inventory addInventory(String market, Crop crop, double Quantity ){
        Inventory inventory = new Inventory(market);
        inventory.addStorage(crop, Quantity);
        inventorys.add(inventory);
        return inventory;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public ArrayList<InventoryOfficer> getInventoryOfficers() {
        return inventoryOfficers;
    }

    public void setInventoryOfficers(ArrayList<InventoryOfficer> inventoryOfficers) {
        this.inventoryOfficers = inventoryOfficers;
    }

    public InventoryOfficer newInventoryOfficer(Person p) {
        InventoryOfficer inventoryOfficer = new InventoryOfficer(p, this);
        return inventoryOfficer;
    }
    
    public Inventory searchInventory(String marketName){
        for(Inventory inventory: inventorys){
            if(inventory.getMarketName().equals(marketName)){
                return inventory;
            }
        }
        return null;
    }
}
