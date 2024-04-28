/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Distributor;

import PersonUserProfile.Person;
import PersonUserProfile.Profile;

/**
 *
 * @author kal bugrara
 */
public class DistributorUserAccount {

    private Profile profile;
    private String username;
    private String password;

    public DistributorUserAccount(Profile profile, String un, String pw) {
        username = un;
        password = pw;
        this.profile = profile;

    }
    
    public Person getPerson() {
        return profile.getPerson();
    }
    
    public int getPersonId() {
        return profile.getPerson().getId();
    }

    public String getPersonName() {
        return profile.getPerson().getFullName();
    }

    public boolean isMatch(String fullName) {
        if (getPersonName().equals(fullName)) {
            return true;
        }
        return false;
    }

    public boolean IsValidUser(String un, String pw) {

        return username.equalsIgnoreCase(un) && password.equals(pw);

    }

    public String getRole() {
        return profile.getRole();
    }

    public Profile getAssociatedPersonProfile() {
        return profile;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return getPersonName();
    }
}
