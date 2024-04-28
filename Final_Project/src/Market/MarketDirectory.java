/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Market;

import FMCG.SeasonNew;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
public class MarketDirectory {

    private ArrayList<Market> markets = new ArrayList<>();

    public MarketDirectory() {
        this.markets = new ArrayList<>();
    }
    
    
    public Market addMarket(String marketName){
        Market market = new Market(marketName);
        markets.add(market);
        return market;
    }

    public ArrayList<Market> getMarkets() {
        return markets;
    }
    
    public Market searchMarkets(String marketName) {
        for(Market market:markets){
            if(marketName.equals(market.getMarketName())){
                return market;
            }
        }
        return null;
    }
    
    public Market searchMarketBySeason(SeasonNew season) {
        for(Market market:markets){
            if(season.equals(market.getSeason())){
                return market;
            }
        }
        return null;
    }
}
