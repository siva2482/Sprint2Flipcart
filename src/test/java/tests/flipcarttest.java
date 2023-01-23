package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
public class flipcarttest {
	

	public static WebDriver driver;
	    HomePage obj;

	    @BeforeClass
	    public void init()
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	        obj = new HomePage(driver);
	        driver.get("https://www.flipkart.com");
	        driver.manage().window().maximize();
	    }
	    @Test
	    public void verifyPurchaseItem() throws InterruptedException {
	     String[] st=  obj.addToCart();
	     Assert.assertEquals(st[0],st[1]);
	     System.out.println("THE ipnhone selected is :"+st[0]);
	    }

}
