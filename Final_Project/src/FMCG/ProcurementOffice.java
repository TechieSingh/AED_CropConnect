/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import Market.MarketDirectory;
import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 * @author Prarthana
 */
public class ProcurementOffice {

    FMCG fmcg;
    ArrayList<ProcurementOfficer> procurementOfficers;
    ArrayList<ProcurementOffer> procurementOffers; //When distributor agrees to supply the material , remove that particular offer

    public ProcurementOffice(FMCG fmcg) {
        this.fmcg = fmcg;
        this.procurementOfficers = new ArrayList<>();
        this.procurementOffers = new ArrayList<>();
    }

    public ProcurementOfficer addProcurementOfficer(Person person) {
        ProcurementOfficer officer = new ProcurementOfficer(person, this);
        procurementOfficers.add(officer);
        return officer;
    }

    public void removeProcurementOfficer(ProcurementOfficer procurementOfficer) {
        procurementOfficers.remove(procurementOfficer);
    }

    public FMCG getFmcg() {
        return fmcg;
    }

    public void setFmcg(FMCG fmcg) {
        this.fmcg = fmcg;
    }

    public ArrayList<ProcurementOfficer> getProcurementOfficers() {
        return procurementOfficers;
    }

    public void setProcurementOfficers(ArrayList<ProcurementOfficer> procurementOfficers) {
        this.procurementOfficers = procurementOfficers;
    }

    public ArrayList<ProcurementOffer> getProcurementOffers() {
        return procurementOffers;
    }

    public void setProcurementOffers(ArrayList<ProcurementOffer> procurementOffers) {
        this.procurementOffers = procurementOffers;
    }

    public void addProcurementOffer(ProcurementOffer procurementOffer) {
        procurementOffers.add(procurementOffer);
    }

}
