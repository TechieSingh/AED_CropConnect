/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 */
public class TransportOffice {

    Distributor distributor;
    ArrayList<TransportOfficer> transportOfficers;

    public TransportOffice(Distributor distributor) {
        this.distributor = distributor;
        transportOfficers = new ArrayList<>();
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public ArrayList<TransportOfficer> getTransportOfficers() {
        return transportOfficers;
    }

    public void setTransportOfficers(ArrayList<TransportOfficer> transportOfficers) {
        this.transportOfficers = transportOfficers;
    }
    
    public TransportOfficer newTransportOfficers(Person person) {
        TransportOfficer transportOfficer = new TransportOfficer(person, this);
        transportOfficers.add(transportOfficer);
        return transportOfficer;
    }

}
