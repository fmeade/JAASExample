import java.security.*;
import java.math.*;

public class Hashcreater{
	public static void main(String[]Args) throws NoSuchAlgorithmException{
		String plaintext = "Hello World";
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(plaintext.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		while(hashtext.length() < 32){
			hashtext = "0"+hashtext;
		}
		System.out.println(hashtext);
	}
}
