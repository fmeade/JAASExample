import java.util.*;
import java.io.*;
import java.security.*;

/**
* 	
*/
public class EmpSystem  {
	
	private ProcessList processList;
	private MainMenu mainMenu;
	
	private Scanner scan;
	private List<Employee> employees;
	private List<String[]> loginList;
	
	
	/**
	* 	
	*/
	public EmpSystem() throws IOException,NoSuchAlgorithmException {
		scan = new Scanner(System.in);
		processList = new ProcessList();
		employees = processList.buildEmpList(employees);
		loginList = processList.buildLoginList(loginList);
		
		mainMenu = new MainMenu(scan);
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
			mainMenu.user();
		}
		else if(choice == 2) {
			mainMenu.login();
			mainMenu.user();
		}
		else {
			System.out.println("ERROR: Please restart application.");
		}
		
	}

}