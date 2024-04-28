/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMCG;

import PersonUserProfile.Profile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FmcgUserAccountDirectory {

    private ArrayList<FmcgUserAccount> useraccountlist;

    public FmcgUserAccountDirectory() {

        useraccountlist = new ArrayList();

    }

    public FmcgUserAccount newUserAccount(Profile p, String un, String pw) {

        FmcgUserAccount ua = new FmcgUserAccount(p, un, pw);
        useraccountlist.add(ua);
        return ua;
    }

    public FmcgUserAccount findUserAccount(String id) {

        for (FmcgUserAccount ua : useraccountlist) {

            if (ua.isMatch(id)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    public FmcgUserAccount AuthenticateUser(String un, String pw) {

        for (FmcgUserAccount ua : useraccountlist) {

            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    // Added new method for listing the user accounts
    public ArrayList<FmcgUserAccount> getUserAccountList() {
        return useraccountlist;
    }

    public void deletePerson(FmcgUserAccount selectedperson) {

        useraccountlist.remove(selectedperson);

    }
}
