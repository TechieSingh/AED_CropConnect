/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import PersonUserProfile.Person;
import PersonUserProfile.Profile;
import PersonUserProfile.UserAccountDirectory;

/**
 *
 * @author amitanveri
 */
public class FmcgAdmin extends EmployeeProfile {

    private RequirementOffice requirementOffice;
    private ProcurementOffice procurementOffice;
    private FmcgUserAccountDirectory fmcgUserAccountDirectory;

    public FmcgAdmin(Person p, RequirementOffice requirementOffice, ProcurementOffice procurementOffice, FmcgUserAccountDirectory fmcgUserAccountDirectory) {
        super(p);
        this.requirementOffice = requirementOffice;
        this.procurementOffice = procurementOffice;
        this.fmcgUserAccountDirectory = fmcgUserAccountDirectory;
    }

    // Method to add a requirement officer and create a user account
    public RequirementOfficer addRequirementOfficer(Person person, String username, String password) {
        RequirementOfficer officer = requirementOffice.addRequirementOfficer(person);
        officer.setRequirementOffice(requirementOffice);
        fmcgUserAccountDirectory.newUserAccount(officer, username, password);
        return officer;
    }

    // Method to add a procurement officer and create a user account
    public ProcurementOfficer addProcurementOfficer(Person person, String username, String password) {
        ProcurementOfficer officer = procurementOffice.addProcurementOfficer(person);
        fmcgUserAccountDirectory.newUserAccount(officer, username, password);
        return officer;
    }

    public RequirementOffice getRequirementOffice() {
        return requirementOffice;
    }

    public void setRequirementOffice(RequirementOffice requirementOffice) {
        this.requirementOffice = requirementOffice;
    }

    public ProcurementOffice getProcurementOffice() {
        return procurementOffice;
    }

    public void setProcurementOffice(ProcurementOffice procurementOffice) {
        this.procurementOffice = procurementOffice;
    }

    public FmcgUserAccountDirectory getFmcgUserAccountDirectory() {
        return fmcgUserAccountDirectory;
    }

    public void setFmcgUserAccountDirectory(FmcgUserAccountDirectory fmcgUserAccountDirectory) {
        this.fmcgUserAccountDirectory = fmcgUserAccountDirectory;
    }

    public void removeRequirementOfficeEmployee(RequirementOfficer requirementOfficer) {
        this.requirementOffice.removeRequirementOfficer(requirementOfficer);
    }

    @Override
    public String getRole() {
        return "FMCG Admin";
    }

    public void removeProcurementOfficeEmployee(ProcurementOfficer procurementOfficer) {
        this.procurementOffice.removeProcurementOfficer(procurementOfficer);
    }

}
