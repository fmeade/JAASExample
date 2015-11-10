import java.util.*;
import java.io.*;

/**
* 	
*/
public class EmpSystem {
	
	private Scanner scan;
	private List<Employee> employees;
	
	/**
	* 	
	*/
	public EmpSystem() {
		scan = new Scanner(System.in);
		employees = buildEmpList();
	}
	
	private List<Employee> buildEmpList() {
		FileReader database = new FileReader("./testinput1.txt");
		BufferedReader reader = new BufferedReader(database);
		
		String line;
		
		while() {
			
		}
	}
	
	/**
	* 	
	*/
	public void run() {
		int choice;
		
		choice = mainMenu();
		
		/*
		if 1, then create a user
		if 2, go to login
		if other, shut down	
		*/
		if(choice == 1) {
			createUser();
			login();
			user();
		}
		else if(choice == 2) {
			login();
			user();
		}
		else {
			System.out.println("ERROR: Please restart application.");
		}
		
	}
	
	/**
	* 	Prompts the user to select from the main menu
	*/
	public int mainMenu() {
		System.out.print("\n=============================\n" +
						 "Welcome to the Radsburg, Inc.\nEmployee Directory\n" +
					     "=============================\n\n" +
					     "1. Create a Login \n2. Login\n\n");
		
		return this.scan.nextInt();
	}
	
	/**
	* 	
	*/
	private void createUser() {
		System.out.print("\n\n--------------------------\n" + 
						 "Create a User\n" +
						 "--------------------------\n\n");
		
		String name;
		int id = -2;
		boolean id_accepted = false;
		String username;
		boolean username_accepted = false;
		String password;
		
		
		System.out.print("First Name: ");
		name = this.scan.next();
		
		// loop while id is not accepted or until id = -1
		while(!id_accepted || id != -1) {
			try {
				System.out.print("ID: ");
				id = scan.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("ERROR: " + e);
				this.scan.nextLine();
			}
			// check id, loop till works or -1 to go back to main menu
		}	
		
		if(id == -1) { 
			run(); 
		} 
		else { 
			while(!username_accepted) {
				System.out.print("Username: "); 
				// check username, loop until they give an accepted one
			}
			
			System.out.print("Password: ");
			//write to login file
				
		} 
	}

	
	/**
	*
	*/
	private void login() {
		System.out.print("\n\n--------------------------\n" + 
						 "Login\n" +
						 "--------------------------\n\n");
		
		String username;
		String password;
		boolean login_accepted = false;
		boolean username_exists = false;
		
		while (!login_accepted) {
			System.out.print("Username: "); 
			if(!username_exists) {
				System.out.println("User does not exist.");
				run();
			}
			else {
				System.out.print("Password: ");
				password = scan.next();
			
				if(password.equals("...")) {
					login_accepted = true;
					System.out.println("Login Successful!");
				}
				else {
					System.out.println("Login Unsuccessful.");
					login();
				}
			}
		}
	}
	
	/**
	*
	*/
	private void user() {
		int choice = subMenu();
		
		if(choice == 1) {
			choice = queryMenu();
		}
		else if(choice == 2) {
			changePassword();
		}
		else if(choice == 3) {
			System.out.println("Have a nice day!");
		}
		else {
			System.out.println("ERROR: Invalid Selection.");
			user();
		}
		
		
	}
	
	/**
	*
	*/
	private int subMenu() {
		System.out.print("\n\n--------------------------\n" + 
						 "User Menu\n" +
						 "--------------------------\n\n");
		
		System.out.print("1. Query Personal Information\n" +
						 "2. Change Password\n" +
						 "3. Logout\n\n");
		
		return this.scan.nextInt();
	}
	
	/**
	*
	*/
	private int queryMenu() {
		System.out.print("\n\n--------------------------\n" + 
						 "Query Menu\n" +
						 "--------------------------\n\n");
		
		System.out.print("1. Show Personal Information.\n" +
						 "2. See Your Employees.\n" +
						 "3. Change Salary of Employee.\n" +
						 "4. Change Position of Employee.\n\n");
		
		return this.scan.nextInt();
	}
	/**
	*
	*/
	private void changePassword() {
		
	}

}