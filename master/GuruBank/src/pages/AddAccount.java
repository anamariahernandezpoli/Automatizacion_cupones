package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAccount {

	WebDriver driver;

	public AddAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"cusid\"]")
	WebElement txtCustomerId;

	@FindBy(xpath = "//select[@name=\"selaccount\"]//option[@value=\"Current\"]")
	WebElement selectTypeAccount;

	@FindBy(xpath = "//input[@name=\"inideposit\"]")
	WebElement txtInitialDeposit;

	@FindBy(xpath = "//input[@name=\"button2\"]")
	WebElement btnSubmit;

	@FindBy(xpath = "//input[@name=\"reset\"]")
	WebElement btnReset;
	
	@FindBy(xpath = "//*[@id=\"account\"]//tr[1]/td/p")
	WebElement messageAccount;
	
	@FindBy(xpath = "//*[@id=\"account\"]//tr[4]/td[2]")
	WebElement accountID;


	public void getIntoCustomerId(String customerId) {
		txtCustomerId.sendKeys(customerId);
	}

	public void getIntoInitialDeposit(String initialDeposit) {
		txtInitialDeposit.sendKeys(initialDeposit);
	}

	public void clickBtnSubmit() {
		btnSubmit.click();
	}

	public void clickBtnReset() {
		btnReset.click();
	}

	public void clickOptionAppTraductor(String opcion) {
		selectTypeAccount.click();
	}
	
	public String messageAccount() {
		return messageAccount.getText();
	}
	
	public String accountID() {
		return accountID.getText();
	}

}
