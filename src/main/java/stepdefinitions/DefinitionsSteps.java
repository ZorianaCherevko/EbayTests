package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.math.BigDecimal;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionsSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    SecondSearchResultsPage secondSearchResultsPagePage;
    PageFactoryManager pageFactoryManager;
    CreateAccountPage createAccountPage;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks Shop by Category button")
    public void clicksShopByCategoryButton() {
        homePage.clickShopByCategoryButton();
    }

    @And("User clicks Pet Supplies button")
    public void clickPetSuppliesButton() {
        homePage.clickPetSuppliesButton();
    }

    @And("User clicks Dog Supplies button")
    public void clickDogSuppliesButton() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickDogSuppliesbutton();
    }

    @And("User clicks Collars button")
    public void clickCollarsButton() {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getCollarButtonVisible());
        searchResultsPage.clickCollarButton();
    }

    @And("User clicks on first product")
    public void clickOnFirstProduct() {
        secondSearchResultsPagePage = pageFactoryManager.getSecondSearchResultsPage();
        secondSearchResultsPagePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        secondSearchResultsPagePage.clickBroductButton();
    }

    @And("User clicks Add to Cart button on product")
    public void clickAddToCartButtonOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User clicks Remove button")
    public void clickRemoveButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.clickRemoveButton();
    }

    @Then("User checks that text in cart is {string}")
    public void checkAddToCartTitle(final String expectedText) {
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,shoppingCartPage.getStartShoppingButton());
        assertEquals(shoppingCartPage.getShoppingCartTitleText(), expectedText);
    }

    @And("User chooses Dog Size Filter")
    public void chooseDogSizeFilter() {
        secondSearchResultsPagePage.clickFilterSizeButton();
        secondSearchResultsPagePage.clickFilterMSizeButton();
    }

    @And("User chooses Material Filter")
    public void chooseMaterialFilter() {
        secondSearchResultsPagePage = pageFactoryManager.getSecondSearchResultsPage();
        secondSearchResultsPagePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        secondSearchResultsPagePage.clickFilterMaterialButton();
        secondSearchResultsPagePage.clickFilterLeatherMaterialButton();
    }

    @Then("User checks that amount of applied filters is {int}")
    public void checkAmountOfAppliedFilters(int expectedAmount) {
        secondSearchResultsPagePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(secondSearchResultsPagePage.getAppliedFiltersList(), expectedAmount);
    }

    @And("User clicks All Filters")
    public void clickAllFilters() {
        secondSearchResultsPagePage = pageFactoryManager.getSecondSearchResultsPage();
        secondSearchResultsPagePage.clickAllFilters();
    }

    @And("User applies Free Shipping Filter")
    public void applyFreeShippingFilter() {
        secondSearchResultsPagePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, secondSearchResultsPagePage.getDeliveryOptionsButton());
        secondSearchResultsPagePage.clickDeliveryOptionsButton();
        secondSearchResultsPagePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, secondSearchResultsPagePage.getFreeShippingButton());
        secondSearchResultsPagePage.clickfreeShippingButton();
        secondSearchResultsPagePage.clickApplyFiltersButton();
    }

    @Then("User checks that all Search Results contain {string}")
    public void checkAllSearchResultsShipping(final String expectedText) {
        secondSearchResultsPagePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, secondSearchResultsPagePage.getFreeShippingItem());
        for (WebElement webElement : secondSearchResultsPagePage.getFreeShippingItemsListText()) {
            assertTrue(webElement.getText().contains(expectedText));
        };
    }

    @When("User makes search by keyword {string}")
    public void makesSearchByKeyword(final String keyword) {
        homePage.enterTextToSearchIput(keyword);
        homePage.clickSearchearchButton();
    }

    @Then("All search results have category {string}")
    public void checkAllSearchResultsCategory(final String expectedText) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (int i = 0; i < searchResultsPage.getIphoneHeadersList().size(); i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",  searchResultsPage.getIphoneHeadersList().get(i));
            productPage = pageFactoryManager.getProductPage();
            assertEquals(productPage.getCategorytButtonText(), expectedText);
            driver.navigate().back();
        }
    }

    @When("User clicks Register button")
    public void clickRegisterButton() {
        homePage.clickRegisterButton();
    }

    @And("User clicks Create Account button")
    public void clickCreateAccountButton() {
        createAccountPage.clickCreateAccountbutton();
    }

    @And("User inputs firstname {string}")
    public void inputFirstname(final String firstName) {
        createAccountPage = pageFactoryManager.getCreateAccountPage();
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        createAccountPage.enterTextFirstNameIput(firstName);
    }

    @And("User inputs lastname {string}")
    public void inputLastName(final String lastName) {
        createAccountPage.enterTextLastNameIput(lastName);
    }

    @And("User inputs email {string}")
    public void inputEmail(final String email) {
        createAccountPage.enterTextEmailIput(email);
    }

    @Then("User can not click Create Account")
    public void canNotClickCreateAccount() {
        assertFalse(createAccountPage.getCreateAccountbutton().isEnabled());
    }

    @And("User changes shipping options")
    public void changeShippingOptions(){
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickShippingToButton();
        searchResultsPage.clickOpenShippingOptionsButton();
        searchResultsPage.clickShippingToHongKong();
        searchResultsPage.clickApplyShippingCountryButton();
    }

    @Then("All Search Results can be shipped to {string}")
    public void checkSearchResultsShippingCountry(final String shippingCountry) {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.getShippingToButtonText().getText().contains(shippingCountry));
    }

    @And("User inputs password {string}")
    public void inputPassword(final String password) {
        createAccountPage.enterTextPasswordInput(password);
    }

    @Then("User sees Error Message")
    public void getErrorMessage() {
        createAccountPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(createAccountPage.isErrorMessageDisplayed());
    }

    @And("User clicks Items per page")
    public void clickTwentyFiveItemsPerPage() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultsPage.getTwentyFiveItemsPerPage());
        searchResultsPage.clickItemsPerPageButton();
        searchResultsPage.clickTwentyFiveItemsPerPage();
    }

    @Then("There are more search results than expected according to {int} per page")
    public void checkSearchResultsAccordingToItemsPerPage(int amountOfItemsOnPage ) {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertNotEquals(searchResultsPage.getIphoneHeadersList().size(), amountOfItemsOnPage);
    }

    @Then("All search results have word {string}")
    public void checkSearchResultsContainWord(final String word) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        for (int i = 0; i < searchResultsPage.getPaginationItemsList().size(); i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchResultsPage.getPaginationItemsList().get(i));
            for (WebElement element : searchResultsPage.getIphoneHeadersList()){
                assertTrue(element.getText().contains(word));
            }
        }
    }

    @And("User clicks on Iphone")
    public void clickOnIphone() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickIpnoneButton();
    }

    @And("User checks title visibility")
    public void checkTitleVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.isTitleFieldVisible();
    }

    @And("User checks Breadcrumbs visibility")
    public void checkBreadcrumbsVisibility() {
        productPage.isBreadCrumbsFieldVisible();
    }

    @And("User checks Back to search visibility")
    public void checkBackToSearchVisibility() {
        productPage.isBackToSearchButtonVisible();
    }

    @And("User checks Price visibility")
    public void checkPriceVisibility() {
        productPage.isPriceFieldVisible();
    }

    @And("User checks Buy It Now button visibility")
    public void checkBuyItNowButtonVisibility() {
        assertTrue(productPage.isBuyItNowButtonVisible());
    }

    @And("User checks Add To WatchList button visibility")
    public void checkAddToWatchListButtonVisibility() {
        productPage.isAddToWatchlistdVisible();
    }

    @And("User checks Sign In button visibility")
    public void checkSignInButtonVisibility() {
        assertTrue(productPage.isSignInButtonVisible());
    }


    @And("User checks Rating visibility")
    public void checkRatingVisibility() {
        productPage.isRatingFieldVisible();
    }

    @Then("User checks Add To Cart button visibility")
    public void checkAddToCartButtonVisibility() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(productPage.isAddToCartButtonVisible());
    }

    @And("User checks Seller Information visibility")
    public void checkSellerInformationVisibility() {
        productPage.isSellerInformationFieldVisible();
    }

    @Then("All pages have {int} sorting options")
    public void checkSortingOptions(int sortOptions) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        for (int i = 0; i < searchResultsPage.getPaginationItemsList().size(); i++) {
            searchResultsPage.clickSortSelectorButton();
            assertEquals(searchResultsPage.getSortOptionsList().size(), sortOptions);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchResultsPage.getPaginationItemsList().get(i));
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
