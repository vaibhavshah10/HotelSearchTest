package resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static String getElementText(WebDriver driver, By ele)
	{
		String retText = driver.findElement(ele).getText();
		return retText;
	}
	
	public static String getElementAttribute(WebDriver driver, By ele,String attributeVal)
	{
		String retText = driver.findElement(ele).getAttribute(attributeVal);
		return retText;
	}
	
	public static WebElement getWait(WebDriver driver,int sec,By ele)
	{
		WebElement retElement=null;
		WebDriverWait wait = new WebDriverWait(driver,30);
		//retElement = wait.until(ExpectedConditions.visibilityOfElementLocated(//.cityTextBox));
		return retElement;
	}
	
	public static void getElementClick(WebDriver driver,By ele)
	{
		try {
			driver.findElement(ele).click();
		}
		catch (Exception e)
		{
			System.out.println("element not found to click");
		}
	}
	
	public static void getSendKeys(WebDriver driver,By ele,String str)
	{
		try {
			driver.findElement(ele).sendKeys(str);
		}
		catch (Exception e)
		{
			System.out.println("Error while sending text");
		}
		
	}
	
	public static void waitImplicit(WebDriver driver,int sec) 
	{
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public static void getbrowserClose(WebDriver driver)
	{
		driver.close();
	}	
}
