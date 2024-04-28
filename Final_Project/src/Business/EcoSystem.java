/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Contract.ContractDirectory;
import CropFolder.CropDirectory;
import PersonUserProfile.UserAccountDirectory;
import Distributor.DistributorDirectory;
import Distributor.FmcgTransactionDirectory;
import Farmer.FarmerDirectory;
import FMCG.MasterRequirment;
import FMCG.FMCGDirectory;
import Farmer.TransactionDirectory;
import Market.MarketDirectory;
import PersonUserProfile.Person;
import QualityAssurance.QualityAssuranceDirectory;

/**
 *
 * @author amitanveri
 */
public class EcoSystem {

    private DistributorDirectory distributorDirectory;
    private FarmerDirectory farmerDirectory;
    private FMCGDirectory fMCGDirectory;
    private QualityAssuranceDirectory qualityAssuranceDirectory;
    private SystemAdmin systemAdmin;
    private UserAccountDirectory userAccountDirectory;
    private MarketDirectory marketDirectory;
//    private ProcurementOfferDirectory procurementOfferDirectory;
    private CropDirectory cropDirectory;
    private ContractDirectory contractDirectory;
    private TransactionDirectory transactionDirectory;
    private FmcgTransactionDirectory fmcgTransactionDirectory;

    public EcoSystem(Person p) {
        this.distributorDirectory = new DistributorDirectory();
        this.farmerDirectory = new FarmerDirectory();
        this.fMCGDirectory = new FMCGDirectory();
        this.qualityAssuranceDirectory = new QualityAssuranceDirectory();
        this.systemAdmin = new SystemAdmin(this, p);
        this.userAccountDirectory = new UserAccountDirectory();
        this.marketDirectory = new MarketDirectory();
//        this.procurementOfferDirectory = new ProcurementOfferDirectory();
        this.cropDirectory = new CropDirectory();
        this.contractDirectory = new ContractDirectory();
        this.transactionDirectory = new TransactionDirectory();
        this.fmcgTransactionDirectory = new FmcgTransactionDirectory();
    }

    public DistributorDirectory getDistributorDirectory() {
        return distributorDirectory;
    }

    public void setDistributorDirectory(DistributorDirectory distributorDirectory) {
        this.distributorDirectory = distributorDirectory;
    }

    public FarmerDirectory getFarmerDirectory() {
        return farmerDirectory;
    }

    public void setFarmerDirectory(FarmerDirectory farmerDirectory) {
        this.farmerDirectory = farmerDirectory;
    }

    public FMCGDirectory getfMCGDirectory() {
        return fMCGDirectory;
    }

    public void setfMCGDirectory(FMCGDirectory fMCGDirectory) {
        this.fMCGDirectory = fMCGDirectory;
    }

    public QualityAssuranceDirectory getQualityAssuranceDirectory() {
            return qualityAssuranceDirectory;
        }

    public void setQualityAssuranceDirectory(QualityAssuranceDirectory qualityAssuranceDirectory) {
        this.qualityAssuranceDirectory = qualityAssuranceDirectory;
    }

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin systemAdmin) {
        this.systemAdmin = systemAdmin;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public MarketDirectory getMarketDirectory() {
        return marketDirectory;
    }

    public void setMarketDirectory(MarketDirectory marketDirectory) {
        this.marketDirectory = marketDirectory;
    }

    public CropDirectory getCropDirectory() {
        return cropDirectory;
    }

    public void setCropDirectory(CropDirectory cropDirectory) {
        this.cropDirectory = cropDirectory;
    }

    public ContractDirectory getContractDirectory() {
        return contractDirectory;
    }

    public void setContractDirectory(ContractDirectory contractDirectory) {
        this.contractDirectory = contractDirectory;
    }

    public TransactionDirectory getTransactionDirectory() {
        return transactionDirectory;
    }

    public void setTransactionDirectory(TransactionDirectory transactionDirectory) {
        this.transactionDirectory = transactionDirectory;
    }

    public FmcgTransactionDirectory getFmcgTransactionDirectory() {
        return fmcgTransactionDirectory;
    }

    public void setFmcgTransactionDirectory(FmcgTransactionDirectory fmcgTransactionDirectory) {
        this.fmcgTransactionDirectory = fmcgTransactionDirectory;
    }

    
    @Override
    public String toString() {
        return "EcoSystem{" + "distributorDirectory=" + distributorDirectory + ", farmerDirectory=" + farmerDirectory + ", fMCGDirectory=" + fMCGDirectory + ", qualityAssurence=" + qualityAssuranceDirectory + ", systemAdmin=" + systemAdmin + ", userAccountDirectory=" + userAccountDirectory + ", marketDirectory=" + marketDirectory + ", masterRequirment="  + ", procurementOfferDirectory=" + '}';
    }

}
