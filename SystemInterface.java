/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
package corporatevehiclerentalagnecy;


public class SystemInterface {
    private static Rates agency_rates;
    private static Vehicles agency_vehicles;
    public static Accounts account;
    private static Transactions transactions_history;
    public static void initSystemInterface(Rates r, Vehicles v, Accounts a,Transactions t)
    {
       agency_rates=r;
        agency_vehicles=v;
       account=a;
       transactions_history=t; 
    }
    public static String [] getAllVehicles()// returns all vehicles within the vehicles class 
    {
        int size=0;
        Vehicle v;
        int i=0;
        agency_vehicles.reset();
        while (agency_vehicles.hasNext())
        { agency_vehicles.getNext();
        size++;
        }
        String [] vehicle_descriptions=new String[size];
         agency_vehicles.reset();
        while( agency_vehicles.hasNext())
        {
            v=agency_vehicles.getNext();
        vehicle_descriptions[i]=v.toString();
        i++;
        }
        return vehicle_descriptions;
    }
    public static String[] getAvailCars(){//// goes through vehicles class and returns all cars that are not resevred 
        int size=0;
        Vehicle v=null;
        agency_vehicles.reset();
        while (agency_vehicles.hasNext()){
            v=agency_vehicles.getNext();
            if(v instanceof Car && v.isReserved()==false){
                size++;
            }
        }
        String [] avail_cars=new String[size];// intializes size of array based on conditions in if statement 
        agency_vehicles.reset();// resets pointer of linked list 
        int i=0;
        while(agency_vehicles.hasNext() && i<=size)
        {
           v=agency_vehicles.getNext();
            if(v instanceof Car && v.isReserved()==false){
               avail_cars[i]=v.toString();
               i++;
            }
            
        }
        return avail_cars;// returns String array of avaiable cars
    }
     public static String[] getAvailSUV(){// goes through vehicles class and returns all SUVs that are not resevred 
        int size=0;
        Vehicle v;
        agency_vehicles.reset();
        while (agency_vehicles.hasNext()){
            v=agency_vehicles.getNext();
            if(v instanceof SUV&& v.isReserved()==false){
                size++;
            }
        }
        String [] avail_SUV=new String[size];// intializes size of array based on conditions in if statement 
        agency_vehicles.reset();// resets pointer of linked list 
        int i=0;
        while(agency_vehicles.hasNext() && i<=size)
        {
            v=agency_vehicles.getNext();
           if (v instanceof SUV && v.isReserved()==false)
           {
               avail_SUV[i]=v.toString();
               i++;
           }  
        }
        return avail_SUV;// returns String array of avaiable SUVs
    }
      public static String[] getAvailTruck(){// goes through vehicles class and returns all trucks that are not resevred 
        int size=0;
        Vehicle v;
        agency_vehicles.reset();
        while (agency_vehicles.hasNext()){
            v=agency_vehicles.getNext();
            if(v instanceof Truck&& v.isReserved()==false){
                size++;
            }
        }
        String [] avail_Truck=new String[size];// intializes size of array based on conditions in if statement 
        agency_vehicles.reset();// resets pointer of linked list 
        int i=0;
        while(agency_vehicles.hasNext() && i<=size)
        {
            v=agency_vehicles.getNext();
           if (v instanceof Truck&& v.isReserved()==false)
           {
               avail_Truck[i]=v.toString();
               i++;
           }  
        }
        return avail_Truck;// returns String array of avaiable Trucks
    }
   public static String[] getCarRates(){// goes through Rates class and return Car Rates toString
   String[] carRates=new String[1];
     String rate;
     rate=agency_rates.getCarRates().toString();
     carRates[0]=rate;
     return carRates;
   }
    public static String[] getSUVRates(){// goes through Rates class and return SUV Rates toString
   String[] carRates=new String[1];
     String rate;
     rate=agency_rates.getSUVRates().toString();
     carRates[0]=rate;
     return carRates;
   }
     public static String[] getTruckRates(){// goes through Rates class and return Truck Rates toString
   String[] carRates=new String[1];
     String rate;
     rate=agency_rates.getTruckRates().toString();
     carRates[0]=rate;
     return carRates;
   }
     public static String [] addAccount ( Account acct_info){ // adds account to aggregation class of Accounts. Return toString of Account object that is made 
       account.add(acct_info); 
       String[] acct=new String[1];
       acct[0]=acct_info.toString();
       return acct;
     }
     public static String[] getAccount(String acct_num){ // returns an account by their account num 
     Account acct=account.getAccount(acct_num);
     String [] reservations;
    reservations=acct.getVehiclesReserved();
   int size;
  size= reservations.length;
    String[] user=new String[size];
    for(int x=0;x<size;x++){
        user[x]=reservations[x];
    }
     return user;
     }
    public static String[] getAllAccounts(){ // retrieves all accounts from the aggregation class "Accounts"
        int size=0;
        String[] accounts;
        account.reset();
         while(account.hasNext()){
            account.getNext();
            size++;    
         }
         accounts=new String[size];
         account.reset();
         int i=0;
         Account a;
          while(account.hasNext()){
              a=account.getNext();
             accounts[i]=a.toString();
            i++; 
         }
          return accounts;
     } 
     public static String[] getReservation (String vin){ // returns toString of reservation on a vehicle 
        String reservation= agency_vehicles.getVehicle(vin).getReservation().toString();
        String[] reserve= new String[1];
        reserve[0]=reservation;
        return reserve;    
     }
     public static String[] cancelReservation (String vin){// when reservation is canceled it returns the toString of the reservation that was canceled seen in Employee UI
         String reserv=agency_vehicles.getVehicle(vin).getReservation().toString();
         String [] reser= new String[1];
         reser[0]=reserv;
         agency_vehicles.getVehicle(vin).cancelReservation();
        
         return reser;
     }
     public static String[] makeReservation(ReservationDetails details){// returns reservation thats is made to Employee UI
      Reservation reserved= new Reservation(details.getVIN(),details.getAccount(),details.getRentalPeriod(),details.getInsurance()) ;
      String[] res=new String[1];
      String vin=details.getVIN();
      agency_vehicles.getVehicle(vin).reserve(reserved);
       res[0]=reserved.toString();
      if(agency_vehicles.getVehicle(vin) instanceof Car){
          agency_vehicles.getVehicle(vin).setCost(agency_rates.getCarRates().cloneAsCostType());
      }
      if(agency_vehicles.getVehicle(vin) instanceof Truck){
          agency_vehicles.getVehicle(vin).setCost(agency_rates.getTruckRates().cloneAsCostType());
      }
      if(agency_vehicles.getVehicle(vin) instanceof SUV){
          agency_vehicles.getVehicle(vin).setCost(agency_rates.getSUVRates().cloneAsCostType());
      }
      account.getAccount(details.getAccount()).addReservedVehicle(reserved.toString());
      return res;
     }
     public static String[] setCarRates(VehicleRates car){ // changes rates within the CarRates class 
       agency_rates.getCarRates().setDailyIsurRate(car.getDailyIsurRate());
       agency_rates.getCarRates().setDailyRate(car.getDailyRate());
       agency_rates.getCarRates().setMileageChrg(car.getMileageChrg());
       agency_rates.getCarRates().setMonthlyRate(car.getMonthlyRate());
       agency_rates.getCarRates().setweeklyRate(car.getWeeklyRate());
       String [] carRates=new String[1];
       carRates[0]=agency_rates.getCarRates().toString(); // toString of new rates stored in Array 
       return carRates; 
     }
       public static String[] setSUVRates(VehicleRates suv){// changes rates within the SUVRates class 
       agency_rates.getSUVRates().setDailyIsurRate(suv.getDailyIsurRate());
       agency_rates.getSUVRates().setDailyRate(suv.getDailyRate());
       agency_rates.getSUVRates().setMileageChrg(suv.getMileageChrg());
       agency_rates.getSUVRates().setMonthlyRate(suv.getMonthlyRate());
       agency_rates.getSUVRates().setweeklyRate(suv.getWeeklyRate());
       String [] suvRates=new String[1];
       suvRates[0]=agency_rates.getSUVRates().toString();// toString of new rates stored in Array 
       return suvRates; 
     }
         public static String[] setTruckRates(VehicleRates truck){// changes rates within the TruckRates class 
       agency_rates.getTruckRates().setDailyIsurRate(truck.getDailyIsurRate());
       agency_rates.getTruckRates().setDailyRate(truck.getDailyRate());
       agency_rates.getTruckRates().setMileageChrg(truck.getMileageChrg());
       agency_rates.getTruckRates().setMonthlyRate(truck.getMonthlyRate());
       agency_rates.getTruckRates().setweeklyRate(truck.getWeeklyRate());
       String [] truckRates=new String[1];
       truckRates[0]=agency_rates.getTruckRates().toString();// toString of new rates stored in Array 
       return truckRates; 
     }
         public static String[] getAllReservations (){ // goes through vehicles lists and returns all reservation made on each and every single vehicle within the list
           int size=0;
        Vehicle v;
        int i=0;
        agency_vehicles.reset();
        while (agency_vehicles.hasNext())
        { 
            if(agency_vehicles.getNext().isReserved()==true){
                      size++;
            }
        }
        String [] vehicle_descriptions=new String[size];
         agency_vehicles.reset();
        while( agency_vehicles.hasNext())
        {
            v=agency_vehicles.getNext();
             if(v.isReserved()==true)
             {
        vehicle_descriptions[i]=v.getReservation().toString();
        i++;
             }
        }
        return vehicle_descriptions;   
         }
      public static String[] proccessReturnedVehicle(String vin,int days,int miles,String acct_num) {
          double [] result=agency_rates.calcActualCost(agency_vehicles.getVehicle(vin).getCost(),days,miles,agency_vehicles.getVehicle(vin).getReservation().getInsuranceSelected(),account.getAccount(acct_num).primeCustomer());
          Double rental= result[0];
          Double mileage= result[1];
          Double insur= result[2];
          Double total=result[3];
          String line1=Double.toString(rental);//parses double
          String line2=Double.toString(mileage);//parses double
          String line3=Double.toString(insur);//parses double
          String line4=Double.toString(total);//parses double
          String [] results=new String[1];
          String returnedQuote="Account #:"+account.getAccount(acct_num).getAcctNum()+"\nVIN: "+agency_vehicles.getVehicle(vin)+"\nRental period charge: $"+line1+"\nMileage Charge: $"+line2+"\nDaily Insurance:$"+line3+"\nTotal:$"+line4;
          results[0]=returnedQuote;
         Transaction trans= new Transaction(account.getAccount(acct_num).getAcctNum(),account.getAccount(acct_num).getCompanyName(),agency_vehicles.getVehicle(vin).getDescription(),agency_vehicles.getVehicle(vin).getReservation().getRentalPeriod(),line4);
         transactions_history.add(trans);// above is where reservation info is then transformed to a transaction object that is then added to its aggregation class
         agency_vehicles.getVehicle(vin).cancelReservation();// cancles reservation so vehicle is now available 
         account.getAccount(acct_num).removeReservation(vin);// remvoes reservation info from account linkedlist 
          return results;
      } 
      public static String[] displayAllTransaction (){ // just like the methods of the displaying all vehicles and reservations this does the same exact method but handling transactions 
          int size=0;
        Transaction v;
        int i=0;
       transactions_history.reset();
        while (transactions_history.hasNext())
        {
            transactions_history.getNext();
        size++;
        }
        String [] trans=new String[size];
        transactions_history.reset();
        while (transactions_history.hasNext())
        {
        v=transactions_history.getNext();
        trans[i]=v.toString();
        i++;
        }
        return trans;  
      }
      public static String[] estimateCost(RentalDetails estimate ){ // rental details is passed to this method in order to estimate possible cost of rental 
      double [] result=agency_rates.calcEstimatedCost(estimate.getVehType(),estimate.getDays(),estimate.getMiles(),estimate.getInsurance(),estimate.getIfPrimeCustomer());
      Double rental= result[0];
          Double mileage= result[1];
          Double insur= result[2];
          Double total=result[3];
          String line1=Double.toString(rental);//parses double
          String line2=Double.toString(mileage);//parses double
          String line3=Double.toString(insur);//parses double
          String line4=Double.toString(total);//parses double
          String [] results=new String[1];
          String estimatedQuote="Rental period charge: $"+line1+"\nMileage Charge: $"+line2+"\nDaily Insurance:$"+line3+"\nTotal:$"+line4;
          results[0]=estimatedQuote;
          return results;
      }
      private static String getVehType(String vin){ 
          String veh=null;
          if(agency_vehicles.getVehicle(vin) instanceof Car)
              veh="Car";
      if(agency_vehicles.getVehicle(vin) instanceof Truck)
          veh="Truck";
      if(agency_vehicles.getVehicle(vin) instanceof SUV)
          veh="SUV";
      return veh;
      }
         }
     

