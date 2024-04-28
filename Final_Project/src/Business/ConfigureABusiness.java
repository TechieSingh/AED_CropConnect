package Business;

import Common.Item;
import Contract.Contract;
import CropFolder.Crop;
import FMCG.FMCG;
import FMCG.FmcgAdmin;
import FMCG.RequirementOfficer;
import Market.Market;
import Distributor.BuyOffer;
import Distributor.Distributor;
import Distributor.DistributorAdmin;
import Distributor.DistributorDirectory;
import Distributor.InventoryOffice;
import Distributor.InventoryOfficer;
import Distributor.TransportOffice;
import Distributor.TransportOfficer;
import FMCG.ProcurementOffer;
import FMCG.ProcurementOfficer;
import FMCG.Requirement;
import FMCG.SeasonNew;
import Farmer.FarmerProfile;
import PersonUserProfile.Person;
import PersonUserProfile.UserAccountDirectory;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.HashSet;
import Distributor.FmcgTransaction;
import Distributor.FmcgTransactionDirectory;
import FMCG.MasterRequirment;
import Farmer.Transaction;
import Farmer.TransactionDirectory;
import Market.MarketDirectory;
import QualityAssurance.QualityAssuranceProfile;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is used to configure and initialize the components of the business
 * system.
 */
public class ConfigureABusiness {

    /**
     * Initializes the EcoSystem with predefined data including distributors
     * with their respective offices and user accounts.
     *
     * @return an initialized EcoSystem with random distributors.
     */
    public static EcoSystem initialize() {
        Faker faker = new Faker();
        Person systemPerson = new Person("Admin", "admin@example.com");
        EcoSystem ecoSystem = new EcoSystem(systemPerson);
        UserAccountDirectory userAccountDirectory = ecoSystem.getUserAccountDirectory();
        // Get the distributor directory and user account directory from the ecosystem
        DistributorDirectory distributorDirectory = ecoSystem.getDistributorDirectory();
        userAccountDirectory.newUserAccount(ecoSystem.getSystemAdmin(), systemPerson.getFullName(), "sadmin");

        // Create crops
        String[] cropNames = {"Wheat", "Corn", "Rice", "Soybeans", "Potatoes", "Barley", "Oats", "Rye", "Millet", "Sorghum"};
        String[] grades = {"A", "B", "C", "D", "A", "B", "C", "D", "A", "B"};
        ArrayList<Crop> crops = new ArrayList<>();
        for (int i = 0; i < cropNames.length; i++) {
            crops.add(ecoSystem.getSystemAdmin().newCrop(cropNames[i], grades[i]));
        }

        // Create markets with varying seasons
        SeasonNew[] seasons = {SeasonNew.COMMITMENT_PHASE, SeasonNew.SELLING_PHASE, SeasonNew.END};
        List<Market> markets = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String marketName = faker.company().name();
            SeasonNew season = seasons[i % seasons.length];
            markets.add(ecoSystem.getSystemAdmin().newMarket(marketName, season));
        }

        // Create 20 FMCG entities and post requirements
        for (int j = 0; j < 20; j++) {
            String fmcgName = faker.company().name();
            Person fmcgAdminPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
            FMCG fmcg = ecoSystem.getSystemAdmin().newFmcg(fmcgName, fmcgAdminPerson);
            FmcgAdmin fmcgAdmin = fmcg.getFmcgAdmin();
            userAccountDirectory.newUserAccount(fmcgAdmin, fmcgAdminPerson.getFullName(), "password123");

            // Post requirements for each market and for 5 random crops
            for (Market market : markets) {
                for (int k = 0; k < 5; k++) {
                    int quantity = faker.number().numberBetween(100, 1000);
                    Item item = new Item(crops.get(k), quantity);
                    fmcg.getRequirementOffice().createNewRequirement(market, item);
                }
            }

            // Create 5-10 Requirement Officers and Procurement Officers for each FMCG
            int numberOfOfficers = faker.number().numberBetween(5, 11);
            for (int k = 0; k < numberOfOfficers; k++) {
                // Requirement Officers
                Person reqOfficerPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
                String reqUsername = "req" + k + "_" + j + "_" + fmcgName;  // Create a unique username
                RequirementOfficer reqOfficer = fmcgAdmin.addRequirementOfficer(reqOfficerPerson, reqUsername, "password");
                userAccountDirectory.newUserAccount(reqOfficer, reqUsername, "password");

                // Procurement Officers
                Person procOfficerPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
                String procUsername = "proc" + k + "_" + j + "_" + fmcgName;  // Create a unique username
                ProcurementOfficer procOfficer = fmcgAdmin.addProcurementOfficer(procOfficerPerson, procUsername, "password");
                userAccountDirectory.newUserAccount(procOfficer, procUsername, "password");
            }
        }

