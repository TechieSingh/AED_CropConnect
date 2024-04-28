/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QualityAssurance;

import PersonUserProfile.Person;
import PersonUserProfile.Profile;

/**
 *
 * @author prart
 */
public class QualityAssuranceProfile extends Profile {
    
    QualityAssuranceProfile (Person p) {
        super(p);
    }

    @Override
    public String getRole() {
        return "Crop Quality Tester";
    }
}