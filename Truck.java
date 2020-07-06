/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
/*
This class also extends to the Vehicle Rates abstract class 
This class will create get and set methods that store the rates for a truck 
It will also return a toString to the System inferface which will be seen either in the manager or employee interface 
*/
package corporatevehiclerentalagnecy;

public class Truck extends Vehicle {
   private int loadingCapacity; 
public Truck(String description, int mpg,String vin,Reservation resv,int loadingCapacity) 
{
  super(description,mpg, vin,resv);
 this.loadingCapacity=loadingCapacity; 
}
public String toString()
{
    return "Type of Truck: "+getDescription()+" MPG: "+getMPG()+" Loading Capacity: "+loadingCapacity+" lbs."+" VIN: "+getVIN();
}
 
    
}
