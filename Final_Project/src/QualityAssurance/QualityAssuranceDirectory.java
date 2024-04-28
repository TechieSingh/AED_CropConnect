/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QualityAssurance;

import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author Sagar
 */
public class QualityAssuranceDirectory {
    
    ArrayList<QualityAssuranceProfile> qaProfiles = new ArrayList<>();

    public QualityAssuranceProfile addNewQAPerson(Person p) {
        QualityAssuranceProfile qaProfile = new QualityAssuranceProfile(p);
        qaProfiles.add(qaProfile);
        return qaProfile;
    }

    public ArrayList<QualityAssuranceProfile> getQualityAssuranceProfiles() {
        return qaProfiles;
    }
    
    public void deleteQAProfile(QualityAssuranceProfile qap){
        qaProfiles.remove(qap);
    }

}
