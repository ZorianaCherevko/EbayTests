package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='thrd']//span[@itemprop='name']")
    private WebElement  categorytButton;

    @FindBy(xpath = "//a[@id='binBtn_btn']")
    private WebElement  buyItNowButton;

    @FindBy(xpath = "//a[@id='review-ratings-cntr']")
    private WebElement  ratingField;

    @FindBy(xpath = "//h1[@id='itemTitle']")
    private WebElement  titleField;

    @FindBy(xpath = "//li[@class='vi-VR-bkto']//a[@title='Click to Go Back to search results']")
    private WebElement  backToSearchButton;

    @FindBy(xpath = "//li[@id='vi-VR-brumb-lnkLst']")
    private WebElement  breadCrumbsField;

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement priceField;

    @FindBy(xpath = "//a[@n='Watch list']")
    private WebElement addToWatchlist;

    @FindBy(xpath = "//span[@class='gh-ug-guest']//a[contains(@href,'SignIn')]")
    private WebElement  signInButton;

    @FindBy(xpath = "//div[@class='si-inner']")
    private WebElement  sellerInformationField;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void isSellerInformationFieldVisible() {
        sellerInformationField.isDisplayed();
    }

    public void isRatingFieldVisible() {
        ratingField.isDisplayed();
    }

    public void isTitleFieldVisible() {
        titleField.isDisplayed();
    }

    public void isBreadCrumbsFieldVisible() {
        breadCrumbsField.isDisplayed();
    }

    public void isPriceFieldVisible() {
        priceField.isDisplayed();
    }

    public void isAddToWatchlistdVisible() {
        addToWatchlist.isDisplayed();
    }

    public void isBackToSearchButtonVisible() {
        backToSearchButton.isDisplayed();
    }

    public boolean isAddToCartButtonVisible() {
        return addToCartButton.isDisplayed();
    }

    public boolean isBuyItNowButtonVisible() {
        return buyItNowButton.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public String getCategorytButtonText() {
        return categorytButton.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

}
