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
public class TransportOfficer extends Profile {

    TransportOffice transportOffice;

    public TransportOfficer(Person p,TransportOffice transportOffice) {
        super(p);
        this.transportOffice= transportOffice;
    }

    public TransportOffice getTransportOffice() {
        return transportOffice;
    }

    public void setTransportOffice(TransportOffice transportOffice) {
        this.transportOffice = transportOffice;
    }

    @Override
    public String getRole() {
        return "TransportOfficer";
    }
}
