package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage {
	WebDriver ldriver;

    public SummaryPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(id = "NATC_SMART_WAGON_CONF_MSG_SUCCESS")
    @CacheLookup
    WebElement successMsg;
    
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/div[2]/div/div[1]/div/span[2]/span/span[1]")
    @CacheLookup
    WebElement total;
    
    @FindBy(linkText = "Go to Cart")
    @CacheLookup
    WebElement goToCart;

    public String getSuccess(){
    	return successMsg.getText();
    }
    
    public String getTotal() {
    	return total.getText();
    }
    
    public void setGoToCart(){
    	goToCart.click();
    }
    
}
