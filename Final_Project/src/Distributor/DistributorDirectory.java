/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import Market.MarketDirectory;
import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
public class DistributorDirectory {

    ArrayList<Distributor> distributors;

    public DistributorDirectory() {
        this.distributors = new ArrayList<>();
    }

    public Distributor newDistributor(String distributorName, Person p) {
        Distributor distributor = new Distributor(distributorName, p);
        distributors.add(distributor);
        return distributor;
    }

    public ArrayList<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(ArrayList<Distributor> distributors) {
        this.distributors = distributors;
    }

    public void deleteDistributor(Distributor d) {
        distributors.remove(d);
    }
    public Distributor searchDistributor(String DistributorName) {
        for(Distributor distributor :distributors){
            if(distributor.getDistributorName().equals(DistributorName)){
                return distributor;
            }
        }
        return null;
    }
}
