package TestCase;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Utilities.listener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.class)
public class TestDifferentProductName extends BaseClass{

	@Test(description = "TC_004")
    public void Test_Different_ProductName() 
	{
		HomePage homePage=new HomePage(driver);
		ProductListPage productListPage=new ProductListPage(driver);
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
            
        logger.info("URL is opened");
        
        logger.info("Select the category Books");
        homePage.setCategory();
        
        logger.info("Enter search result");
        homePage.setSearchBar();
        logger.info("Clicked on search");
        homePage.setSearchButton();
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("window.scrollBy(0,600)");
		logger.info("Clicked rating filter");
		productListPage.setRating();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		js.executeScript("window.scrollBy(0,1000)");
		logger.info("Clicked language filter");
		productListPage.setLanguage();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info("Get product name");
		String ProductName = productListPage.getProductName();
		System.out.println(ProductName); 
		driver.findElement(By.linkText(ProductName)).click();
	
	    logger.info("Validate the product name");
		String ActualTitle = productDetailsPage.getProductTitle();
		String ExpectedTitle = "Automation Testing";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		      
	}
    
}