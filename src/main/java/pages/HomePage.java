package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[@id='gh-shop-a']")
    private WebElement shopByCategoryButton;

    @FindBy(xpath = "//a[contains(text(),'Pet supplies')]")
    private WebElement petSuppliesButton;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@id='gh-ug-flex']//a[contains(@href,'Part')]")
    private WebElement registerButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterTextToSearchIput(final String searchText) {
        searchInput.click();
        searchInput.sendKeys(searchText);
    }
    public void clickRegisterButton() {
        registerButton.click();
    }

    public void clickSearchearchButton() {
        searchButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickShopByCategoryButton() {
        shopByCategoryButton.click();
    }

    public void clickPetSuppliesButton() {
        petSuppliesButton.click();
    }

}
