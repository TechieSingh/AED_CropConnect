/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import PersonUserProfile.Person;
import PersonUserProfile.Profile;

/**
 *
 * @author amitanveri
 */
public class RequirementOfficer extends EmployeeProfile {

    RequirementOffice requirementOffice;

    public RequirementOfficer(Person p) {
        super(p);
    }

    public RequirementOffice getRequirementOffice() {
        return requirementOffice;
    }

    public void setRequirementOffice(RequirementOffice requirementOffice) {
        this.requirementOffice = requirementOffice;
    }

    @Override
    public String getRole() {
        return "Requirement Officier";
    }

    @Override
    public String toString() {
        return "Requirement Office";
    }

}
