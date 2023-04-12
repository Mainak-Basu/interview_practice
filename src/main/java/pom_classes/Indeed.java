package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic_utility.BaseClass;

public class Indeed extends BaseClass{
	public Indeed(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
}
