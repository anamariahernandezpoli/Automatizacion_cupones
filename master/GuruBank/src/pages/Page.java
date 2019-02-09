package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {

	WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"emailid\"]")
	WebElement textEmailId;

	@FindBy(xpath = "//input[@name=\"btnLogin\"]")
	WebElement btnSubmmit;
	
	@FindBy(xpath = "//div[4]/ol/li[1]/a")
	WebElement linkHere;

	public void clickSubmmit() {
		btnSubmmit.click();
	}
	
	public void clickHere() {
		linkHere.click();
	}
	
	public void emailId(String emailId) {	
		textEmailId.sendKeys(emailId);
	}

	public void WindowHandle() {

		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				

				clickSubmmit();

				// Closing the Child Window.
				driver.close();
			}
		}
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);
	}

}
