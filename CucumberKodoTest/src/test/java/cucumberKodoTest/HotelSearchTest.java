package cucumberKodoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import resources.Utils;


public class HotelSearchTest {
	WebDriver driver = null;
	
	@Given("^I have online booking url as \"([^\"]*)\"$")
	public void i_have_online_booking_url_as(String arg1) throws Throwable {
	    System.setProperty("webdriver.chrome.driver","/home/vaibhav/eclipse-workspace/testAutomation20190409/libs/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	    driver.get(arg1);
	}

	@When("^I enter the check-in date as \"([^\"]*)\"$")
	public void i_enter_the_check_in_date_as(String arg1) throws Throwable {
		Utils.waitImplicit(driver, 3);
		if(driver.findElement(By.xpath("//*[@id='cookyGotItBtnBox']/div/button")).isDisplayed())
		{
			Utils.getElementClick(driver,By.xpath("//*[@id='cookyGotItBtnBox']/div/button"));
		}
	    Utils.getElementClick(driver, HotelSearchUi.checkInDate);
	    Utils.getSendKeys(driver, HotelSearchUi.checkInDate, arg1);
	 }

	@When("^I enter the check out date as \"([^\"]*)\"$")
	public void i_enter_the_check_out_date_as(String arg1) throws Throwable {
		Utils.waitImplicit(driver, 3);
	    Utils.getElementClick(driver, HotelSearchUi.checkOutDate);
	    Utils.getSendKeys(driver, HotelSearchUi.checkOutDate, arg1);
	}

	@When("^I select adult as \"([^\"]*)\"$")
	public void i_select_adult_as(String arg1) throws Throwable {
		Utils.waitImplicit(driver, 3);
		Utils.getElementClick(driver,HotelSearchUi.adultBtn);
		String temp = Utils.getElementAttribute(driver, By.xpath("//div[contains(@class,'input-group  bootstrap-touchspin bootstrap-touchspin-injected')]/input[contains(@class,'form-control touch-spin-03 form-readonly-control')]"), "value"); 
		Assert.assertTrue(!temp.equals("0"));
		Utils.waitImplicit(driver, 2);
	}
	
	@Then("^I should error message \"([^\"]*)\"$")
	public void i_should_error_message(String arg1) throws Throwable {
		String temp =Utils.getElementAttribute(driver, By.xpath("//div[@id='s2id_autogen1']"), "required"); 
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='s2id_autogen1']"))).build().perform();
		String temp1 = driver.findElement(By.xpath("//div[@id='s2id_autogen1']")).getText();
		WebElement temp2 = driver.findElement(By.xpath("/html/body/noscript[1]/text()"));
		Utils.getbrowserClose(driver);		
	}
	
	@When("^I select city as \"([^\"]*)\"$")
	public void i_select_city_as(String arg1) throws Throwable {
	 Utils.waitImplicit(driver, 2); 
	 if(driver.findElement(By.xpath("//*[@id='cookyGotItBtnBox']/div/button")).isDisplayed())
	 {
			Utils.getElementClick(driver, By.xpath("//*[@id='cookyGotItBtnBox']/div/button"));
	 }
	// Utils.waitImplicit(driver, 1);
	// if(driver.findElement(By.xpath("//*[@id='livechat-eye-catcher-img']/div[1]")).isDisplayed())
	// {
	//		Utils.getElementClick(driver,By.xpath("//*[@id='livechat-eye-catcher']/div[1]"));
	// }
	// Utils.waitImplicit(driver, 1);
	 Utils.getElementClick(driver, HotelSearchUi.cityTextBox);
	 Utils.waitImplicit(driver, 1);
     Utils.getSendKeys(driver, HotelSearchUi.entercityTextBox, arg1);
	 Utils.waitImplicit(driver, 1);
	 //Actions action = new Actions(driver);
	 //action.moveToElement(driver.findElement(By.xpath("//*[@id='livechat-eye-catcher-img']/img"))).build().perform();
	 //Utils.getElementClick(driver, By.xpath("//*[@id='livechat-eye-catcher']/div[1]"));
	 Utils.getElementClick(driver, HotelSearchUi.citySelect);
	}
	
	@When("^I click on search button$")
	public void i_click_on_search_button() throws Throwable {
		Utils.waitImplicit(driver, 3);
		Utils.getElementClick(driver, HotelSearchUi.searchBtn);
	}

	@Then("^Result should display based on search criteria$")
	public void result_should_display_based_on_search_criteria() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains("/search"));
		Assert.assertEquals("Mumbai",Utils.getElementText(driver, By.xpath("//html/body/div[2]/div[1]/div/section/div/div[2]/div/div/div[1]/div[1]/h3/span[2]")));
		Assert.assertEquals("MODIFY", Utils.getElementText(driver,By.xpath("//html/body/div[2]/div[1]/div/section/div/div[2]/div/div/div[1]/div[2]/button")));
		Utils.getbrowserClose(driver);
	}
	
	@When("^I add adult count while hotel search$")
	public void i_add_adult_count_while_hotel_search() throws Throwable {
		 Utils.waitImplicit(driver, 3);
		driver.findElement(HotelSearchUi.adultBtn).click();
		String temp = Utils.getElementAttribute(driver, By.xpath("//div[contains(@class,'input-group  bootstrap-touchspin bootstrap-touchspin-injected')]/input[contains(@class,'form-control touch-spin-03 form-readonly-control')]"), "value");
		//String temp = driver.findElement(By.xpath("//div[contains(@class,'input-group  bootstrap-touchspin bootstrap-touchspin-injected')]/input[contains(@class,'form-control touch-spin-03 form-readonly-control')]")).getAttribute("value");
		Assert.assertTrue(!temp.equals("0"));
		Utils.waitImplicit(driver, 1);
	}
	
	@When("^I add child count while hotel search$")
	public void i_add_child_count_while_hotel_search() throws Throwable {
		 Utils.waitImplicit(driver, 6);
		driver.findElement(HotelSearchUi.childBtn).click();
		String temp = Utils.getElementAttribute(driver, By.xpath("//div[contains(@class,'input-group  bootstrap-touchspin bootstrap-touchspin-injected')]/input[contains(@class,'form-control touch-spin-03 form-readonly-control')]"), "value");
		Assert.assertTrue(!temp.equals("0"));
		Utils.waitImplicit(driver, 1);
	}
}
