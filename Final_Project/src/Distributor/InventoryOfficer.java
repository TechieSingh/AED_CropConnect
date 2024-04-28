/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import FMCG.EmployeeProfile;
import PersonUserProfile.Person;
import PersonUserProfile.Profile;

/**
 *
 * @author amitanveri
 */
public class InventoryOfficer extends Profile {

    InventoryOffice inventoryOffice;

    public InventoryOfficer(Person p,InventoryOffice inventoryOffice) {
        super(p);
        this.inventoryOffice =inventoryOffice;
    }

    public InventoryOffice getInventoryOffice() {
        return inventoryOffice;
    }

    public void setInventoryOffice(InventoryOffice inventoryOffice) {
        this.inventoryOffice = inventoryOffice;
    }

    
    @Override
    public String getRole() {
        return "InventoryOfficer";
    }
}
