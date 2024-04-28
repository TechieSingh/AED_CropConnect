/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Farmer;

import Distributor.BuyOfferDirectory;
import CropFolder.CropDirectory;
import Market.MarketDirectory;
import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
public class FarmerDirectory {


    ArrayList<FarmerProfile> farmerProfiles = new ArrayList<>();

    public FarmerProfile addNewFarmer(Person p) {
        FarmerProfile farmerProfile = new FarmerProfile(p);
        farmerProfiles.add(farmerProfile);
        return farmerProfile;
    }

    public ArrayList<FarmerProfile> getFarmerProfiles() {
        return farmerProfiles;
    }
    
    public void deleteFarmer(FarmerProfile fp){
        farmerProfiles.remove(fp);
    }
}
