package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseFile
{	
	@FindBy(xpath="//tr[@class ='heading3']")
	public static WebElement dashBoardMsg;
		
/*	public LoginPage()
	{
		PageFactory.initElements(driver, this);		
	}*/
	
	public static String getHomeMsg()
	{
		return dashBoardMsg.getText().toLowerCase();
	}
	
}