        // Creating 20 farmers
        for (int i = 0; i < 20; i++) {
            Person farmerPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
            FarmerProfile farmProfile = ecoSystem.getFarmerDirectory().addNewFarmer(farmerPerson);
            userAccountDirectory.newUserAccount(farmProfile, farmerPerson.getFullName(), "password123"); // Updated password to align with earlier patterns
        }

        // Get all farmers and shuffle them to randomize access
        List<FarmerProfile> allFarmers = new ArrayList<>(ecoSystem.getFarmerDirectory().getFarmerProfiles());
        Collections.shuffle(allFarmers);

        // Select 3 random farmers
        List<FarmerProfile> selectedFarmers = allFarmers.stream().limit(3).collect(Collectors.toList());

        for (FarmerProfile farmer : selectedFarmers) {
            // Iterate through all markets
            for (Market market : markets) {
                MasterRequirment masterRequirment = market.getMasterRequirment();
                if (masterRequirment != null && masterRequirment.getRequirements() != null && !masterRequirment.getRequirements().isEmpty()) {
                    // Conduct multiple rounds of random requirement selections and contract creations
                    for (int round = 0; round < 3; round++) {  // Run the process 3 times
                        List<Requirement> requirements = new ArrayList<>(masterRequirment.getRequirements());
                        Collections.shuffle(requirements);
                        Requirement selectedRequirement = requirements.get(0);  // Pick one random requirement

                        Item requiredItem = selectedRequirement.getItem();
                        // Randomize the contracted quantity: can be less, equal, or more
                        int variation = faker.number().numberBetween(-50, 51);  // Variation can be negative or positive
                        double contractedQuantity = Math.max(1, requiredItem.getQuantity() + variation);  // Ensure at least 1 or more

                        // Create or update a contract for the farmer with this requirement
                        Contract newContract = ecoSystem.getContractDirectory().NewContract(market, farmer, new Item(requiredItem.getCrop(), contractedQuantity));
                    }
                }
            }
        }

        //Creating Distributor
        for (int i = 0; i < 10; i++) {
            String distributorName = faker.company().name();
            Person adminPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
            Distributor distributor = ecoSystem.getDistributorDirectory().newDistributor(distributorName, adminPerson);
            DistributorAdmin distributorAdmin = new DistributorAdmin(adminPerson, distributor);
            distributor.setDistributorAdmin(distributorAdmin);
            userAccountDirectory.newUserAccount(distributorAdmin, adminPerson.getFullName(), "password123");

            // Setup for Inventory Office
            InventoryOffice inventoryOffice = distributor.getInventoryOffice();
            int numInventoryOfficers = faker.number().numberBetween(4, 7); // Random number between 4 and 6
            for (int j = 0; j < numInventoryOfficers; j++) {
                Person inventoryPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
                InventoryOfficer inventoryOfficer = new InventoryOfficer(inventoryPerson, inventoryOffice);
                inventoryOffice.getInventoryOfficers().add(inventoryOfficer);
                distributor.getDistributorUserAccountDirectory().newUserAccount(inventoryOfficer, inventoryPerson.getFullName(), "password");
            }

            // Setup for Transport Office
            TransportOffice transportOffice = distributor.getTransportOffice();
            int numTransportOfficers = faker.number().numberBetween(4, 7); // Random number between 4 and 6
            for (int k = 0; k < numTransportOfficers; k++) {
                Person transportPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
                TransportOfficer transportOfficer = new TransportOfficer(transportPerson, transportOffice);
                transportOffice.getTransportOfficers().add(transportOfficer);
                distributor.getDistributorUserAccountDirectory().newUserAccount(transportOfficer, transportPerson.getFullName(), "password");
            }
        }

