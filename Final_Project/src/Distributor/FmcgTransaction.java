/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import Common.Item;
import FMCG.FMCG;
import FMCG.ProcurementOffer;

/**
 *
 * @author prart
 */
public class FmcgTransaction {

    FMCG fmcg;
    Distributor distributor;
    Item item;
    ProcurementOffer procurementOffer;
    boolean transit;
    boolean inventoryApproved;

    public FmcgTransaction(FMCG fmcg, Distributor distributor, Item item, ProcurementOffer procurementOffer) {
        this.fmcg = fmcg;
        this.distributor = distributor;
        this.item = item;
        this.procurementOffer = procurementOffer;
        this.transit = false;
        this.inventoryApproved = false;
        
    }

    public FMCG getFmcg() {
        return fmcg;
    }

    public void setFmcg(FMCG fmcg) {
        this.fmcg = fmcg;
    }

    public ProcurementOffer getProcurementOffer() {
        return procurementOffer;
    }

    public void setProcurementOffer(ProcurementOffer procurementOffer) {
        this.procurementOffer = procurementOffer;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public boolean isTransit() {
        return transit;
    }

    public void setTransit() {
        this.transit = true;
    }

    public boolean isInventoryApproved() {
        return inventoryApproved;
    }

    public void setInventoryApproved() {
        this.inventoryApproved = true;
    }
    
    
}
