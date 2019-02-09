package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CredentialsLogin;
import pages.HomePage;
import pages.Login;
import pages.Page;
import util.DataCustomer;

public class LoginGuruBank {

	public static WebDriver driver;
	Page page;
	CredentialsLogin credentialsLogin;
	DataCustomer dataCustomer = new DataCustomer();
	String username;
	String password;
	Login login;
	HomePage homepage;	
	
	@BeforeClass
	public static void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "Driver\\ChromeDriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Before
	public void init() {
		driver.get("http://demo.guru99.com/v4/index.php");	
		
		page = new Page(driver);
		credentialsLogin = new CredentialsLogin(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page.clickHere();		
		page.emailId(dataCustomer.getEmail());
		page.clickSubmmit();
		
		username = credentialsLogin.getUserName();
		password = credentialsLogin.getPassword();
		
		
		
       	
	}

	@Test
	public void loginPage() throws InterruptedException {
		
		driver.get("http://demo.guru99.com/v4/index.php");
		login = new Login(driver);
		homepage = new HomePage(driver);		
		login.getIntoUsernameAndPassword(username, password);
		login.clickLogin();
		assertEquals(homepage.userHomePage(), "Manger Id : "+ username);

	}
	
	@After
	public void cerrar() {
		driver.quit();
	}

}
