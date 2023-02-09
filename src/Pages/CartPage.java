package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver ldriver;

    public CartPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(xpath = "//*[@id=\\\"sc-active-C77612d1c-a1f5-42bb-bf9f-12572c80fc08\\")
    @CacheLookup
    WebElement itemName;
    
    @FindBy(xpath = "//*[@id=\"a-autoid-0-announce\"]/span[2]")
    @CacheLookup
    WebElement quantity;
   
    @FindBy(xpath = "//*[@id=\"sc-active-C1c003213-623a-4a2c-bfb2-6cfc1544eec3\"]/div[4]/div/div[2]/ul/div/p/span")
    @CacheLookup
    WebElement Amount;
    
    @FindBy(xpath = "//*[@id=\"sc-subtotal-amount-activecart\"]/span")
    @CacheLookup
    WebElement totalAmount;
    
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/div[1]/span[2]/span/input")
    @CacheLookup
    WebElement delete;

    
    public String getItemName(){
    	return itemName.getText();
    }
    
    public String getQuantity(){
    	return quantity.getText();
    }
    
    public String getAmount(){
    	return Amount.getText();
    }
    
    public String getTotalAmount(){
    	return totalAmount.getText();
    }
    
    public void setDelete(){
    	delete.click();
    }

}
