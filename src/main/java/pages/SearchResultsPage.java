package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Dog Supplies')]")
    private WebElement dogSuppliesbutton;

    @FindBy(xpath = "//ul[@class='b-accordion-subtree']//a[contains(@href,'Collars/63057')]")
    private WebElement collarButton;

    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> iphoneHeadersList;

    @FindBy(xpath = "//div[@class='x-flyout srp-controls__control srp-shipping-location__flyout']")
    private WebElement shippingToButton;

    @FindBy(xpath = "//input[@class='srp-shipping-location__form--inline btn btn--small btn--primary']")
    private WebElement applyShippingCountryButton;

    @FindBy(xpath = "//span[@class='srp-controls--selected-value']")
    private WebElement shippingToButtonText;

    @FindBy(xpath = "//div[@class='srp-shipping-location__form--inline listbox listbox--no-label listbox--small']")
    private WebElement openShippingOptionsButton;

    @FindBy(xpath = "//span[@class='select']//option[@value][89]")
    private WebElement shippingToHongKong;

    @FindBy(xpath = "//a[contains(@href,'ipg=25')]")
    private WebElement twentyFiveItemsPerPage;

    @FindBy(xpath = "//button[@aria-controls='srp-ipp-menu-content']//span[@class='expand-btn__cell']")
    private WebElement itemsPerPageButton;

    @FindBy(xpath = "//a[@class='pagination__item']")
    private List<WebElement> paginationItemsList;

    @FindBy(xpath = "//h3[contains(text(),'Black Factory')]")
    private WebElement ipnoneButton;

    @FindBy(xpath = "//span[@class='fake-menu-button srp-controls__control']//button[@class='fake-menu-button__button expand-btn expand-btn--small']")
    private WebElement sortSelectorButton;

    @FindBy(xpath = "//ul[@id='s0-14-11-5-2[0]-37-0-content-menu']//a[@class='fake-menu-button__item']")
    private List<WebElement> sortOptionsList;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSortSelectorButton() {
        sortSelectorButton.click();
    }

    public List<WebElement> getSortOptionsList() {
        return sortOptionsList;
    }

    public void clickIpnoneButton() {
        ipnoneButton.click();
    }

    public void clickItemsPerPageButton() {
        itemsPerPageButton.click();
    }

    public List<WebElement> getPaginationItemsList() {
        return paginationItemsList;
    }

    public void clickTwentyFiveItemsPerPage() {
        twentyFiveItemsPerPage.click();
    }

    public WebElement getTwentyFiveItemsPerPage() {
        return twentyFiveItemsPerPage;
    }

    public void clickOpenShippingOptionsButton() {
        openShippingOptionsButton.click();
    }

    public void clickShippingToButton() {
        shippingToButton.click();
    }

    public void clickShippingToHongKong() {
        shippingToHongKong.click();
    }

    public WebElement getShippingToButtonText() {
        return shippingToButtonText;
    }

    public void clickApplyShippingCountryButton() {
        applyShippingCountryButton.click();
    }

    public List<WebElement> getIphoneHeadersList(){
        return iphoneHeadersList;
    }

    public void clickDogSuppliesbutton() {
        dogSuppliesbutton.click();
    }

    public WebElement getCollarButtonVisible() {
        return collarButton;
    }

    public void clickCollarButton() {
        collarButton.click();
    }


}