        // Loop through each distributor
        for (Distributor distributor : ecoSystem.getDistributorDirectory().getDistributors()) {
            DistributorAdmin distributorAdmin = distributor.getDistributorAdmin();

            // Randomly select a few markets from the available list
            Collections.shuffle(markets);
            List<Market> selectedMarkets = markets.subList(0, faker.number().numberBetween(1, Math.min(5, markets.size())));

            // Go through each selected market
            for (Market market : selectedMarkets) {
                MasterRequirment masterRequirment = market.getMasterRequirment();
                if (masterRequirment != null && masterRequirment.getRequirements() != null && !masterRequirment.getRequirements().isEmpty()) {
                    // Fetch the list of unique crops required in this market
                    Set<Crop> requiredCrops = masterRequirment.getRequirements().stream()
                            .map(req -> req.getItem().getCrop())
                            .collect(Collectors.toSet());

                    // Post Buy Offers for each unique crop
                    for (Crop crop : requiredCrops) {
                        // Define the quantity and price for the Buy Offer
                        int quantity = faker.number().numberBetween(100, 500); // Smaller quantity for buy offer
                        double unitPrice = faker.number().randomDouble(2, 1, 10); // Random price between 1 and 10

                        // Create an item with the crop and the defined quantity
                        Item item = new Item(crop, quantity);

                        // Create the Buy Offer in this market
                        market.getBuyOfferDirectory().newBuyOffer(market, distributorAdmin, item, unitPrice);
                    }
                }
            }
        }

        // Iterate through all farmers
        for (FarmerProfile farmer : ecoSystem.getFarmerDirectory().getFarmerProfiles()) {
            // Randomly select a few markets to simulate farmer activity in those markets
            Collections.shuffle(markets);
            List<Market> activeMarkets = markets.subList(0, faker.number().numberBetween(1, Math.min(3, markets.size())));

            // Process each market
            for (Market market : activeMarkets) {
                // Check for active Buy Offers in the market
                List<BuyOffer> availableOffers = market.getBuyOfferDirectory().getBuyOffers();
                if (!availableOffers.isEmpty()) {
                    // Shuffle and select random offers to simulate farmer's choice
                    Collections.shuffle(availableOffers);
                    BuyOffer selectedOffer = availableOffers.get(0);

                    // Check if farmer has any contracts that match the crop and quantity in the offer
                    for (Contract contract : farmer.getFarmerContracts()) {
                        if (contract.getMarket().equals(market)
                                && contract.getSelectedItem().getCrop().equals(selectedOffer.getItem().getCrop())
                                && contract.getSelectedItem().getQuantity() >= selectedOffer.getItem().getQuantity()) {

                            // Create a transaction if the contract matches the buy offer's crop and quantity requirements
                            Item transactionItem = new Item(selectedOffer.getItem().getCrop(), selectedOffer.getItem().getQuantity());
                            Transaction newTransaction = ecoSystem.getTransactionDirectory().addNewTransaction(
                                    farmer, selectedOffer.getDistributorAdmin().getDistributor(), transactionItem, selectedOffer, contract);

                            // Optionally, you can log or process the transaction further
                            System.out.println("Transaction created: " + newTransaction.toString());
                        }
                    }
                }
            }
        }

