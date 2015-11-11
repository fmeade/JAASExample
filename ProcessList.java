import java.util.*;
import java.io.*;
import java.security.*;

public class ProcessList {
	
	
	public ProcessList() {
		
	}
	
	public List<Employee> buildEmpList() throws IOException,NoSuchAlgorithmException {
		FileReader database = new FileReader("./testinput1.txt");
		BufferedReader reader = new BufferedReader(database);
		
		List<Employee> tempList = new ArrayList<Employee>();
		String line;
		
		while((line = reader.readLine()) != null) {
			String[] employee = line.split(", ");
			
			tempList.add(new Employee(employee[0], 
									  Integer.parseInt(employee[1]), 
									  employee[2], 
									  employee[3], 
									  Long.parseLong(employee[4].substring(1,employee[4].length()))));
		}
		return tempList;
	}
	
	public List<String[]> buildLoginList() throws IOException,NoSuchAlgorithmException {
		FileReader database = new FileReader("./login1.txt");
		BufferedReader reader = new BufferedReader(database);
		
		List<String[]> tempList = new ArrayList<String[]>();
		String line;
		
		while((line = reader.readLine()) != null) {
			String[] employee = line.split(", ");
			
			tempList.add(employee);
		}
		System.out.println(tempList.get(0));
		return tempList;
	}
	
	/**
	*
	*/
	public boolean checkEmpList(List<Employee> employees, int id) {
		
		boolean exist = false;
		
		for(int i=0; i < employees.size(); i++) {
			if((employees.get(i)).getId() == id) {
				exist = true;
				i = employees.size();
			}
			else {
				exist = false;
			}
		}
		return exist;
	}
	
	/**
	*
	*/
	public boolean checkLoginList(List<String[]> loginList, String username, int idOrUsername) {
		
		boolean exist = true;
		
		for(int i=0; i < loginList.size(); i++) {
			if((loginList.get(i)[idOrUsername]).equals(username)) {
				exist = true;
				i = loginList.size();
			}
			else {
				exist = false;
			}
		}
		return exist;
	}
}