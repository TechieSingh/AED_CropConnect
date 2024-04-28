/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import Farmer.*;
import Contract.Contract;
import Common.Item;
import Distributor.BuyOffer;
import Distributor.Distributor;
import java.util.ArrayList;
import FMCG.FMCG;
import FMCG.ProcurementOffer;

/**
 *
 * @author prart
 */
 public class FmcgTransactionDirectory {

    ArrayList<FmcgTransaction> Fmcgtransactions = new ArrayList<>();

    public ArrayList<FmcgTransaction> getTransactions() {
        return Fmcgtransactions;
    }

    public void setTransactions(ArrayList<FmcgTransaction> transactions) {
        this.Fmcgtransactions = transactions;
    }
    
    public FmcgTransaction newDistributorTransaction(FMCG fmcg, Distributor distributor, Item item, ProcurementOffer procurementOffer){
        FmcgTransaction transaction = new FmcgTransaction(fmcg, distributor,item, procurementOffer);
        Fmcgtransactions.add(transaction);
        fmcg.addDistTransaction(transaction);
        distributor.addFmcgTransaction(transaction);
        return transaction; 
    }
}