        // Assuming ecoSystem, markets, and FMCG entities are already initialized and populated as before
        for (FMCG fmcg : ecoSystem.getfMCGDirectory().getFmcgs()) {
            List<ProcurementOfficer> officers = fmcg.getProcurementOffice().getProcurementOfficers();

            // Iterate over each market
            for (Market market : markets) {
                MasterRequirment masterRequirment = market.getMasterRequirment();
                if (masterRequirment != null && !masterRequirment.getRequirements().isEmpty()) {
                    // Iterate over each requirement in the market
                    for (Requirement requirement : masterRequirment.getRequirements()) {
                        if (requirement.getFmcg().equals(fmcg)) {  // Check if the requirement belongs to this FMCG
                            // Randomly select a procurement officer from this FMCG to handle the offer
                            ProcurementOfficer selectedOfficer = officers.get(faker.number().numberBetween(0, officers.size()));

                            // Define a unit price, possibly based on the crop type, market demand, or other factors
                            double unitPrice = faker.number().randomDouble(2, 10, 100);  // Random price between 10 to 100
                            ProcurementOffer newProcurementOffer = market.getProcurementOfferDirectory().addProcurementOffer(selectedOfficer, requirement, unitPrice);

                            // Optionally, log the creation of the offer
                            System.out.println("Procurement Offer created by " + selectedOfficer.getPerson().getFullName()
                                    + " for " + requirement.getItem().getCrop().getCropName() + " in market "
                                    + market.getMarketName() + " at $" + unitPrice);
                        }
                    }
                }
            }
        }

