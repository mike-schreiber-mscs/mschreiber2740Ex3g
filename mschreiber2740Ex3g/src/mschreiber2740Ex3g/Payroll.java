package mschreiber2740Ex3g;
import java.text.DecimalFormat;


public class Payroll {

	private String name;
	private int idNumber;
	private double hourlyPay;
	private double hours = 0;
	
	public Payroll( int idNumber, String name, double hourlyPay) {
		//super();
		this.name = name;
		this.idNumber = idNumber;
		this.hourlyPay = hourlyPay;
		
	}	
	
	public Payroll(int id, String name, double payRate, double hours) {
		this.name = name;
		this.idNumber = id;
		this.hourlyPay = payRate;
		this.hours = hours;
	}

	public String toString() {
		DecimalFormat dollarFmt = new DecimalFormat("####.00");
		return Integer.toString(this.idNumber) +
				" " + this.name + ", Pay Rate = " + dollarFmt.format(this.hourlyPay);
	}



	public String getName() {
		return this.name;
	}

	public boolean setName(String name) {
		if (name.isEmpty()){
			return false;
		}
		else {
			this.name = name;
			return true;
		}
			
	}

	public int getIdNumber() {
		return this.idNumber;
	}

	//added this to 2740Ex2f for empID validation
	public boolean setIdNumber(int idNumber) {
		
			if (idNumber > 100) {
				this.idNumber = idNumber;
				return true;
			}
			else {
				return false;
			}

	}

	public double getHourlyPay() {
		return this.hourlyPay;
	}

	
	
	
	//calculates setHourlyPay 2740Ex2f
	public boolean setHourlyPay(double hourlyPay) {
		if (hourlyPay >= 7.25 && hourlyPay <= 100){
			
			this.hourlyPay = hourlyPay;
			return true;
			
			}
		
		else 
			
		{
			
			return false;
			
		}
		
		}
	
	
	public double gethours() {
		return this.hours;
	}

	//calculates setHours 2740Ex2f
	public boolean sethours(double hours) {
		
			if (hours >= .1 && hours <= 20){
				
				this.hours = hours;
				return true;
				
			}			
			else 				
			{				
				return false;				
			}			
	}
		/*this will calculate the gross pay and will 
	 add in overtime pay if necessary
	 */
	public double calcGrossPay()
	{
		double grossPay,
		       overtimePay;
		
		if (hours > 40)
		{
			grossPay = 40 * hourlyPay;
		
			overtimePay = (hours - 40) * (hourlyPay * 1.5);
		
			grossPay += overtimePay;
		
		}
		
		else
		{
			grossPay = hourlyPay * hours;
		}
		return grossPay;
	}

	
	public boolean addHours(double hours){
		if (hours >= 0.1 && hours <= 20.0) {		
			this.hours += hours;
			return true;
		}
			
			else {
				return false;
			}
		
	}

	



}
