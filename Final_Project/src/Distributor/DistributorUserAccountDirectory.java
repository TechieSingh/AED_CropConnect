/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distributor;

import PersonUserProfile.Profile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class DistributorUserAccountDirectory {

    private ArrayList<DistributorUserAccount> useraccountlist;

    public DistributorUserAccountDirectory() {

        useraccountlist = new ArrayList();

    }

    public DistributorUserAccount newUserAccount(Profile p, String un, String pw) {

        DistributorUserAccount ua = new DistributorUserAccount(p, un, pw);
        useraccountlist.add(ua);
        return ua;
    }

    public DistributorUserAccount findUserAccount(String id) {

        for (DistributorUserAccount ua : useraccountlist) {

            if (ua.isMatch(id)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    public DistributorUserAccount AuthenticateUser(String un, String pw) {

        for (DistributorUserAccount ua : useraccountlist) {

            if (ua.IsValidUser(un, pw)) {
                return ua;
            }
        }
        return null; //not found after going through the whole list
    }

    // Added new method for listing the user accounts
    public ArrayList<DistributorUserAccount> getUserAccountList() {
        return useraccountlist;
    }

    public void deletePerson(DistributorUserAccount selectedperson) {

        useraccountlist.remove(selectedperson);

    }
}
