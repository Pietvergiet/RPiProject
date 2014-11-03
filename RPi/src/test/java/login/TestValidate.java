package login;

import org.junit.Assert;
import org.junit.Test;

import Login.Validate;

public class TestValidate {
	Validate validate = new Validate();
	
	@Test
	public void testToHex() {
		String langeString = "Hallo, dit is een test string. ^(!@;,</ Met rare karakters. En is deze string langer dan de andere?";
		Assert.assertEquals("Test", "54657374", validate.toHex("Test".getBytes()));
		Assert.assertEquals(langeString, "48616C6C6F2C206469742069732065656E207465737420737472696E672E205E2821403B2C3C2F204D65742072617265206B6172616B746572732E20456E2069732064657A6520737472696E67206C616E6765722064616E20646520616E646572653F"
				, validate.toHex(langeString.getBytes()));
		Assert.assertEquals("Leeg", "", validate.toHex("".getBytes()));
		Assert.assertEquals("Spatie", "20", validate.toHex(" ".getBytes()));
	}
}
