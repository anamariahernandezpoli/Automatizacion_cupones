package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddCustomer;
import pages.CredentialsLogin;
import pages.HomePage;
import pages.Login;
import pages.Page;
import util.DataCustomer;

public class NewCustomer {
	
	public static WebDriver driver;
	
	Page page;
	CredentialsLogin credentialsLogin;
	DataCustomer dataCustomer = new DataCustomer();
	String username;
	String password;
	Login login;
	HomePage homepage;	
	AddCustomer addCustomer;	
	Alert alert;
	String alertMessage;
	
	@BeforeClass
	public static void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "Driver\\ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Before
	public void initPage() {
		driver.get("http://demo.guru99.com/v4/index.php");			
		page = new Page(driver);
		credentialsLogin = new CredentialsLogin(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickHere();		
		page.emailId(dataCustomer.getEmail());
		page.clickSubmmit();
		
		username = credentialsLogin.getUserName();
		password = credentialsLogin.getPassword();
		
		driver.get("http://demo.guru99.com/v4/index.php");
		login = new Login(driver);
		homepage = new HomePage(driver);		
		login.getIntoUsernameAndPassword(username, password);
		login.clickLogin();
		assertEquals(homepage.userHomePage(), "Manger Id : "+ username);
       	
	}

		
	@Test
	public void AddNewCustomer() {	
		
		addCustomer = new AddCustomer(driver);	
		homepage.clickNewCustomer();
		addCustomer.ingresarCustomerName(dataCustomer.getName());
		addCustomer.clickGender();
		addCustomer.getIntoDate(dataCustomer.getIntoBirthDate());
		addCustomer.getIntoAddress(dataCustomer.getAddres());
		addCustomer.getIntoCity(dataCustomer.getCity());
		addCustomer.getIntoState(dataCustomer.getState());
		addCustomer.getIntoPin(dataCustomer.getPin());
		addCustomer.getIntoNumber(dataCustomer.getNumber());
		addCustomer.getIntoEmail(dataCustomer.getEmail());
		addCustomer.getIntoPassword(dataCustomer.getPassword());
		addCustomer.clickBtnSubmit();
		assertEquals(addCustomer.verificarRegistro(), "Customer Registered Successfully!!!");		
	}
	

	@After
	public void cerrar() {
		driver.quit();
	}
	
}
