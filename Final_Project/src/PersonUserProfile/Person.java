/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersonUserProfile;

/**
 *
 * @author amitanveri
 */
public class Person {

    static int counter;
    private int id;
    String fullName;
    String emailId;

    static {
        counter = 0;
    }

    public Person(String fullName, String emailId) {
        counter++;
        this.fullName = fullName;
        this.emailId = emailId;
        id = counter;
    }

    public boolean isMatch(String fullName) {
        return getFullName().equals(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
