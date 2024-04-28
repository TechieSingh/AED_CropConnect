/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import PersonUserProfile.Person;

/**
 *
 * @author amitanveri
 */
public class ProcurementOfficer extends EmployeeProfile {

    ProcurementOffice procurementOffice;

    public ProcurementOfficer(Person p,ProcurementOffice procurementOffice ) {
        super(p);
        this.procurementOffice = procurementOffice;
    }

    @Override
    public String getRole() {
        return "Procurement Officer";
    }

    @Override
    public String toString() {
        return "Procurement Office";
    }

    public ProcurementOffice getProcurementOffice() {
        return procurementOffice;
    }

    public void setProcurementOffice(ProcurementOffice procurementOffice) {
        this.procurementOffice = procurementOffice;
    }
}
