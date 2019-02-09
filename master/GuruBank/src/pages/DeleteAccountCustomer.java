package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountCustomer {

	WebDriver driver;

	public DeleteAccountCustomer(WebDriver driver) {
	    this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"accountno\"]")
	WebElement txtAccountNo;

	@FindBy(xpath = "//input[@name=\"AccSubmit\"]")
	WebElement btnSubmit;

	@FindBy(xpath = "//input[@name=\"res\"]")
	WebElement btnReset;

	public void getIntoAccountNo(String accountNo) {	
		txtAccountNo.sendKeys(accountNo);
	}

	public void clickBtnSubmit() {
		btnSubmit.click();
	}

	public void clickBtnReset() {
		btnReset.click();
	}

}