        Random random = new Random();
        // Assuming that each market has procurement offers and distributors are willing to engage
        for (Market market : markets) {
            List<ProcurementOffer> offers = market.getProcurementOfferDirectory().getProcurmentOffers();
            if (offers.isEmpty()) {
                continue; // Skip if no offers
            }
            // Randomly pick procurement offers to create transactions
            for (ProcurementOffer offer : offers) {
                // Randomly select a distributor for each offer
                Distributor selectedDistributor = distributorDirectory.getDistributors().get(random.nextInt(distributorDirectory.getDistributors().size()));

                Item item = new Item(offer.getRequirement().getItem().getCrop(), offer.getFilledQuantity());
                FmcgTransaction transaction = ecoSystem.getFmcgTransactionDirectory().newDistributorTransaction(
                        offer.getRequirement().getFmcg(), selectedDistributor, item, offer
                );

                // Log transaction creation
                System.out.println("Created FMCG Transaction: " + transaction);
            }
        }

//        Market market1 = ecoSystem.getMarketDirectory().getMarkets().get(0);
//        Market market2 = ecoSystem.getMarketDirectory().getMarkets().get(1);
//        Market market3 = ecoSystem.getMarketDirectory().getMarkets().get(2);
//        Crop crop1 = ecoSystem.getCropDirectory().getCrops().get(0);
//        Crop crop2 = ecoSystem.getCropDirectory().getCrops().get(1);
//        Crop crop3 = ecoSystem.getCropDirectory().getCrops().get(2);
//        Item FMCGitem1 = new Item(crop1, 250);
//        Item Farmeritem1 = new Item(crop1, 50);
//        Item Distitem1 = new Item(crop1, 101);
//        Item FMCGitem2 = new Item(crop2, 100);
//        Item Farmeritem2 = new Item(crop2, 50);
//        Item Distitem2 = new Item(crop2, 100);
//
//        Item item3 = new Item(crop3, faker.number().numberBetween(100, 1000));
//
//        // Create 5 FMCG entities and add officers to their offices
//        for (int j = 0; j < 5; j++) {
//            String fmcgName = faker.company().name();
//            Person fmcgAdminPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
//            FMCG fmcg = ecoSystem.getSystemAdmin().newFmcg(fmcgName, fmcgAdminPerson);
//            FmcgAdmin fmcgAdmin = fmcg.getFmcgAdmin();
//            userAccountDirectory.newUserAccount(fmcgAdmin, fmcgAdminPerson.getFullName(), "123");
//
//            // Add officers to RequirementOffice and ProcurementOffice
//            for (int k = 0; k < 2; k++) {  // Assuming 2 officers per office
//                Person reqOfficerPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
//                String reqUsername = reqOfficerPerson.getFullName();
//                RequirementOfficer reqOfficer = fmcgAdmin.addRequirementOfficer(reqOfficerPerson, reqUsername, "123");
//                Requirement requirement1 = reqOfficer.getRequirementOffice().createNewRequirement(market1, FMCGitem1);
//                Requirement requirement2 = reqOfficer.getRequirementOffice().createNewRequirement(market1, FMCGitem2);
//
//                //}
//                // Creating Procurement officer
//                Person procOfficerPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
//                String procUsername = procOfficerPerson.getFullName();
//                ProcurementOfficer procofficer = fmcgAdmin.addProcurementOfficer(procOfficerPerson, procUsername, "123");
//
//                ProcurementOffer procurementOffer1 = market1.getProcurementOfferDirectory().addProcurementOffer(procofficer, requirement1, 1000);
//                ProcurementOffer procurementOffer2 = market1.getProcurementOfferDirectory().addProcurementOffer(procofficer, requirement2, 1250);
//            }
//        }
//        Crop crop = new Crop("Wheat", "A");
//        // Loop to create 5 distributors, each with its own unique admin and multiple officers in each office
//        for (int i = 0; i < 5; i++) {
//            String distributorName = faker.company().name();
//            Person adminPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
//            Distributor distributor = distributorDirectory.newDistributor(distributorName, adminPerson);
//            DistributorAdmin distributorAdmin = new DistributorAdmin(adminPerson, distributor);
//            distributor.setDistributorAdmin(distributorAdmin);
//            userAccountDirectory.newUserAccount(distributorAdmin, adminPerson.getFullName(), "password123");
//            //Buyoffer
//            BuyOffer buyoffer1 = market1.getBuyOfferDirectory().newBuyOffer(market1, distributorAdmin, Distitem1, 500);
//            BuyOffer buyoffer2 = market1.getBuyOfferDirectory().newBuyOffer(market1, distributorAdmin, Distitem2, 500);
//
//            ProcurementOffer procurementOffer1 = market1.getProcurementOfferDirectory().getProcurmentOffers().get(0);
//            ProcurementOffer procurementOffer2 = market1.getProcurementOfferDirectory().getProcurmentOffers().get(1);
//
//            FmcgTransaction fmcgTransaction1 = ecoSystem.getFmcgTransactionDirectory().newDistributorTransaction(procurementOffer1.getRequirement().getFmcg(), distributor, Distitem1, procurementOffer1);
//            FmcgTransaction fmcgTransaction2 = ecoSystem.getFmcgTransactionDirectory().newDistributorTransaction(procurementOffer2.getRequirement().getFmcg(), distributor, Distitem2, procurementOffer2);
//
//            userAccountDirectory.newUserAccount(distributorAdmin, adminPerson.getFullName(), "123");
//            // Inventory Office setup
//            InventoryOffice inventoryOffice = distributor.getInventoryOffice();
//            for (int j = 0; j < 3; j++) {
//                Person inventoryPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
//                InventoryOfficer inventoryOfficer = new InventoryOfficer(inventoryPerson, inventoryOffice);
//                inventoryOffice.getInventoryOfficers().add(inventoryOfficer);
//                distributor.getDistributorUserAccountDirectory().newUserAccount(inventoryOfficer, inventoryPerson.getFullName(), "123");
//            }
//
//            // Transport Office setup
//            TransportOffice transportOffice = distributor.getTransportOffice();
//            for (int k = 0; k < 3; k++) {
//                Person transportPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
//                TransportOfficer transportOfficer = new TransportOfficer(transportPerson, transportOffice);
//                transportOffice.getTransportOfficers().add(transportOfficer);
//                distributor.getDistributorUserAccountDirectory().newUserAccount(transportOfficer, transportPerson.getFullName(), "123");
//            }
//        }
//        //creating Buy offer
//
//        // Creating 5 farmers
//        for (int i = 0; i < 5; i++) {
//            //String farmerName = faker.company().name();
//            Person farmerPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
//            FarmerProfile farmProfile = ecoSystem.getFarmerDirectory().addNewFarmer(farmerPerson);
//            userAccountDirectory.newUserAccount(farmProfile, farmerPerson.getFullName(), "123");
//            // Creating a new Contract with each farmer
//
//            double quantity2 = 100.0;
//            Contract newcontract = ecoSystem.getContractDirectory().NewContract(market1, farmProfile, Farmeritem1);
//            Contract newcontract2 = ecoSystem.getContractDirectory().NewContract(market1, farmProfile, Farmeritem2);
//
//            //Market market = ecoSystem.getMarketDirectory().getMarkets().get(i);
//            BuyOffer buyOffer = market1.getBuyOfferDirectory().searchBuyOffer(Distitem1);
//            BuyOffer buyOffer2 = market1.getBuyOfferDirectory().searchBuyOffer(Distitem2);
//            if (newcontract.getSelectedItem().equals(buyOffer.getItem())) {
//                ecoSystem.getTransactionDirectory().addNewTransaction(farmProfile, buyOffer.getDistributorAdmin().getDistributor(), Farmeritem1, buyOffer, newcontract);
//            }
//            if (newcontract2.getSelectedItem().getCrop().equals(buyOffer2.getItem().getCrop())) {
//                Transaction transation = ecoSystem.getTransactionDirectory().addNewTransaction(farmProfile, buyOffer2.getDistributorAdmin().getDistributor(), Farmeritem2, buyOffer2, newcontract2);
//            }
//        }
        Person qaPerson = new Person(faker.name().fullName(), faker.internet().emailAddress());
        QualityAssuranceProfile qaProfile = ecoSystem.getQualityAssuranceDirectory().addNewQAPerson(qaPerson);
        userAccountDirectory.newUserAccount(qaProfile, qaPerson.getFullName(), "123");

