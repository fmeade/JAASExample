import java.util.*;
import java.security.*;
import java.io.*;

public class MainMenu {
	
	private ProcessList processList;
	private UserMenu userMenu;
	private MD5Hash md5Hash;
	Scanner scan;
	
	private List<Employee> employees;
	private List<String[]> loginList;
	
	
	public MainMenu(Scanner _scan) throws IOException, NoSuchAlgorithmException {
		processList = new ProcessList();
		userMenu = new UserMenu(_scan);
		md5Hash = new MD5Hash();
		this.scan = _scan;
		
		employees = processList.buildEmpList();
		loginList = processList.buildLoginList();
		
	}
	
	/**
	* 	Prompts the user to select from the main menu
	*/
	public int menu() {
		System.out.print("\n=============================\n" +
						 "Welcome to the Radsburg, Inc.\nEmployee Directory\n" +
					     "=============================\n\n" +
					     "1. Create a Login \n2. Login\n\n");
		
		return this.scan.nextInt();
	}
	
	/**
	* 	
	*/
	public void createUser() throws IOException, NoSuchAlgorithmException {
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
				id_accepted = processList.checkEmpList(employees, id);
				
				if(!id_accepted) {
					System.out.println("\nEmployee does not exist.\n");
				}
				
				if(id_accepted) {
					id_accepted = !processList.checkLoginList(loginList, "" + id, 0);
					
					if(!id_accepted) {
						System.out.println("\nid already associated with an account. Please see manager.\n");
					}
				}
				
			} catch (InputMismatchException e) {
				System.err.println("ERROR: " + e);
				this.scan.nextLine();
			}
			
		}	
		
		if(!id_accepted) { 
			System.out.println("Please restart system."); 
		} 
		else { 
			while(username_exists) {
				System.out.print("Username: ");
				username = this.scan.next();
				this.scan.nextLine();
				username_exists = processList.checkLoginList(loginList, username, 1);
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
			
			String newLogin = id + ", " + username + ", " + md5Hash.hash(password);
				
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
	public void login() {
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
			username_exists = processList.checkLoginList(this.loginList, username, 1);
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
}