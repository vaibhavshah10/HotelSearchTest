package cucumberKodoTest;

import org.openqa.selenium.By;

public class HotelSearchUi {
	// check in date
	public static By checkInDate =  By.id("checkin");
	// check out date
	public static By checkOutDate =  By.id("checkout");
	// Adult + Button
	public static By adultBtn = By.xpath("//div[contains(@class,'col o2')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
	// Child + Button
	public static By childBtn = By.xpath("//div[contains(@class,'col 01')]//button[contains(@class,'btn btn-white bootstrap-touchspin-up')][contains(text(),'+')]");
	// Search Button
	public static By searchBtn = By.xpath("//button[contains(@class,'btn btn-primary btn-block')][contains(text(),'Search')]");
	// click on city Name text box
	public static By cityTextBox = 	By.xpath("//span[contains(@class,'select2-chosen')]");
	// enter city Name text box
	public static By entercityTextBox = By.xpath("//div[@id='select2-drop']//input[@class='select2-input select2-focused']");
	
	// Select City Name 
	public static By citySelect = By.xpath("//*[@id='select2-drop']/ul/li/ul/li");
   // click on city text box
	public static By testres = By.xpath("//*[@id='HotelsLoad']");
	
}

