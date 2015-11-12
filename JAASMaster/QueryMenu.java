package JAASMaster;
import java.util.*;

public class QueryMenu {
	
	Scanner scan;
	
	public QueryMenu(Scanner _scan) {
		scan = _scan;
	}
	
	/**
	*
	*/
	public int menu() {
		System.out.print("\n\n--------------------------\n" + 
						 "Query Menu\n" +
						 "--------------------------\n\n");
		
		System.out.print("1. Show Personal Information.\n" +
						 "2. See Your Employees.\n" +
						 "3. Change Salary of Employee.\n" +
						 "4. Change Position of Employee.\n" +
						 "5. Back\n\n");
		
		return this.scan.nextInt();
	}
}