/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
package corporatevehiclerentalagnecy;
public class TruckRates extends VehicleRates {
  public TruckRates (double dailyRate,double weeklyRate,double monthlyRate,double mileageChrg,double dailyInsurRate){
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
