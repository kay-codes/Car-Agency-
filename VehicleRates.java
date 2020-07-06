/*
Michaela Bamfo 
Program 5- Vehicle rental Agnecy 
COSC 237 
FALL 2018 
*/
package corporatevehiclerentalagnecy;
/* 
Abstract class that will maintain the polymorphism between CarRates, SUVRates, and TruckRates
*/
public abstract class VehicleRates {
    
    double dailyRate;
    double weeklyRate;
    double monthlyRate;
    double mileageChrg;
    double dailyInsurRate;
    public VehicleRates( double d,double w,double m,double mc,double dr)
    {
        dailyRate= d;
        weeklyRate=w;
        monthlyRate=m;
        mileageChrg=mc;
        dailyInsurRate=dr;
    }
    public abstract double getDailyRate();
    public abstract double getWeeklyRate();
    public abstract double getMonthlyRate();
    public abstract double getMileageChrg();
    public abstract double getDailyIsurRate();
     public abstract void setDailyRate(double d);
    public abstract void setweeklyRate(double w);
    public abstract void setMonthlyRate(double m);
    public abstract void setMileageChrg(double mc);
    public abstract void setDailyIsurRate(double dr);
    public abstract Cost cloneAsCostType();
} 
