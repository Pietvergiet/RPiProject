package Gpio;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestGpio {
	
	@Test
	public void testMake16Chars() {
		StringBuilder test = new StringBuilder("Geen16Chars");
		test.append((char) 0);
		test.append((char) 0);
		test.append((char) 0);
		test.append((char) 0);
		test.append((char) 0);
		Assert.assertEquals("16 characters", true, "abcdefghijklmnop".equals(make16Chars("abcdefghijklmnop")));
		Assert.assertEquals("Ongelijk", false, "Geen16Chars".equals(make16Chars("Geen16Chars")));
		Assert.assertEquals("Geen 16 characters", true, test.toString().equals(make16Chars("Geen16Chars")));
	}
	
	@Test 
	public void testTurnStringtoInt() {
		int gelijk[] = {65};
		int leeg[] = {};
		int spatie[] = {32};
		int meerdere[] = {65,66,67,68};
		Assert.assertArrayEquals("Gelijk", gelijk, turnStringtoInt("A"));
		Assert.assertArrayEquals("Leeg", leeg, turnStringtoInt(""));
		Assert.assertArrayEquals("Spatie", spatie, turnStringtoInt(" "));
		Assert.assertArrayEquals("Meedere", meerdere, turnStringtoInt("ABCD"));
		
		
	}
	
	@Test
	public void testIntToBool() {
		boolean nul[] = {false, false, false, false, false, false, false, false};
		boolean vol[] = {true, true, true, true, true, true, true , true};
		boolean vijftien[] = {false, false, false, false, true, true, true, true};
		Assert.assertEquals("null", true, Arrays.equals(nul, intToBool(0)));
		Assert.assertEquals("null", true, Arrays.equals(vol, intToBool(255)));
		Assert.assertEquals("null", true, Arrays.equals(vijftien, intToBool(15)));
	}
	
	public static String make16Chars(String string) {
		StringBuilder vol = new StringBuilder(string);
		while (vol.length() < 16 ) {
			vol.append((char) 0);
		}
		return vol.toString();
	}
	
	public static int[] turnStringtoInt(String string) {
		StringBuilder chars = new StringBuilder(string);
		int[] ints = new int[chars.length()];
		for (int i = 0; i < chars.length(); i++) {
			ints[i] = (int) chars.charAt(i);
		}
		
		return ints;
	}
	
	public static boolean[] intToBool(int cijfer) {
		if (cijfer > 255 && cijfer >= 0){
			return null;
		} else {
			int input = cijfer;

		    boolean[] bits = new boolean[8];
		    for (int i = 7; i >= 0; i--) {
		        bits[7-i] = (input & (1 << i)) != 0;
		    }
		    
		    return bits;
		}
	}
}
