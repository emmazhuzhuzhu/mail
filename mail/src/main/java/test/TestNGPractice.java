package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test(enabled=false)
	public void testEmailGenerator(){
		RandomEmailGenerator emailGenerator = new RandomEmailGenerator();
		String email = emailGenerator.generate();
		
		Assert.assertNotNull(email);
		Assert.assertEquals(email, "feedback@163.com");
	}
}
