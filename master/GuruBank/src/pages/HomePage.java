package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
    WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tr[@class=\"heading3\"]")
	WebElement textmanageid;
	
	@FindBy(xpath = "//div[3]/div/ul/li[5]/a")
	WebElement opctionNewAccount;
	
	@FindBy(xpath = "//div[3]/div/ul/li[2]/a")
	WebElement opctionNewCustomer;
	
	@FindBy(xpath = "//div[3]/div/ul/li[7]/a")
	WebElement optionDeleteAccount;
	
	
	public void clickNewAccount() {
		opctionNewAccount.click();
	}
	
	public void clickNewCustomer() {
		opctionNewCustomer.click();
	}
	
	public void clickDeleteAccount() {
		optionDeleteAccount.click();
	}
	
	public String userHomePage() {
		return textmanageid.getText();
	}

}