        return ecoSystem;
    }

    //For Farmer
    /**
     * Prints the total earnings of the farmer by summing the transactions they
     * were involved in.
     *
     * @param farmerProfile the profile of the farmer whose earnings are to be
     * calculated.
     */
    public static void createStatsForFarmer(FarmerProfile farmerProfile) {
        double totalEarnings = calculateTotalEarnings(farmerProfile.getFarmerTransactions());
        System.out.println("Total Earnings for " + farmerProfile.getPerson().getFullName() + ": " + totalEarnings);
    }

    /**
     * Calculates the total earnings from a list of transactions by multiplying
     * the unit price by the quantity for each transaction.
     *
     * @param transactions the list of transactions to calculate earnings from.
     * @return the total earnings.
     */
    public static double calculateTotalEarnings(List<Transaction> transactions) {
        double totalEarnings = 0.0;
        for (Transaction transaction : transactions) {
            Item item = transaction.getItem();
            double unitPrice = transaction.getBuyOffer().getUnitPrice();
            double quantity = item.getQuantity();
            totalEarnings += unitPrice * quantity;
        }
        return totalEarnings;
    }

    /**
     * Calculates the average price per crop based on all transactions of a
     * specific crop that the farmer has made.
     *
     * @param cropName the name of the crop.
     * @param farmerProfile the profile of the farmer.
     * @return the average price per unit of the crop.
     */
    public double calculateAveragePricePerCrop(String cropName, FarmerProfile farmerProfile) {
        double totalRevenue = 0;
        double totalQuantity = 0;
        for (Transaction transaction : farmerProfile.getFarmerTransactions()) {
            if (transaction.getItem().getCrop().getCropName().equals(cropName)) {
                totalRevenue += transaction.getBuyOffer().getUnitPrice() * transaction.getItem().getQuantity();
                totalQuantity += transaction.getItem().getQuantity();
            }
        }
        return totalRevenue / totalQuantity;
    }

    /**
     * Prints the top three crops by the number of buy offers received in a
     * given market.
     *
     * @param market the market to analyze.
     */
    public void printTopThreeCropsByOffers(Market market) {
        HashMap<String, Integer> cropOfferCounts = new HashMap<>();
        for (BuyOffer offer : market.getBuyOfferDirectory().getBuyOffers()) {
            String cropName = offer.getItem().getCrop().getCropName();
            cropOfferCounts.put(cropName, cropOfferCounts.getOrDefault(cropName, 0) + 1);
        }
        List<Map.Entry<String, Integer>> topCrops = cropOfferCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 crops with the most buy offers:");
        for (Map.Entry<String, Integer> entry : topCrops) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " offers");
        }
    }

    /**
     * Aggregates the quantity of each crop from all markets that are in the END
     * phase and prints the results. This method helps in understanding the
     * total demand across markets for each crop.
     *
     * @param markets list of all markets to be analyzed.
     */
    public void aggregateCropsInEndPhase(List<Market> markets) {
        HashMap<Crop, Double> cropQuantities = new HashMap<>();
        for (Market market : markets) {
            if (market.getSeason() == SeasonNew.END) {
                MasterRequirment masterRequirment = market.getMasterRequirment();
                for (Requirement requirement : masterRequirment.getRequirements()) {
                    Item item = requirement.getItem();
                    Crop crop = item.getCrop();
                    double quantity = item.getQuantity();
                    cropQuantities.put(crop, cropQuantities.getOrDefault(crop, 0.0) + quantity);
                }
            }
        }
        printCropQuantities(cropQuantities);
    }

    /**
     * Prints the aggregated crop quantities from markets in the END phase.
     *
     * @param cropQuantities HashMap containing crops and their aggregated
     * quantities.
     */
    public void printCropQuantities(HashMap<Crop, Double> cropQuantities) {
        System.out.println("Aggregated Crop Quantities in END Phase Markets:");
        for (Map.Entry<Crop, Double> entry : cropQuantities.entrySet()) {
            System.out.println(entry.getKey().getCropName() + ": " + entry.getValue());
        }
    }

