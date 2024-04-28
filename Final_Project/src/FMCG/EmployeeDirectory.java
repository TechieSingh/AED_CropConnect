/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FMCG;

import PersonUserProfile.Person;
import java.util.ArrayList;

/**
 *
 * @author prart
 */
public class EmployeeDirectory {
    ArrayList<EmployeeProfile> employees;

    public EmployeeDirectory() {
        this.employees = new ArrayList<>();
    }
    
    
    public ArrayList<EmployeeProfile> getEmployees() {
        return employees;
    }
    
    public EmployeeProfile addEmployees(Person person){
        EmployeeProfile employeeProfile = new EmployeeProfile(person);
        employees.add(employeeProfile);
        return employeeProfile;
    }
}
