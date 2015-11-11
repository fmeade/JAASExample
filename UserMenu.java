import java.util.*;
import java.security.*;

public class UserMenu {
	
	private SubMenu subMenu;
	private QueryMenu queryMenu;
	private Scanner scan;
	
	public UserMenu(Scanner _scan) {
		subMenu = new SubMenu(_scan);
		queryMenu = new QueryMenu(_scan);
		
		scan = _scan;
	}
	
	/**
	*
	*/
	public void user() {
		int choice = subMenu.menu();
		
		if(choice == 1) {
			choice = queryMenu.menu();
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
	public void changePassword() {
		
	}
}