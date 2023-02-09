package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductListPage {
	
	WebDriver ldriver;

    public ProductListPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(xpath = "/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]")
    @CacheLookup
    WebElement searchResult;
    
    @FindBy(xpath = "//*[@id=\"p_72/1250221011\"]")
    @CacheLookup
    WebElement rating;
    
    @FindBy(linkText = "English")
    @CacheLookup
    WebElement language;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
    @CacheLookup
    WebElement productName;
    
    public String getSearchResult(){
    	return searchResult.getText();
    }
       
    public void setRating(){
    	rating.click();
    }

    public void setLanguage(){
    	language.click();
    }
    
    public String getProductName() {
    	return productName.getText();
    }
    
   

}
