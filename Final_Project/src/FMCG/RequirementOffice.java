/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import Common.Item;
import PersonUserProfile.Person;
import java.util.ArrayList;
import Market.Market;
/**
 *
 * @author amitanveri
 */
public class RequirementOffice {

    FMCG fmcg;
    ArrayList<RequirementOfficer> requirementOfficers;
    ArrayList<Requirement> fmcgRequirement;
    
    public RequirementOffice(FMCG fmcg) {
        this.fmcg = fmcg;
        this.requirementOfficers = new ArrayList<>();
        this.fmcgRequirement = new ArrayList<>();
    }

    public RequirementOfficer addRequirementOfficer(Person p) {
        RequirementOfficer requirementOfficer = new RequirementOfficer(p);
        requirementOfficers.add(requirementOfficer);
        return requirementOfficer;
    }

    public void removeRequirementOfficer(RequirementOfficer requirementOfficer) {
        requirementOfficers.remove(requirementOfficer);
    }

    public FMCG getFmcg() {
        return fmcg;
    }

    public void setFmcg(FMCG fmcg) {
        this.fmcg = fmcg;
    }

    public ArrayList<RequirementOfficer> getRequirementOfficers() {
        return requirementOfficers;
    }

    public void setRequirementOfficers(ArrayList<RequirementOfficer> requirementOfficers) {
        this.requirementOfficers = requirementOfficers;
    }

    public ArrayList<Requirement> getFmcgRequirement() {
        return fmcgRequirement;
    }

    public void setFmcgRequirement(ArrayList<Requirement> fmcgRequirement) {
        this.fmcgRequirement = fmcgRequirement;
    }
    
    

    public Requirement createNewRequirement(Market market, Item item) {
        Requirement requirement = market.getMasterRequirment().addRequirement(fmcg, item, market);
        fmcgRequirement.add(requirement);
        return requirement; 
    }

}
