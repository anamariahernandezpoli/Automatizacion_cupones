package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"uid\"]")
	WebElement txtusername;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@name=\"btnLogin\"]")
	WebElement btnLogin;
	
	public void getIntoUsernameAndPassword(String username, String password) {
		txtusername.sendKeys(username);
		txtpassword.sendKeys(password);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	

}
