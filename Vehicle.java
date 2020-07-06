/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
package corporatevehiclerentalagnecy;

public abstract class Vehicle {
    private String description;
    private int mpg;
    private String vin;
    private Reservation resv;
    private Cost rates;
     public Vehicle (String description, int mpg, String vin,Reservation resv)
     {
         this.description= description; 
         this.mpg=mpg;
         this.vin=vin;
        this.resv=resv;
        this.rates=null;
     }
    public String getDescription() // return make name
    {
        return description;
    }
    public Cost getCost(){
        return rates;
    }
    public void setCost(Cost cost){
      rates=cost;  
    }
     public int getMPG()// returns mpg
     {
         return mpg;
     }
     public String getVIN() // returns vin
     {
         return vin;
     }
     public Reservation getReservation ()// returns reservation 
     {
         return resv;
     }
     public abstract String toString();// abstract due to different types of vehicles having different instances 
 /* 
     This method recieves a reservation object and checks if vehicle is reserved or not. 
     If reserved throughs exception if not it creates a reservation object for vehicle object.
     */
     public void reserve(Reservation res) throws ReservedVehicleException 
     {
         if (isReserved())
             throw new ReservedVehicleException();        
     else
     resv=res;
     }
     public boolean isReserved()// Returns boolean true ot false. True if object is not pointing to null. False if it is.
     {
         return resv!=null;
     }
     /* 
     This method cancels a exisiting reservation. If reservation object is nuull it will through and exception
     letting user know the bvehicle was never reserved to begin with.
     */
     public void cancelReservation() throws UnreservedVehicleException 
     {
         if(resv!=null)
           resv=null;
         else if(resv==null)
            throw new UnreservedVehicleException();
     }
    
}
