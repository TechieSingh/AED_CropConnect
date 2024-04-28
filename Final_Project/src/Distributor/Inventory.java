/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import Common.Item;
import CropFolder.Crop;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 */
public class Inventory {

    String marketName;
    ArrayList<Storage> storages;

    public Inventory(String market) {
        this.marketName = market;
        this.storages = new ArrayList<>();
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public ArrayList<Storage> getStorages() {
        return storages;
    }

    public void setStorages(ArrayList<Storage> storages) {
        this.storages = storages;
    }

    public Storage addStorage(Crop crop, double Qauntity){
        Storage storage = new Storage(crop, Qauntity);
        storages.add(storage);
        return storage;
    }
    
    public Storage searchStorage(Crop crop){
        for(Storage storage :storages){
            if(storage.getCrop().equals(crop)){
                return storage;
            }
        }
        return null;
    }
}
