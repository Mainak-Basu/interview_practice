package pom_classes;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utility.BaseClass;

public class Checkboxes extends BaseClass{
	public Checkboxes(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//label[@for='checkbox-2']")
public WebElement checkbox;



public void clickcheckbox() {
Actions action = new Actions(driver);
action.moveToElement(checkbox).click().perform();
}
}
