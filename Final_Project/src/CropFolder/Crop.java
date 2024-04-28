/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CropFolder;

/**
 *
 * @author amitanveri
 */
public class Crop {

    String cropName;
    String grade;

    public Crop(String cropName, String grade) {
        this.cropName = cropName;
        this.grade = grade;
    }

    public String getCropName() {
        return cropName;
    }

    public String getGrade() {
        return grade;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    @Override
    public String toString(){
        return cropName;
    }    
}
