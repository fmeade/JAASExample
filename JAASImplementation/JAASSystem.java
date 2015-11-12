public class JAASSystem {

	private MainMenu mainMenu = new MainMenu();

	public JAASSystem() {

	}

	public void run() {
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
			//login()
		}
		else {
			System.out.println("ERROR: Please restart application.");
		}
	}
}