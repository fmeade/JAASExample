package JAASMaster;
import java.util.*;

public class SubMenu {
	
	Scanner scan;
	
	public SubMenu(Scanner _scan) {
		scan = _scan;
	}
	
	/**
	*
	*/
	public int menu() {
		System.out.print("\n\n--------------------------\n" + 
						 "User Menu\n" +
						 "--------------------------\n\n");
		
		System.out.print("1. Query Personal Information\n" +
						 "2. Change Password\n" +
						 "3. Logout\n\n");
		
		return this.scan.nextInt();
	}
}