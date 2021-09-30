package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SecondSearchResultsPage extends BasePage{

    @FindBy(xpath = "//div[@class='s-item__info clearfix']//a[contains(@href,'item1a835')]")
    private WebElement productButton;

    @FindBy(xpath = "//li[@class='brm__item']//span[contains(text(),'Dog Size')]")
    private WebElement filterSizeButton;

    @FindBy(xpath = "//li[@class='brm__aspect-item']//a[contains(@href,'M-Leather')]")
    private WebElement filterMSizeButton;

    @FindBy(xpath = "//li[@class='brm__item']//span[contains(text(),'Material')]")
    private WebElement filterMaterialButton;

    @FindBy(xpath = "//li[@class='brm__aspect-item']//a[contains(@href,'Leather-Dog-Collars/63057/bn_7713')]")
    private WebElement filterLeatherMaterialButton;

    //li[@class='brm__aspect-item']//a[contains(@href,'M-Leather')]

    @FindBy(xpath = "//li[@class='brm__aspect-item brm__aspect-item--applied']")
    private List<WebElement> appliedFiltersList;

    @FindBy(xpath = "//li[@class='brm__aspect-item brm__aspect-item--applied']")
    private List<WebElement> filteredSearchResultsList;

    @FindBy(xpath = "//span[@class='s-item__shipping s-item__logisticsCost']")
    private List<WebElement> freeShippingItemsListText;

    @FindBy(xpath = "//span[@class='s-item__shipping s-item__logisticsCost']")
    private WebElement freeShippingItem;

    @FindBy(xpath = "//button[@class='brm__all-filters fake-link']")
    private WebElement allFiltersButton;

    @FindBy(xpath = "//div[@id='c3-mainPanel-delivery']")
    private WebElement deliveryOptionsButton;

    @FindBy(xpath = "//input[@aria-hidden='false']")
    private WebElement freeShippingButton;

    @FindBy(xpath = "//button[@aria-label='Apply']")
    private WebElement applyFiltersButton;

    @FindBy(xpath = "//button[@class='x-overlay-footer__apply-btn btn btn--primary  btn--small']")
    private WebElement filtersPopUp;

    @FindBy(xpath = "//div[@class='srp-controls__control srp-controls__sort']//button[@class='x-flyout__button']")
    private WebElement sortByButton;

    @FindBy(xpath = "//li[@class='btn'][4]")
    private WebElement highestPricefirsButton;

    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<WebElement> productsPriceListText;

    @FindBy(xpath = "//span[@class='DEFAULT']")
    private WebElement productPriceText;


    public SecondSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDeliveryOptionsButton() {
        return deliveryOptionsButton;
    }

    public void clickBroductButton() {
        productButton.click();
    }

    public void clickFilterSizeButton() {
        filterSizeButton.click();
    }

    public void clickFilterMSizeButton() {
        filterMSizeButton.click();
    }

    public void clickFilterMaterialButton() {
        filterMaterialButton.click();
    }

    public void clickFilterLeatherMaterialButton() {
        filterLeatherMaterialButton.click();
    }

    public int getAppliedFiltersList(){
        return appliedFiltersList.size();
    }
    public void clickAllFilters() {
        allFiltersButton.click();
    }

    public WebElement getFreeShippingItem() {
        return freeShippingItem;
    }

    public WebElement getFiltersPopUp() {
        return filtersPopUp;
    }

    public WebElement getFreeShippingButton() {
        return freeShippingButton;
    }

    public void clickDeliveryOptionsButton() {
        deliveryOptionsButton.click();
    }

    public void clickfreeShippingButton() {
        freeShippingButton.click();
    }

    public void clickApplyFiltersButton() {
        applyFiltersButton.click();
    }

    public List<WebElement> getFreeShippingItemsListText(){
        return freeShippingItemsListText;
    }






}
