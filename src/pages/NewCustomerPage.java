package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class NewCustomerPage extends BaseFile
{	
	@FindBy(xpath="//a[contains(@href,'addcus')]")
	public static WebElement newCustomerBtn;
	
	@FindBy(className="heading3")
	public static WebElement newCustDashBoardMsg;
	
	@FindBy(xpath="//a[text()='Continue']")
	public static WebElement continueBtn;
	
	@FindBy(name="name")
	public static WebElement newCustName ;
	
	@FindBy(css="input[value='m']")
	public static WebElement maleRadioBtn;
	
	@FindBy(css="input[value='f']")
	public static WebElement femaleRadioBtn;
	
	@FindBy(name="dob")
	public static WebElement newCustDOB;
	
	@FindBy(name="addr")
	public static WebElement newCustAddr;
	
	@FindBy(name="city")
	public static WebElement newCustCity;
	
	@FindBy(name="state")
	public static WebElement newCustState ;
	
	@FindBy(name="pinno")
	public static WebElement newCustPinNum;
	
	@FindBy(name="telephoneno")
	public static WebElement newCustTele;
	
	@FindBy(name="emailid")
	public static WebElement newCustEmail ;
	
	@FindBy(name="password")
	public static WebElement newCustPwd;
	
	@FindBy(name="sub")
	public static WebElement newCustSubmitBtn ;
	
	@FindBy(name="res")
	public static WebElement newCustResetBtn ;
	
	@FindBy(id="message")
	public static WebElement newCustNameErr ;
	
	@FindBy(id="message24")
	public static WebElement newCustDobErr ;
	
	@FindBy(id="message3")
	public static WebElement newCustAddrErr ;
	
	@FindBy(id="message4")
	public static WebElement newCustCityErr ;
	
	@FindBy(id="message5")
	public static WebElement newCustStateErr ;
	
	@FindBy(id="message6")
	public static WebElement newCustPinErr ;
	
	@FindBy(id="message7")
	public static WebElement newCustMobErr ;
	
	@FindBy(id="message9")
	public static WebElement newCustEmailErr ;
	
	@FindBy(id="message18")
	public static WebElement newCustPwdErr ;
	
	
	public static void launchCreateNewCustomer()
	{
		newCustomerBtn.click();
	}
	
	public static String getNewCustDashBoardMsg()
	{
		return newCustDashBoardMsg.getText();
	}
	
	public static void fillNewCustInfo(String name,String gender,String dOB,Object address,Object city,
			Object state,Object pinNum,Object mobNum,Object email,Object pwd) throws InterruptedException
	{
	newCustName.sendKeys(name);	
	if(gender.equalsIgnoreCase("male"))
	{
		maleRadioBtn.click();
	}
	else
	{
		femaleRadioBtn.click();
	}
	
	newCustDOB.sendKeys(dOB);
	newCustAddr.sendKeys(address.toString());
	newCustCity.sendKeys(city.toString());
	newCustState.sendKeys(state.toString());	
	newCustPinNum.sendKeys(pinNum.toString());	
	newCustTele.sendKeys(mobNum.toString());	
	newCustEmail.sendKeys(email.toString());	
	newCustPwd.sendKeys(pwd.toString());

	}
	
	public static void submitNewCustInfo() throws InterruptedException
	{
		newCustSubmitBtn.click();
	}
	
	public static void verifyErrMsgsNewCustPage() throws InterruptedException
	{
		newCustName.click();//newCustDashBoardMsg.click();
		
		newCustDOB.click();
		newCustAddr.click();
		newCustCity.click();
		newCustState.click();
		newCustPinNum.click();
		newCustTele.click();
		newCustEmail.click();
		newCustPwd.click();					
		newCustDashBoardMsg.click();
		Assert.assertEquals("Customer name must not be blank", newCustNameErr.getText());
		Assert.assertEquals("Date Field must not be blank", newCustDobErr.getText());
		Assert.assertEquals("Address Field must not be blank", newCustAddrErr.getText());
		Assert.assertEquals("City Field must not be blank", newCustCityErr.getText());
		Assert.assertEquals("State must not be blank", newCustStateErr.getText());
		Assert.assertEquals("PIN Code must not be blank", newCustPinErr.getText());
		Assert.assertEquals("Mobile no must not be blank", newCustMobErr.getText());
		Assert.assertEquals("Email-ID must not be blank", newCustEmailErr.getText());
		Assert.assertEquals("Password must not be blank", newCustPwdErr.getText());
	}
	
	
}
