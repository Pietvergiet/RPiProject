package Login;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Validate {
		
	
	public boolean checkUser(String pass) {
		MessageDigest messageDigest;
		String cit = "citroentaart";
		//String cit = GPIO.getPass();
		String encryptedString = null;
		String passw = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(pass.getBytes());
			encryptedString = new Validate().toHex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(cit.getBytes());
			passw = new Validate().toHex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		boolean ok = false;
		//System.out.println(pass + " -- " + encryptedString);
		//System.out.println(cit + " -- " + passw);
		if (encryptedString.equals(passw)) {
			ok = true;
		}
		
		return ok;
	}
	
	public String toHex(byte[] bytes) {
		if(bytes.length != 0) {
		BigInteger bi = new BigInteger(1, bytes);
		return String.format("%0" + (bytes.length << 1) + "X", bi);
		} else {
			return "";
		}
	}
}
