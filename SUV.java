/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
package corporatevehiclerentalagnecy;

public class SUV extends Vehicle  {
    private int seatingCapacity;
    private int cargoCapacity;
public SUV(String description, int mpg,String vin, Reservation resv, int seatingCapacity,int cargoCapacity) 
{
  super(description,mpg, vin,resv);
 this.seatingCapacity=seatingCapacity;
this.cargoCapacity=cargoCapacity;
}
public String toString()
{
    return "Type of SUV: "+getDescription()+" MPG: "+getMPG()+" Seating Capacity: "+seatingCapacity+" Cargo Capacity: "+cargoCapacity+" cubic ft."+" VIN: "+getVIN();
}
 
}
