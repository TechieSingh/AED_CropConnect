/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import CropFolder.Crop;
import FMCG.FMCG;
import Market.Market;
import Distributor.Distributor;
import PersonUserProfile.Profile;
import PersonUserProfile.Person;
import FMCG.SeasonNew;


/**
 * This class represents a System Administrator in the business domain. The
 * SystemAdmin class provides methods to create and manage FMCG entities,
 * distributors, crops, markets, and farmer profiles within the eco-system. It
 * extends the Profile class to inherit basic profile information.
 *
 * @author prart
 */
public class SystemAdmin extends Profile {

    private EcoSystem ecoSystem;

    /**
     * Constructor for creating a new System Administrator with associated
     * eco-system and profile information.
     *
     * @param ecoSystem The eco-system associated with the System Administrator.
     * @param p The profile information of the System Administrator.
     */
    public SystemAdmin(EcoSystem ecoSystem, Person p) {
        super(p);
        this.ecoSystem = ecoSystem;
    }

    /**
     * Retrieves the eco-system associated with the System Administrator.
     *
     * @return The eco-system associated with the System Administrator.
     */
    public EcoSystem getEcoSystem() {
        return ecoSystem;
    }

    /**
     * Sets the eco-system associated with the System Administrator.
     *
     * @param ecoSystem The eco-system to be associated with the System
     * Administrator.
     */
    public void setEcoSystem(EcoSystem ecoSystem) {
        this.ecoSystem = ecoSystem;
    }

    /**
     * Creates a new FMCG (Fast-Moving Consumer Goods) entity within the
     * eco-system. This method also assigns an FMCG administrator to manage the
     * newly created FMCG entity.
     *
     * @param fmcgName The name of the FMCG entity to be created.
     * @param p The profile information of the FMCG administrator.
     * @return The newly created FMCG entity.
     */
    public FMCG newFmcg(String fmcgName, Person p) {
        FMCG fmcg = ecoSystem.getfMCGDirectory().newFMCG(fmcgName, p);
        return fmcg;
    }

    /**
     * Creates a new distributor within the eco-system.
     *
     * @param distributorName The name of the distributor to be created.
     * @param person
     * @return The newly created distributor.
     */
    public Distributor newDistributor(String distributorName, Person person) {
        Distributor distributor = ecoSystem.getDistributorDirectory().newDistributor(distributorName, person);
        return distributor;
    }

    /**
     * Creates a new crop within the eco-system.
     *
     * @param cropName The name of the crop to be created.
     * @param cropGrade The grade of the crop.
     * @return The newly created crop.
     */
    public Crop newCrop(String cropName, String cropGrade) {
        Crop crop = ecoSystem.getCropDirectory().newCrop(cropName, cropGrade);
        return crop;
    }

    /**
     * Creates a new market within the eco-system. This method also defines the
     * season for the market based on specified start and end dates for
     * commitment and selling phases.
     *
     * @param marketName The name of the market to be created.
     * @param season
     * @return The newly created market.
     */
    public Market newMarket(String marketName, SeasonNew season) {
        Market market = ecoSystem.getMarketDirectory().addMarket(marketName);
        market.setSeason(season);
        return market;
    }

    /**
     * Creates a new farmer profile within the eco-system.
     *
     * @param p The profile information of the farmer.
     * @return The newly created farmer profile.
     */
//    public FarmerProfile newFarmerProfile(Person p) {
//        FarmerProfile farmerProfile = ecoSystem.getFarmerDirectory().addNewFarmer(p);
//        farmerProfile.setMarketDirectory(ecoSystem.getMarketDirectory());
//        return farmerProfile;
//    }
    /**
     * Retrieves the role of the System Administrator.
     *
     * @return The role of the System Administrator, which is "System Admin".
     */
    @Override
    public String getRole() {
        return "System Admin";
    }

}
