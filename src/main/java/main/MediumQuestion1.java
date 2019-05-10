package main;

import java.util.Scanner;

abstract class Customer {

	private String name, address, mobileNumber;

	private Integer age;

Customer(String name, String address, Integer age, String mobile) {

	this.name = name;
	this.address = address;
	this.age = age;
	this.mobileNumber = mobile;

}
public void displayCustomer(Double amt,Double amtdis,String type) {
	System.out.println("Your bill amount is Rs. "+amt+".Congrats! As you are a "+type+", you are eligible for a discount!\r\n" + 
			"You have to pay Rs "+amtdis);
}

public String toString() {
	return "Name: " + this.name+"\n"+"Mobile: "+this.mobileNumber+"\n"+"Age: " + this.age+"\n"+"Address: "+ this.address;
}
abstract Double getBillAmount(Double amt);

}

class SeniorCitizenCustomer extends Customer {

	SeniorCitizenCustomer(String name, String address, Integer age, String mobile) {
		super(name, address, age, mobile);
	}
	
	Double getBillAmount(Double amount) {
		Double bill =(0.88*amount); 
		
		return bill;
	}

}

class PrivilegeCustomer extends Customer {
	PrivilegeCustomer(String name, String address, Integer age, String mobile) {
			super(name, address, age, mobile);
		}
		Double getBillAmount(Double amount) {
			Double bill = (0.7*amount);
			
			
			return bill;
		}
}

public class MediumQuestion1 {
	static Scanner in = new Scanner(System.in);
	static String name, address, phn;
	static Integer age;
	static Double purchasedAmt;
	public static void main(String[] args) {
		
		System.out.print("1)Privilege Customer" + "\n" + "2)Senior Citizen \n");
		System.out.println("Enter Customer Type: ");
		int select = in.nextInt();
		switch (select) {
			case 1:
			
				takeInput();
				
				Customer cust = new PrivilegeCustomer(name, address, age, phn);
				
				Double billAmt = cust.getBillAmount(purchasedAmt);
				System.out.println("Bill details");
				System.out.println(cust.toString());
				cust.displayCustomer(purchasedAmt, billAmt,"Privileged custome");
				break;
			case 2:
				takeInput();
				Customer cust1 = new SeniorCitizenCustomer(name, address, age, phn);
				Double billAmt1 = cust1.getBillAmount(purchasedAmt);

				System.out.println("Bill details");
				
				System.out.println(cust1.toString());
				cust1.displayCustomer(purchasedAmt, billAmt1,"citizen customer");

				break;
				
			default:
				System.out.println("Invalid Customer Type");
				break;
			}
}

public static void takeInput() {

		System.out.println("Enter the name: ");
		
		in.nextLine();
		
		name = in.nextLine();
		
		System.out.println("Enter the age: ");
		
		age = in.nextInt();
		
		System.out.println("Enter the address: ");
		
		in.nextLine();
		
		address = in.nextLine();
		
		System.out.println("Enter the mobile number: ");
		
		phn = in.nextLine();
		
		System.out.println("Enter the purchased amount: ");
		
		purchasedAmt = in.nextDouble();

	}

}