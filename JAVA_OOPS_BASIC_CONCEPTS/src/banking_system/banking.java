package banking_system;
import java.util.*;

public class banking {
	
 static Scanner sc = new Scanner(System.in);
 
 void create_acc() {
	 System.out.println("enter account holder name");
	 String holder_name = sc.next();
	 System.out.println("enter account number");
	 String acc_no = sc.next();
	 System.out.println("enter the balance");
	 int balance = sc.nextInt();
	 System.out.println("do you want saving or checking account");
	 String type = sc.next();
	 
	 if(type == "saving") {
		 account.name_saving.addElement(holder_name);
		 saving.acc_no.addElement(acc_no);
		 saving.balance.addElement(balance);
		 
	 }else {
		 account.name_saving.addElement(holder_name);
		 checking.acc_no.addElement(acc_no);
		 checking.balance.addElement(balance);
		 
	 }
	 
 }
 
 void deposit(String number,double amount) {
	
	 
	 if(saving.acc_no.contains(number)) {
		 int idx = saving.acc_no.indexOf(number);
		 int curr_balance = saving.balance.get(idx);
		 saving.balance.set(idx,(int) ((int)curr_balance + amount) );
		 System.out.println("amount deposited succesfully");
		 System.out.println("current amount: "+curr_balance + amount);
		 
	 }else if(checking.acc_no.contains(number)) {
		 int idx = checking.acc_no.indexOf(number);
		 int curr_balance = checking.balance.get(idx);
		 checking.balance.set(idx,(int) ((int)curr_balance + amount) );
		 System.out.println("amount deposited succesfully");
		 System.out.println("current amount: "+curr_balance + amount);
	 }else {
		 System.out.println("account not found");
	 }
 }
 
 
 void withdraw(String number,double amount) {
	 

	 
	 if(saving.acc_no.contains(number)) {
		 int idx = saving.acc_no.indexOf(number);
		 int curr_balance = saving.balance.get(idx);
		 if(curr_balance <amount) {
			 System.out.println("not enough balance" );
			 System.out.println("available balance is: " + curr_balance );
		 }else {
			 
		 saving.balance.set(idx,(int) ((int)curr_balance - amount) );
		 }
	 }else if(checking.acc_no.contains(number)) {
		 int idx = checking.acc_no.indexOf(number);
		 int curr_balance = checking.balance.get(idx);
		 if(curr_balance <amount) {
			 System.out.println("not enough balance" );
			 System.out.println("available balance is: " + curr_balance );
		 }else {
			 
		 checking.balance.set(idx,(int) ((int)curr_balance - amount) );
		 }
	 }else {
		 System.out.println("account not found");
	 }
 }
 
 
 
 void show_details(String account1) {
	 
	 if(saving.acc_no.contains(account1)) {
		 int idx = saving.acc_no.indexOf(account1);
		 
		 System.out.println("accoutn holder name " + account.name_saving.get(idx));
		 System.out.println("accoutn Number " + saving.acc_no.get(idx));
		 System.out.println("available balance " + saving.balance.get(idx));
		 
	 }else if(checking.acc_no.contains(account1)) {
 int idx = saving.acc_no.indexOf(account1);
		 
		 System.out.println("accoutn holder name " + account.name_saving.get(idx));
		 System.out.println("accoutn Number " + checking.acc_no.get(idx));
		 System.out.println("available balance " + checking.balance.get(idx));
	 }else {
		 System.out.println("account does't exist......");
	 }
 }
 
 
 
	 
 }