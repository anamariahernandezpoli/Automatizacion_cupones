package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CredentialsLogin {

	@FindBy(xpath = "//table//tr[4]/td[2]")
	WebElement textUsername;

	@FindBy(xpath = "//table//tr[5]/td[2]")
	WebElement textPassword;

	WebDriver driver;

	public CredentialsLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getUserName() {
		return textUsername.getText();
	}

	public String getPassword() {
		return textPassword.getText();
	}
	
	

}
