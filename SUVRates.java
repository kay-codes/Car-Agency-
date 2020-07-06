/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
/*
This class also extends to the Vehicle Rates abstract class 
This class will create get and set methods that store the rates for a SUV
It will also return a toString to the System inferface which will be seen either in the manager or employee interface 
*/
package corporatevehiclerentalagnecy;
public class SUVRates extends VehicleRates {
   public SUVRates (double dailyRate,double weeklyRate,double monthlyRate,double mileageChrg,double dailyInsurRate){
   super (dailyRate,weeklyRate,monthlyRate,mileageChrg,dailyInsurRate);
    }
    public double getDailyRate() {
      return dailyRate;
    }
    public double getWeeklyRate() {
   return weeklyRate;
    }

    public double getMonthlyRate() {
     return monthlyRate;
    }

    public double getMileageChrg() {
return mileageChrg;
    }

    public double getDailyIsurRate() {
        return dailyInsurRate;
    } 
     public String toString(){
        return "Daily Rate: $"+dailyRate+"\n Weekly Rate: $"+weeklyRate+"\n MonthlyRate: $"+monthlyRate+"\n Mile Charge: $"+mileageChrg+
                "\nDaily Insurance Rate: $"+dailyInsurRate;
    }
       public void setweeklyRate(double w){
           weeklyRate=w;
       }
       public void setDailyRate(double d){
           dailyRate=d;
       }
        public void setMonthlyRate(double m){
           monthlyRate=m;
       }
         public void setMileageChrg(double mc){
           mileageChrg=mc;
       }
          public void setDailyIsurRate(double dr){
           dailyInsurRate=dr;
       }
       public Cost cloneAsCostType(){
              Cost currentCost=new Cost(dailyRate,weeklyRate,monthlyRate,mileageChrg,dailyInsurRate);
              return currentCost;
           }
 
}
