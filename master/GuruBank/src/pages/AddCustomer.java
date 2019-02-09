package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	
	WebDriver driver;
	
	public AddCustomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@name=\"name\"]")
	WebElement txtCustomerName;
	
	@FindBy(xpath = "//input[@value=\"f\"]")
	WebElement checkBoxGender;
	
	@FindBy(xpath = "//input[@id=\"dob\"]")
	WebElement txtDate;
	
	@FindBy(xpath= "//textarea[@name=\"addr\"]")
	WebElement txtAddress;
	
	@FindBy(xpath = "//input[@name=\"city\"]")
	WebElement txtCity;
	
	@FindBy(xpath = "//input[@name=\"state\"]")
	WebElement txtState;
	
	@FindBy(xpath = "//input[@name=\"pinno\"]")
	WebElement txtPin;
	
	@FindBy(xpath = "//input[@name=\"telephoneno\"]")
	WebElement txtNumber;
	
	@FindBy(xpath = "//input[@name=\"emailid\"]")
	WebElement txtemail;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value=\"Submit\"]")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//input[@value=\"Reset\"]")
	WebElement btnReset;
	
	@FindBy(xpath = "//*[@id=\"customer\"]//tr[1]/td/p")
	WebElement txtmenssageRegistred;
	
	@FindBy(xpath = "//*[@id=\"customer\"]//tr[4]/td[2]")
	WebElement customerID;
	
	public void ingresarCustomerName(String name) {
		txtCustomerName.sendKeys(name);
	}
	
	public void clickGender() {
		checkBoxGender.click();
	}
	
	public void getIntoDate(String date) {
		txtDate.sendKeys(date);
	}
	
	public void getIntoAddress(String address) {
		txtAddress.sendKeys(address);
	}
	
	public void getIntoCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void getIntoState(String state) {
		txtState.sendKeys(state);
	}
	
	public void getIntoPin(String pin) {
		txtPin.sendKeys(pin);
	}
	
	public void getIntoNumber(String number) {
		txtNumber.sendKeys(number);
	}
	
	public void getIntoEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void getIntoPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickBtnSubmit() {
		btnSubmit.click();
	}
	
	public void clickBtnReset() {
		btnReset.click();
	}
	
	public String verificarRegistro() {
		return txtmenssageRegistred.getText();
	}
	
	public String customerID() {
		return customerID.getText();
	}

}
