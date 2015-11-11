import java.util.*;
import java.io.*;

/**
* 	
*/
public class EmpSystem {
	
	private Scanner scan;
	private List<Employee> employees;
	private List<String[]> loginList;
	
	/**
	* 	
	*/
	public EmpSystem() throws IOException {
		scan = new Scanner(System.in);
		employees = buildEmpList();
		loginList = buildLoginList();
	}
	
	private List<Employee> buildEmpList() throws IOException {
		FileReader database = new FileReader("./testinput1.txt");
		BufferedReader reader = new BufferedReader(database);
		
		List<Employee> tempList = new ArrayList<Employee>();
		String line;
		
		while((line = reader.readLine()) != null) {
			String[] employee = line.split(", ");
			
			tempList.add(new Employee(employee[0], 
									  Integer.parseInt(employee[1]), 
									  employee[2], 
									  employee[3], 
									  Long.parseLong(employee[4].substring(1,employee[4].length()))));
		}
		return tempList;
	}
	
	private List<String[]> buildLoginList() throws IOException {
		FileReader database = new FileReader("./login1.txt");
		BufferedReader reader = new BufferedReader(database);
		
		List<String[]> tempList = new ArrayList<String[]>();
		String line;
		
		while((line = reader.readLine()) != null) {
			String[] employee = line.split(", ");
			
			tempList.add(employee);
		}
		System.out.println(tempList.get(0));
		return tempList;
	}
	
	
	/**
	* 	
	*/
	public void run() throws IOException {
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
	private void createUser() throws IOException {
		System.out.print("\n\n--------------------------\n" + 
						 "Create a User\n" +
						 "--------------------------\n\n");
		
		String name = "";
		int id = -1;
		boolean id_accepted = false;
		String username = "";
		boolean username_exists = true;
		String password = "1", password2 = "2";
		
		
		System.out.print("First Name: ");
		name = this.scan.next();
		this.scan.nextLine();
		
		while(!id_accepted) {
			try {
				System.out.print("ID: ");
				id = scan.nextInt();
				id_accepted = checkEmpList(id);
				
				if(id_accepted) {
					id_accepted = checkLoginList(id, 0);
				}
				
			} catch (InputMismatchException e) {
				System.err.println("ERROR: " + e);
				this.scan.nextLine();
			}
			
		}	
		
		if(!id_accepted) { 
			run(); 
		} 
		else { 
			while(username_exists) {
				System.out.print("Username: ");
				username = this.scan.next();
				this.scan.nextLine();
				username_exists = checkLoginList(username, 1);
			}
			
			while(!password.equals(password2)) {
				System.out.print("Password: ");
				Console console = System.console();
				char[] pass = console.readPassword();
				password = new String(pass);
				
				System.out.print("Re-enter Password: ");
				pass = console.readPassword();
				password2 = new String(pass);
				
				if(!password.equals(password2)) {
					System.out.println("\n Passwords did not match.\n");
				}
			}
			
			String newLogin = id + ", " + username + ", " + password;
				
			FileWriter login = new FileWriter("./login1.txt",true);
			BufferedWriter bw = new BufferedWriter(login);
			
			
			bw.write("\n" + newLogin);
			bw.flush();
			
			if(bw != null){
				bw.close();
			}
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
			username = this.scan.next();
			this.scan.nextLine();
			username_exists = checkLoginList(username);
			if(!username_exists) {
				System.out.println("User does not exist.");
				login();
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
	private boolean checkEmpList(int id) {
		
		boolean exist = false;
		
		for(int i=0; i < this.employees.size(); i++) {
			if((this.employees.get(i)).getId() == id) {
				exist = true;
				i = this.employees.size();
			}
			else {
				exist = false;
			}
		}
		return exist;
	}
	
	/**
	*
	*/
	private boolean checkLoginList(String username, int idOrUsername) {
		
		boolean exist = true;
		
		for(int i=0; i < this.loginList.size(); i++) {
			if((this.loginList.get(i)[idOrUsername]).equals(username)) {
				exist = true;
				i = this.loginList.size();
			}
			else {
				exist = false;
			}
		}
		return exist;
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