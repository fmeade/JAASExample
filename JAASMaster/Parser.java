import java.util.*;
import java.io.*;

public class Parser{
	public static void main(String[]Args)throws IOException{

		FileReader database = new FileReader("/Users/super_computer/Fall_2015/ITEC445/database.txt");
		BufferedReader reader = new BufferedReader(database);
        	String line;
		boolean employeeExists = false;
		while((line = reader.readLine()) != null){
			String[] employee = line.split(", ");
		 	if(employee[0].equals("20")){
				employeeExists = true;
				break;
			}
			else if(employee[1].equals("Bob")){
				employeeExists = true;
				break;
			}
			else{
				employeeExists = false; //Continue looping
			}
		}

		if(!employeeExists){
		//Create New User
		System.out.println("user created");	
		}
		else{
		System.out.println("this user already exists");
		}
	}

}


