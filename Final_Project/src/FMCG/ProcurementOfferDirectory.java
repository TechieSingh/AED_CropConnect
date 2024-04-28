/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import Common.Item;
import FMCG.ProcurementOffer;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 */
public class ProcurementOfferDirectory {

    private ArrayList<ProcurementOffer> procurmentOffers = new ArrayList<>();

    public ArrayList<ProcurementOffer> getProcurmentOffers() {
        return procurmentOffers;
    }

    public void setProcurmentOffers(ArrayList<ProcurementOffer> procurmentOffers) {
        this.procurmentOffers = procurmentOffers;
    }

    public ProcurementOffer addProcurementOffer(ProcurementOfficer procurementOfficer, Requirement requirement, double unitPrice) {
        ProcurementOffer newprocurementOffer = new ProcurementOffer(procurementOfficer, requirement, unitPrice);
        procurmentOffers.add(newprocurementOffer);
        procurementOfficer.getProcurementOffice().addProcurementOffer(newprocurementOffer);
        return newprocurementOffer;
    }
}
