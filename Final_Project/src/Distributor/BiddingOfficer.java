/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import PersonUserProfile.Person;
import PersonUserProfile.Profile;

/**
 *
 * @author prart
 */
public class BiddingOfficer extends Profile {

    public BiddingOfficer(Person p) {
        super(p);
    }
    
    @Override
    public String getRole() {
        return "BiddingOfficer" ;
    }
    
}