//For System Admin
    /**
     * Calculates the market participation rate for a farmer as a percentage of
     * all markets.
     *
     * @param farmerProfile the profile of the farmer.
     * @param marketDirectory directory of all markets.
     * @return the participation rate.
     */
    public double calculateMarketParticipationRate(FarmerProfile farmerProfile, MarketDirectory marketDirectory) {
        HashSet<String> marketsParticipated = new HashSet<>();
        for (Transaction transaction : farmerProfile.getFarmerTransactions()) {
            marketsParticipated.add(transaction.getBuyOffer().getMarket().getMarketName());
        }
        return (double) marketsParticipated.size() / marketDirectory.getMarkets().size() * 100;
    }

    /**
     * Retrieves and returns all FMCG transactions for a specified market from a
     * transaction directory. This is useful for tracking transactions within a
     * specific market environment.
     *
     * @param transactionsDirectory directory containing all FMCG transactions.
     * @param marketName the name of the market for which transactions are to be
     * retrieved.
     * @return a list of transactions that occurred in the specified market.
     */
    public List<FmcgTransaction> getTransactionsForMarket(FmcgTransactionDirectory transactionsDirectory, String marketName) {
        List<FmcgTransaction> filteredTransactions = new ArrayList<>();
        for (FmcgTransaction transaction : transactionsDirectory.getTransactions()) {
            Requirement requirement = transaction.getProcurementOffer().getRequirement();
            Market market = requirement.getMarket();
            if (market.getMarketName().equals(marketName)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    /**
     * Prints all FMCG transactions for a specified market.
     *
     * @param transactions list of FmcgTransaction to be printed.
     */
    public void printTransactions(List<FmcgTransaction> transactions) {
        for (FmcgTransaction transaction : transactions) {
            System.out.println("Transaction: FMCG - " + transaction.getFmcg().getFmcgName()
                    + ", Distributor - " + transaction.getDistributor().getDistributorName()
                    + ", Item - " + transaction.getItem().getCrop().getCropName()
                    + ", Quantity - " + transaction.getItem().getQuantity()
                    + ", Unit Price - " + transaction.getProcurementOffer().getUnitPrice());
        }
    }

    /**
     * Retrieves all transactions for a specific market from a given transaction
     * directory and returns them. Useful for tracking farmer-to-distributor
     * transactions within specific market settings.
     *
     * @param transactionDirectory directory containing all transactions.
     * @param marketName the name of the market for which transactions are to be
     * retrieved.
     * @return a list of transactions that occurred in the specified market.
     */
    public List<Transaction> getTransactionsForMarket(TransactionDirectory transactionDirectory, String marketName) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactionDirectory.getTransactions()) {
            Market market = transaction.getBuyOffer().getMarket();
            if (market.getMarketName().equals(marketName)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    /**
     * Prints all transactions between farmers and distributors for a specific
     * market.
     *
     * @param transactions list of Transaction to be printed.
     */
    public void printTransactionsFarmer(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println("Transaction: Farmer - " + transaction.getFarmerProfile().getPerson().getFullName()
                    + ", Distributor - " + transaction.getDistributor().getDistributorName()
                    + ", Item - " + transaction.getItem().getCrop().getCropName()
                    + ", Quantity - " + transaction.getItem().getQuantity()
                    + ", Unit Price - " + transaction.getBuyOffer().getUnitPrice());
        }
    }

    /**
     * Calculates the total required quantities for each crop across all
     * markets. This helps in understanding the overall demand for crops across
     * different markets and planning accordingly.
     *
     * @param marketDirectory directory containing all markets.
     */
    public void displayCropRequirements(MarketDirectory marketDirectory) {
        HashMap<Crop, Double> cropQuantities = new HashMap<>();
        for (Market market : marketDirectory.getMarkets()) {
            MasterRequirment masterRequirement = market.getMasterRequirment();
            for (Requirement requirement : masterRequirement.getRequirements()) {
                Item item = requirement.getItem();
                Crop crop = item.getCrop();
                double quantity = item.getQuantity();
                cropQuantities.merge(crop, quantity, Double::sum);
            }
        }
        System.out.println("Total Requirement Quantities for Each Crop Across All Markets:");
        for (Map.Entry<Crop, Double> entry : cropQuantities.entrySet()) {
            System.out.println("Crop: " + entry.getKey().getCropName() + ", Quantity: " + entry.getValue());
        }
    }

    //FMCG
    /**
     * Calculates and prints the total money spent by an FMCG on each crop for a
     * specific market.
     *
     * @param fmcg The FMCG whose transactions are to be analyzed.
     * @param marketName The name of the market for which spending data is
     * required.
     */
    public void printSpendingByCropForMarket(FMCG fmcg, String marketName) {
        // A map to hold the total spending for each crop
        HashMap<String, Double> spendingByCrop = new HashMap<>();

        // Iterate over all transactions of the FMCG
        List<FmcgTransaction> transactions = fmcg.getFmcgTransactions();
        for (FmcgTransaction transaction : transactions) {
            Market market = transaction.getProcurementOffer().getRequirement().getMarket();
            if (market.getMarketName().equals(marketName)) {
                String cropName = transaction.getItem().getCrop().getCropName();
                double amountSpent = transaction.getItem().getQuantity() * transaction.getProcurementOffer().getUnitPrice();
                spendingByCrop.merge(cropName, amountSpent, Double::sum);
            }
        }

        // Print the spending for each crop in the specified market
        System.out.println("Total spending by " + fmcg.getFmcgName() + " for each crop in " + marketName + ":");
        for (Map.Entry<String, Double> entry : spendingByCrop.entrySet()) {
            System.out.println("Crop: " + entry.getKey() + ", Spent: $" + entry.getValue());
        }
    }

}
