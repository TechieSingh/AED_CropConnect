/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CropFolder;

import java.util.ArrayList;

/**
 *
 * @author amitanveri
 */
public class CropDirectory {

    ArrayList<Crop> crops;

    public CropDirectory() {
        this.crops = new ArrayList<>();
    }

    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public void setCrops(ArrayList<Crop> crops) {
        this.crops = crops;
    }

    public Crop newCrop(String cropName, String cropGrade) {
        Crop crop = new Crop(cropName, cropGrade);
        crops.add(crop);
        return crop;
    }

    public void deleteCrop(Crop c){
        crops.remove(c);
    }
    
    public Crop searchCrop(String str , String grade){
        for(Crop crop: crops){
            if(crop.cropName.equals(str)&&crop.grade.equals(grade)){
                return crop;
            }
        }
        return null;
    }

}
