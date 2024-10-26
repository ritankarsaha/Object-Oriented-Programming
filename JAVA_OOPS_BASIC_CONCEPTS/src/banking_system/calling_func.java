package banking_system;
import java.util.*;

public class calling_func {
	static void show() {
		System.out.println("1. Create account");
		System.out.println("2. deposit");
		System.out.println("3. withdraw");
		System.out.println("4. view details");
		System.out.println("5. exit....");
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		banking obj = new banking();
		while(true) {
			show();
			System.out.println("enter your choice");
			int n = sc.nextInt();
			
			if(n==5) break;
			
			switch(n) {
			case 1: obj.create_acc();
			break;
			
			case 2: 
				System.out.println("enter account number");
				String num = sc.next();
				
				System.out.println("enter amount to deposit");
				int amount = sc.nextInt();
				
				
				obj.deposit(num,amount);
				break;
				
			case 3:
				System.out.println("enter account number");
				String num1 = sc.next();
				
				System.out.println("enter amount to withdraw");
				int amount1 = sc.nextInt();
				
				obj.withdraw(num1,amount1);
				break;
				
			case 4: 
				System.out.println("enter account number");
				String num2 = sc.next();
				obj.show_details(num2);
				break;
				
			default: System.out.println("choose right option");
			}

			
		}
	
			
			
			
		}

}