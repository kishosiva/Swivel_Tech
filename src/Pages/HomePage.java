package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver ldriver;

    public HomePage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(id = "searchDropdownBox")
    @CacheLookup
    WebElement category;
    
    @FindBy(id = "twotabsearchtextbox")
    @CacheLookup
    WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    @CacheLookup
    WebElement searchButton;
       
    public void setCategory(){
    	Select category1 = new Select(category);
		category1.selectByVisibleText("Books");
    }

    public void setSearchBar(){
    	searchBar.sendKeys("Automation");
    }

    public void setSearchButton(){
    	searchButton.click();
    }
    
    
}
