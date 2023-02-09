package TestCase;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Pages.SummaryPage;
import Utilities.listener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.class)
public class TestInvalidCartDetails extends BaseClass{

	@Test(description = "TC_006")
    public void Test_Invalid_CartDetails() 
	{
		HomePage homePage=new HomePage(driver);
		ProductListPage productListPage=new ProductListPage(driver);
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		SummaryPage summaryPage = new SummaryPage(driver);
		CartPage cartPage = new CartPage(driver);
		
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
		
		logger.info("Get product name in product list page");
		String ProductName = productListPage.getProductName();
		System.out.println(ProductName); 
		driver.findElement(By.linkText(ProductName)).click();
		
		logger.info("select quantity in product details page");
		productDetailsPage.setQuantity();
		
		logger.info("Clicked Add to cart");
		productDetailsPage.setAddToCart();
		
		logger.info("Clicked Go to cart");
		summaryPage.setGoToCart();
		
		logger.info("Validate the product name");
		String ExpectedTitle = "Automation Testing";
		String ActualTitle = cartPage.getItemName();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		logger.info("Validate the product price");
		String ExpectedPrice = "$20.00";
		String ActualPrice = cartPage.getAmount();
		Assert.assertEquals(ActualPrice, ExpectedPrice);
		
		logger.info("Validate the product quantity");
		String ExpectedQuantity = "4";
		String ActualQuantity = cartPage.getQuantity();
		Assert.assertEquals(ActualQuantity, ExpectedQuantity);
		
		logger.info("Validate the product total amount");
		String ExpectedTotal = "$74.00";
		String ActualTotal = cartPage.getTotalAmount();
		Assert.assertEquals(ActualTotal, ExpectedTotal);
	}
    
}