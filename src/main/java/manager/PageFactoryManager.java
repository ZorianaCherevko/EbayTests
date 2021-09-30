package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() { return new HomePage(driver);}

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {return new SearchResultsPage(driver);}

    public SecondSearchResultsPage getSecondSearchResultsPage() {return new SecondSearchResultsPage(driver);}

    public ProductPage getProductPage() {return new ProductPage(driver);}

    public CreateAccountPage getCreateAccountPage() { return new CreateAccountPage(driver);}



}
