package tests;

import java.io.IOException;
import java.util.ArrayList;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.BaseFile;
import pages.NewCustomerPage;

public class NewCustomerTest extends NewCustomerPage
{	
	
	
	@Test(priority=1,enabled=true,description="Verification Of Launching Add New Customer page")
	public static void verifyNewCustomerPageLaunch()
	{
		System.out.println("Add New Customer Page Test");
		BaseFile.loginMethod();
		NewCustomerPage.launchCreateNewCustomer();
		Assert.assertTrue(getNewCustDashBoardMsg().contains("Add New Customer"));
		System.out.println("Add New Customer Page is Launched Successfully");
		Reporter.log("Add New Customer Page is Launched Successfully");
	}
	
	@Test(priority=2,enabled = true,invocationCount=1,description="Verification of Add New Customer Submit Button")
	public static void verifyNewCustomerSubmitButton() throws InterruptedException
	{
		NewCustomerPage.launchCreateNewCustomer();
		submitNewCustInfo();
		Assert.assertTrue(acceptAlert().equals("please fill all fields"));
		Reporter.log("As expected,Pop up with error message is dispayed When Submitting Blank Info for New Customer");
		fillNewCustInfo(randomStringGenerator(), "female", "01/08/1990", "address", "cityList",
				"stateList", "123465", "456789123", randomStringGenerator()+"@test.com" ,"Changedpwst");
		Thread.sleep(2000);
		submitNewCustInfo();
		Thread.sleep(2000);
		Assert.assertTrue(getNewCustDashBoardMsg().equals("Customer Registered Successfully!!!"));
		Reporter.log("As Expected,New Customer information is Added Successfully");
		
		
	}
		
	@Test(priority=3,description="Validate Error Messages Displayed For Each Field Of Adding New Customer",enabled=true)
	public static void verificationOfErrorMessages() throws InterruptedException
	{
		NewCustomerPage.launchCreateNewCustomer();
		verifyErrMsgsNewCustPage();
		Reporter.log("The Error Messages for blank customer info in 'Add New Customer' page are Displayed As Expected");
	}
	
	
	@Test(priority=4,description="Verification Of Submitting Multiple Valid Data",enabled=false,dependsOnMethods = {"verifyNewCustomerPageLaunch"} )
	public static void addMultiValidCustomers() throws IOException, InterruptedException
	{
		NewCustomerPage.launchCreateNewCustomer();
		ArrayList<String> nameList = BaseFile.getExcelData("AddNewCustomer", 0);
		ArrayList<String> genderList = BaseFile.getExcelData("AddNewCustomer", 1);
		ArrayList<String> dobList = BaseFile.getExcelData("AddNewCustomer", 2);
		ArrayList<String> addrList = BaseFile.getExcelData("AddNewCustomer", 3);
		ArrayList<String> cityList = BaseFile.getExcelData("AddNewCustomer", 4);
		ArrayList<String> stateList = BaseFile.getExcelData("AddNewCustomer", 5);
		ArrayList<String> pinList = BaseFile.getExcelData("AddNewCustomer", 6);
		ArrayList<String> mobNumList = BaseFile.getExcelData("AddNewCustomer", 7);
		ArrayList<String> emailList = BaseFile.getExcelData("AddNewCustomer", 8);
		ArrayList<String> pwdList = BaseFile.getExcelData("AddNewCustomer", 9);
		
		for(int i=0;i<nameList.size();i++)
		{	System.out.println("Adding Customer - " + i + "Details : ");
			fillNewCustInfo(nameList.get(i), genderList.get(i), dobList.get(i), addrList.get(i), cityList.get(i),
					stateList.get(i), pinList.get(i), mobNumList.get(i), emailList.get(i), pwdList.get(i));
			
			submitNewCustInfo();
			
			Assert.assertTrue(getNewCustDashBoardMsg().equals("Customer Registered Successfully!!!"));
			
			launchCreateNewCustomer();
		}
		
		Reporter.log("As Expected,Multiple New Customer information From Excel is Added Successfully");		
	}


}
