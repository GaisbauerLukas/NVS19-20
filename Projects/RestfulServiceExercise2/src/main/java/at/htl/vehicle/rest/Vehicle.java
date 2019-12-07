
package at.htl;

public class Vehicle {
    private  String brand;
    private String type;

    public Vehicle(){}
    public Vehicle(String brand, String type){
        this.brand = brand;
        this.type = type;
    }

    //region Getter and Setter
    public String getBrand(){
        return brand;
    }
    public String getType(){
        return type;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setType(String type){
        this.type =type;
    }
    //endregion
}
