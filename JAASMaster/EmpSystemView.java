//package JAASMaster;
public class EmpSystemView {
	
	public EmpSystemView() {
		
	}
	
	public void run() {
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.print("\n=============================\n" +
						 "Welcome to the Radsburg, Inc.\nEmployee Directory\n" +
					     "=============================\n\n" +
					     "1. Create a Login \n2. Login\n\n");
	}
}
