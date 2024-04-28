/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import CropFolder.Crop;

/**
 *
 * @author prart
 */
public class Item {

    Crop crop;
    double quantity;

    public Item(Crop crop, double quantity) {
        this.crop = crop;
        this.quantity = quantity;
    }

    
    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(double quantity) {
        this.quantity += quantity;
    }
    @Override
    public String toString() {
        return crop.getCropName();
    }

}
