package JAASMaster;
import java.util.*;
import java.security.*;
import java.io.*;

public class UserMenu {
	
	private SubMenu subMenu;
	private QueryMenu queryMenu;
	private MD5Hash md5Hash;
	private Scanner scan;
	private Employee currentEmp;
	private List<String[]> loginList;
	
	public UserMenu(Scanner _scan) throws IOException, NoSuchAlgorithmException {
		subMenu = new SubMenu(_scan);
		queryMenu = new QueryMenu(_scan);
		md5Hash = new MD5Hash();
		
		scan = _scan;
	}

	public UserMenu(Scanner _scan, Employee _currentEmp, List<String[]> _loginList) throws IOException, NoSuchAlgorithmException {
		subMenu = new SubMenu(_scan);
		queryMenu = new QueryMenu(_scan);
		md5Hash = new MD5Hash();
		
		scan = _scan;
		currentEmp = _currentEmp;
		loginList = _loginList;
	}
	
	/**
	*
	*/
	public void menu() throws IOException, NoSuchAlgorithmException {
		int choice = subMenu.menu();
		
		if(choice == 1) {
			choice = queryMenu.menu();
		}
		else if(choice == 2) {
			loginList = changePassword();

			String newFile = "";

			for(int i=0; i < loginList.size(); i++){

				newFile = newFile + loginList.get(i)[0] + ", " + loginList.get(i)[1] + ", " + loginList.get(i)[2] + "\n";
			}

			FileWriter login = new FileWriter("../files/login1.txt",false);
			BufferedWriter bw = new BufferedWriter(login);
			
			
			bw.write(newFile);
			bw.flush();
			
			if(bw != null) {
				bw.close();
			}

			menu();
		}
		else if(choice == 3) {
			System.out.println("Have a nice day!\n");
		}
		else {
			System.err.println("ERROR: Invalid Selection.");
			menu();
		}
		
	}
	
	/**
	*
	*/
	public List<String[]> changePassword() throws NoSuchAlgorithmException {
		List<String[]> tempList = new ArrayList<String[]>();
		String newPassword, newPassword2 = "";
		
		for(int i=0; i < loginList.size(); i++) {

			if(loginList.get(i)[0].equals(currentEmp.getId() + "")) {
				
				newPassword = loginList.get(i)[2];
				Console console = System.console();
				System.out.print("Please enter current password: ");
					char[] currPass = console.readPassword();
					String currentPassword = new String(currPass);
				
				while(!md5Hash.hash(currentPassword).equals(newPassword)) {
					System.out.print("\nInvalid Password.\n\n");
					System.out.print("Please enter current password: ");
						currPass = console.readPassword();
						currentPassword = new String(currPass);
				}
				
				System.out.print("Please enter new password: ");
					char[] newPass = console.readPassword();
					newPassword = new String(newPass);
				
				if(newPassword.equals(currentPassword)) {
					System.out.print("\nCannot be same as old password.\n\n");
				}
				else {
					System.out.print("Please re-enter new password: ");
						char[] newPass2 = console.readPassword();
						newPassword2 = new String(newPass2);
				}
				
				while(!newPassword.equals(newPassword2)) {
					System.out.print("Please enter new password: ");
						newPass = console.readPassword();
						newPassword = new String(newPass);
					
					if(newPassword.equals(currentPassword)) {
						System.out.print("\nCannot be same as old password.\n\n");
					}
					else {
						System.out.print("Please re-enter new password: ");
						char[] newPass2 = console.readPassword();
						newPassword2 = new String(newPass2);
					}
					
				}

				String[] tempString = {loginList.get(i)[0], loginList.get(i)[1], md5Hash.hash(newPassword)};
				
				tempList.add(tempString);
			}
			else {
				tempList.add(loginList.get(i));
			}
		}
		
		return tempList;
	}
}