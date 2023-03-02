package pom_classes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic_utility.BaseClass;

public class Search_Name extends BaseClass{
	
	public Search_Name(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(name="q")
public WebElement searchbox;
@FindBy(id="icon")
public WebElement icon;
@FindBy(id="result-stats")
public WebElement result;

public void getresult() {
	String input = result.getText();
    Pattern pattern = Pattern.compile("(\\d+(?:,\\d+)*)\\s+results");
    Matcher matcher = pattern.matcher(input);
    if (matcher.find()) {
        String result1 = matcher.group(1).replace(",", "");
        System.out.println(result1);
        int number = Integer.parseInt(result1);
        if(number>50000) {
        	System.out.println("Number of results are more than 50000");
        }
    }
  
}

}
