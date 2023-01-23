package pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	
	@FindBy(xpath="//button[text()='✕']")
	WebElement closeBtn;
	
	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(xpath="//div[text()='APPLE iPhone 14 (Blue, 128 GB)'][@class='_4rR01T']")
	WebElement item;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='KK-o3G']")
	WebElement cart;
	@FindBy(xpath="//div[@class='aMaAEs']//h1//span")
	WebElement parent_name;
	@FindBy(xpath="//div[@class='_2-uG6-']//a")
	WebElement child_name;
	
	
	
	
	public String[] addToCart() throws InterruptedException {
		String[] str=new String[2];
		Thread.sleep(3000);
		closeBtn.click();
		searchBox.sendKeys("iphone",Keys.ENTER);
		 
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", item);
		//item.click();
		//str[0]=parent_name.getText();
		Thread.sleep(3000);
		
		String parent = driver.getWindowHandle();
		
		Set<String> child = driver.getWindowHandles();
		for(String s: child) {
			if(!(s==parent))
			driver.switchTo().window(s);
			
		}
		str[0]=parent_name.getText();
		addToCartBtn.click();
		Thread.sleep(3000);
		 str[1]=child_name.getText();
		Thread.sleep(5000);
		//driver.switchTo().window(parent);
		//driver.navigate().refresh();
		Thread.sleep(5000);
		return str;
		
	}
	
	    public HomePage(WebDriver driver)
	    {
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	    }

	    



}
