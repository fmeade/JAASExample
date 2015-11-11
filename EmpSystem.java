import java.util.*;
import java.io.*;
import java.security.*;

/**
* 	
*/
public class EmpSystem  {
		
	private MainMenu mainMenu;
	
	/**
	* 	
	*/
	public EmpSystem() throws IOException, NoSuchAlgorithmException {

		mainMenu = new MainMenu();
	}
	
	
	/**
	* 	
	*/
	public void run() throws IOException, NoSuchAlgorithmException {
		int choice;
		
		choice = mainMenu.menu();
		
		/*
		if 1, then create a user
		if 2, go to login
		if other, shut down	
		*/
		if(choice == 1) {
			mainMenu.createUser();
			System.out.println("\nUser Account created.\n");
			run();
		}
		else if(choice == 2) {
			mainMenu.login();
		}
		else {
			System.out.println("ERROR: Please restart application.");
		}
		
	}

}