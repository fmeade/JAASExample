import java.io.*;

public class Append{
	public static void main(String[]Args) throws IOException{
		String append = "hello World";
		FileWriter login = new FileWriter("./login2.txt",true);
		BufferedWriter bw = new BufferedWriter(login);
		bw.write(append);
		bw.newLine();
		bw.flush();
		if(bw != null){
			bw.close();
		}
	}
}