package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	Thread.sleep(2000);
	if(gender.equalsIgnoreCase("male"))
	{
		maleRadioBtn.click();
	}
	else
	{
		femaleRadioBtn.click();
	}
	Thread.sleep(2000);
	newCustDOB.sendKeys(dOB);
	Thread.sleep(2000);
	newCustAddr.sendKeys(address.toString());
	Thread.sleep(2000);
	newCustCity.sendKeys(city.toString());
	Thread.sleep(2000);
	newCustState.sendKeys(state.toString());
	Thread.sleep(2000);
	newCustPinNum.sendKeys(pinNum.toString());
	Thread.sleep(2000);
	newCustTele.sendKeys(mobNum.toString());
	Thread.sleep(2000);
	newCustEmail.sendKeys(email.toString());
	Thread.sleep(2000);
	newCustPwd.sendKeys(pwd.toString());
	Thread.sleep(2000);
	}
	
	public static void submitNewCustInfo()
	{
		newCustSubmitBtn.click();
	}
	
	
	
}
