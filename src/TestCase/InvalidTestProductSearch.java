package TestCase;

import Pages.HomePage;
import Pages.ProductListPage;
import Utilities.listener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.class)
public class InvalidTestProductSearch extends BaseClass{

	@Test(description = "TC_002")
    public void Invalid_Test_ProductSearch() 
	{
		HomePage homePage=new HomePage(driver);
		ProductListPage productListPage=new ProductListPage(driver);
            
        logger.info("URL is opened");
        
        logger.info("Select the category Books");
        homePage.setCategory();
        
        logger.info("Enter search result");
        homePage.setSearchBar();
        logger.info("Clicked on search");
        homePage.setSearchButton();
        String expectedResult = "Testing";
        String actualResult = productListPage.getSearchResult();
        Assert.assertEquals(actualResult, expectedResult);
            
	}
    
}