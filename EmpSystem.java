import java.util.*;
import java.io.*;
import java.security.*;

/**
* 	
*/
public class EmpSystem  {
	
	private ProcessList processList;
	private MainMenu mainMenu;
	private UserMenu userMenu;
	
	private Scanner scan;	
	
	/**
	* 	
	*/
	public EmpSystem() throws IOException,NoSuchAlgorithmException {
		scan = new Scanner(System.in);
		processList = new ProcessList();
		
		mainMenu = new MainMenu(scan);
		userMenu = new UserMenu(scan);
	}
	
	
	/**
	* 	
	*/
	public void run() throws IOException,NoSuchAlgorithmException {
		int choice;
		
		choice = mainMenu.menu();
		
		/*
		if 1, then create a user
		if 2, go to login
		if other, shut down	
		*/
		if(choice == 1) {
			mainMenu.createUser();
			mainMenu.login();
			userMenu.user();
		}
		else if(choice == 2) {
			mainMenu.login();
			userMenu.user();
		}
		else {
			System.out.println("ERROR: Please restart application.");
		}
		
	}

}