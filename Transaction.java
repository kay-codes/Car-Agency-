
package corporatevehiclerentalagnecy;

public class Transaction {
    /* 
    stores information of process vehicle. Will be used in Transactions class in order to 
    keep track of transactions made between vehicle agency and accounts. 
    */
private String acct_num;
private String company_name; 
private String vehicle_type;
private String rental_period;
private String rental_cost;
 
public Transaction(String acct_num,String company_name,String vehicle_type,String rental_period,String rental_cost){
this.acct_num=acct_num;
this.company_name=company_name;
this.rental_cost=rental_cost;
this.rental_period=rental_period;
this.vehicle_type=vehicle_type;          
}
public String toString(){
return "Account Number: "+acct_num+" Company Name: "+company_name+" Rental Cost: "+rental_cost+
        " Rental Period: "+rental_period+" days"+" Vehicle Type: "+vehicle_type;
}

}
