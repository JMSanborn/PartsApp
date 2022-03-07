package com.partsapp.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Parts")
public class Part {

    @Override
    public String toString() {
        return "Part{" +
                "partID=" + partID +
                ", partName='" + partName + '\'' +
                ", price=" + price +
                ", productID=" + productID +
                '}';
    }

    public Part(int partID, String partName, double price, int productID){
            this.partID = partID;
            this.partName = partName;
            this.price = price;
            this.productID = productID;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductID() {
        return partID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @PrimaryKey(autoGenerate = true)
    private int partID;
    private String partName;
    private double price;
    private int productID;

}
