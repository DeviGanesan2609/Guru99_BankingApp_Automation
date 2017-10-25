package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseFile
{
public static  WebDriver driver;
public static WebDriverWait waitObj ;
public static Alert alertObj;

@FindBy(name="uid")
public static WebElement guru99UserName;

@FindBy(name="password")
public static WebElement guru99Pwd;

@FindBy(name="btnLogin")
public static WebElement guru99LoginBtn;

@FindBy(xpath="//tr[@class ='heading3']")
public static WebElement dashBoardMsg;

@FindBy(xpath="//a[contains(text(),'Log')]")
public static WebElement logOutBtn;

@FindBy(tagName="title")
public static WebElement homeTitle;


@BeforeClass
public void setUpBrowser()
{
	System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
	driver =new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/V4/");	
	PageFactory.initElements(driver, this);
}

public static void loginMethod()
{	
	guru99UserName.sendKeys("mngr100556");
	guru99Pwd.sendKeys("epUvEny");
	guru99LoginBtn.click();
}

public static String getHomeMsg()
{
	return dashBoardMsg.getText().toLowerCase();
}


public static ArrayList<String> getExcelData(String sheetName,int colNum) throws IOException
{
	ArrayList<String> listObj = new ArrayList<String>();
	
	FileInputStream fis =new FileInputStream("D:\\TestData_Guru99Bank.xlsx");
	XSSFWorkbook wb =new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet(sheetName);
	DataFormatter fmt =new DataFormatter();
	Iterator<Row> it = sheet.iterator();
	it.next();
	while(it.hasNext())
	{	
		Cell cell = it.next().getCell(colNum);
		String value = fmt.formatCellValue(cell);
		listObj.add(value);
	}
	return listObj;
}

public static String acceptAlert() throws InterruptedException
{	

	alertObj = driver.switchTo().alert();
	Thread.sleep(2000);
	
	String alertText = alertObj.getText();
	Thread.sleep(2000);
	alertObj.accept();
	Thread.sleep(2000);
	return alertText;
	
}




public static void logoutMethod()
{
	logOutBtn.click();
	alertObj = driver.switchTo().alert();
	alertObj.accept();
	
}

/*@BeforeMethod
public void loginpage()
{
	//driver.get("http://demo.guru99.com/V4/");
	PageFactory.initElements(driver, this);
}*/


public static String randomStringGenerator()
{
	String characters = "abcdefghijklmnopqrstuvwxyz";
	Random randomInt = new Random();
	Random ranString = new SecureRandom();
	int length = randomInt.nextInt(10)+1;
	StringBuilder sb = new StringBuilder();
	for(int i =0;i<length;i++)
	{
		sb.append(characters.charAt(ranString.nextInt(characters.length())));
	}		
	return sb.toString();
	
}

@AfterClass
public void closeBroser()
{
	System.out.println("Ending Browser Sessions");
	driver.quit();
}
}
