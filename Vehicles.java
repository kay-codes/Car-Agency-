/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
package corporatevehiclerentalagnecy;

import corporatevehiclerentalagnecy.Car;
import corporatevehiclerentalagnecy.Reservation;
import corporatevehiclerentalagnecy.VINNotFoundException;
import corporatevehiclerentalagnecy.Vehicle;
import corporatevehiclerentalagnecy.VehicleNode;


public class Vehicles {
 private VehicleNode agency_vehicles=null;
 VehicleNode current=agency_vehicles;
  Vehicle veh;
 public Vehicles()
 {
   
  agency_vehicles=null;//populates first node in list
 }
 /*
 Add method adds vehicle where node is point to null or else throws exception do to array being full
 */
 public void add (Vehicle v) {
     
     VehicleNode temp=agency_vehicles;
     if(agency_vehicles==null)
         agency_vehicles=new VehicleNode(v,null);
     else
     {
         while(temp.getNext()!=null)
         {
             temp=temp.getNext();
         }
         temp.setNext(new VehicleNode(v,null));
     }

 }

 public void remove (String VIN)throws VINNotFoundException{
     if(agency_vehicles.getVehicle().getVIN().equals(VIN))
 {
     agency_vehicles=agency_vehicles.getNext(); // deletes first node
 }
else
{
     VehicleNode leadNode=agency_vehicles.getNext();
     VehicleNode trailingNode=agency_vehicles;
     while(leadNode.getVehicle().getVIN().equals(VIN))
     {
         trailingNode=leadNode;
         leadNode=leadNode.getNext();
 }
     trailingNode.setNext(leadNode.getNext()); // points to next node avaiable 
 }
 
 }
 /*
 This method checks through entire list to find the vehicle with exact VIN number that is passed by the client.
 If not found it throws a exception letting the user know the VIN is invalid and isn't within the collection 
 */
 public Vehicle getVehicle(String VIN) throws VINNotFoundException{
boolean found=false;
Vehicle v=null;
VehicleNode current=agency_vehicles;
while (current !=null)
{
    if(current.getVehicle().getVIN().equals(VIN))
    {
        found = true;
        v=current.getVehicle();
    }
    current=current.getNext();
}
if(found)
{
    return v;
}
else 
    throw new VINNotFoundException ();

}
    
 public void reset()
   {
       current=agency_vehicles; // resets to first node in agency_vehicle lise
     }
// This method checks if array's index is null or not.. returns True or false 
 public boolean hasNext()
 {
    return   current!=null;   
 }
 // if array hasNext this method will be executed until hasNext is false. This method returns a vehicle object 
 public Vehicle getNext()
 {   
  Vehicle v=current.getVehicle();
  current=current.getNext();
     return v;
 }

}

 


 
