/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import Common.Item;
import java.util.ArrayList;
import Market.Market;
/**
 *
 * @author prarthana
 */
public class Requirement {
    Market market;
    FMCG fmcg;
    Item item;

    public Requirement(FMCG fmcg, Item item,Market market) {
        this.fmcg = fmcg;
        this.item = item;
        this.market = market;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public FMCG getFmcg() {
        return fmcg;
    }

    public void setFmcg(FMCG fmcg) {
        this.fmcg = fmcg;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return getItem().getCrop().getCropName();
    }
}
