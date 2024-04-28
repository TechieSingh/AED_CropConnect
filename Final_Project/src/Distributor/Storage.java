/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Distributor;

import CropFolder.Crop;

/**
 *
 * @author prart
 */
public class Storage {
    Crop Crop;
    double totalCapacity;
    double filledCapacity;

    public Storage(Crop Crop, double totalCapacity) {
        this.Crop = Crop;
        this.totalCapacity = totalCapacity;
        this.filledCapacity = 0;
    }

    public double addTotalCapacity(double Quantity){
        totalCapacity+=Quantity;
        return totalCapacity;
    }
    
    public double addFilledCapacity(double Quantity){
        filledCapacity+=Quantity;
        return filledCapacity;
    }
    public double subFilledCapacity(double Quantity){
        filledCapacity-=Quantity;
        return filledCapacity;
    }
    
    public double getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public double getFilledCapacity() {
        return filledCapacity;
    }

    public void setFilledCapacity(double filledCapacity) {
        this.filledCapacity = filledCapacity;
    }

    public Crop getCrop() {
        return Crop;
    }

    public void setCrop(Crop Crop) {
        this.Crop = Crop;
    }
}
