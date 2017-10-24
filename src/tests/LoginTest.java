package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import pages.BaseFile;
import pages.LoginPage;

public class LoginTest extends LoginPage
{	
	@Test(priority=1)
	public void testLogin()
	{	
		System.out.println("First login");
		BaseFile.loginMethod();
		Assert.assertTrue(LoginPage.getHomeMsg().contains("mngr100556"));
		BaseFile.logoutMethod();
		System.out.println("Login Test 1 Is SuccessFul");
	}
	
	@Test(priority=2,enabled=false)
	public void testLogin2()
	{	
		System.out.println("second login");
		BaseFile.loginMethod();
		System.out.println("Login Test 2 Is SuccessFul");
	}
}
