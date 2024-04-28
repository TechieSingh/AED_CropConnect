/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import Distributor.FmcgTransaction;
import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author amitanveri
 */
public class FMCG {

    private String fmcgName;
    private RequirementOffice requirementOffice;
    private ProcurementOffice procurementOffice;
    private FmcgAdmin fmcgAdmin;
//    private MarketDirectory marketDirectory;
//    private CropDirectory cropDirectory;
    private FmcgUserAccountDirectory fmcgUserAccountDirectory;
    private ArrayList<FmcgTransaction> fmcgTransactions;

    public FMCG(String fmcgName, Person fmcgAdmin) {
        fmcgUserAccountDirectory = new FmcgUserAccountDirectory();
        this.fmcgName = fmcgName;
        this.requirementOffice = new RequirementOffice(this);
        this.procurementOffice = new ProcurementOffice(this);
        this.fmcgAdmin = new FmcgAdmin(fmcgAdmin, requirementOffice, procurementOffice, fmcgUserAccountDirectory);
        this.fmcgTransactions = new ArrayList<>();
    }

    public String getFmcgName() {
        return fmcgName;
    }

    public void setFmcgName(String fmcgName) {
        this.fmcgName = fmcgName;
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

    public FmcgAdmin getFmcgAdmin() {
        return fmcgAdmin;
    }

    public void setFmcgAdmin(FmcgAdmin fmcgAdmin) {
        this.fmcgAdmin = fmcgAdmin;
    }

//    public MarketDirectory getMarketDirectory() {
//        return marketDirectory;
//    }
//
//    public void setMarketDirectory(MarketDirectory marketDirectory) {
//        this.marketDirectory = marketDirectory;
//    }
//    public CropDirectory getCropDirectory() {
//        return cropDirectory;
//    }
//
//    public void setCropDirectory(CropDirectory cropDirectory) {
//        this.cropDirectory = cropDirectory;
//    }
    public FmcgUserAccountDirectory getFmcgUserAccountDirectory() {
        return fmcgUserAccountDirectory;
    }

    public void setFmcgUserAccountDirectory(FmcgUserAccountDirectory fmcgUserAccountDirectory) {
        this.fmcgUserAccountDirectory = fmcgUserAccountDirectory;
    }

    public void addDistTransaction(FmcgTransaction transaction) {
        fmcgTransactions.add(transaction);
    }

    public ArrayList<FmcgTransaction> getFmcgTransactions() {
        return fmcgTransactions;
    }

    public void setFmcgTransactions(ArrayList<FmcgTransaction> fmcgTransactions) {
        this.fmcgTransactions = fmcgTransactions;
    }

}
