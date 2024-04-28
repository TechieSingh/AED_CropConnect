/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import CropFolder.CropDirectory;
import Market.MarketDirectory;
import PersonUserProfile.Person;
import PersonUserProfile.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
public class FMCGDirectory {

    private ArrayList<FMCG> fmcgs = new ArrayList<>();

    public ArrayList<FMCG> getFmcgs() {
        return fmcgs;
    }

    public void setFmcgs(ArrayList<FMCG> fmcgs) {
        this.fmcgs = fmcgs;
    }

    public FMCG newFMCG(String fmcgName, Person fmcgAdmin) {
        // Create New FMCG
        FMCG fmcg = new FMCG(fmcgName, fmcgAdmin);
        fmcgs.add(fmcg);
        return fmcg;
    }

    public void deleteFMCG(FMCG fmcg) {
        fmcgs.remove(fmcg);
    }
}
