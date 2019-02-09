package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddAccount;
import pages.AddCustomer;
import pages.CredentialsLogin;
import pages.HomePage;
import pages.Login;
import pages.Page;
import util.DataCustomer;

public class NewAccount {

	public static WebDriver driver;

	Page page;
	CredentialsLogin credentialsLogin;
	DataCustomer dataCustomer = new DataCustomer();	
	Login login;
	HomePage homepage;	
	AddCustomer addCustomer;
	AddAccount addAccount;
	String alertMessage;
	String username;
	String password;
	String customerID;

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
       	
	}

	@Before
	public void initLogin() {
		
		driver.get("http://demo.guru99.com/v4/index.php");
		login = new Login(driver);
		addCustomer = new AddCustomer(driver);
		homepage = new HomePage(driver);		
		login.getIntoUsernameAndPassword(username, password);
		login.clickLogin();
		assertEquals(homepage.userHomePage(), "Manger Id : "+ username);
		
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		assertEquals(addCustomer.verificarRegistro(), "Customer Registered Successfully!!!");
		customerID = addCustomer.customerID();

	}

	@Test
	public void addNewAccount() throws InterruptedException {
		
		addAccount = new AddAccount(driver);		
	    homepage.clickNewAccount();		
		addAccount.getIntoCustomerId(customerID);
		addAccount.getIntoInitialDeposit(dataCustomer.getInitialDeposit());
		addAccount.clickBtnSubmit();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		assertEquals(addAccount.messageAccount(), "Account Generated Successfully!!!");
	}

	@After
	public void cerrar() {
		driver.quit();
	}

}
