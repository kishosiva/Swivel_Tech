package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
	WebDriver ldriver;

    public ProductDetailsPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(xpath = "//*[@id=\"price\"]")
    @CacheLookup
    WebElement price;
    
    @FindBy(xpath = "//*[@id=\"productTitle\"]")
    @CacheLookup
    WebElement productTitle;

    @FindBy(id = "quantity")
    @CacheLookup
    WebElement quantity;
    
    @FindBy(id = "add-to-cart-button")
    @CacheLookup
    WebElement addToCart;
       
    public String getPrice(){
    	return price.getText();
    }
    
    public String getProductTitle(){
    	return productTitle.getText();
    }
    
    public void setQuantity(){
    	Select quantity1 = new Select(quantity);
		quantity1.selectByValue("2");
    }
    
    public void setAddToCart(){
    	addToCart.click();
    }
}
