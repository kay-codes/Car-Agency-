/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
package corporatevehiclerentalagnecy;


public class VehicleNode {
    private Vehicle veh;
    private VehicleNode next;
    public VehicleNode (Vehicle veh, VehicleNode next)
    {
        this.veh=veh;
        this.next=next;    
    } 
    public void setNext(VehicleNode next){
        this.next=next; // sets to next node given 
    }
    public Vehicle getVehicle(){
        return veh; // gets vehicle info 
    }
    public VehicleNode getNext(){
        return next;//gets what node is pointing to 
    }
}
