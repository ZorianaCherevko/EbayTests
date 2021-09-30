package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//h1[@class='main-title']")
    private WebElement shoppingCartTitle;
    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeButton;
    @FindBy(xpath = "//a[@data-test-id='start-shopping']")
    private WebElement startShoppingButton;


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getShoppingCartTitleText() {
        return shoppingCartTitle.getText();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public WebElement getStartShoppingButton() {
        return startShoppingButton;
    }



}
