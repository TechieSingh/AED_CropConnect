/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

/**
 *
 * @author amitanveri
 */
public class ProcurementOffer {

    ProcurementOfficer procurementOfficer;
    Requirement requirement;
    double unitPrice;
    double filledQuantity = 0;

    public ProcurementOffer(ProcurementOfficer procurementOfficer, Requirement requirement, double unitPrice) {
        this.procurementOfficer = procurementOfficer;
        this.requirement = requirement;
        this.unitPrice = unitPrice;
    }

    public ProcurementOfficer getProcurementOfficer() {
        return procurementOfficer;
    }

    public void setProcurementOfficer(ProcurementOfficer procurementOfficer) {
        this.procurementOfficer = procurementOfficer;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getFilledQuantity() {
        return filledQuantity;
    }

    public void setFilledQuantity(double filledQuantity) {
        this.filledQuantity = filledQuantity;
    }

    public double addFilledQuantity(double qty){
        filledQuantity += qty;
        return filledQuantity;
    }

    @Override
    public String toString() {
        return procurementOfficer.getProcurementOffice().getFmcg().getFmcgName();
    }
    
    
}
