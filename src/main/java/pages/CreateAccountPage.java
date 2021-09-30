package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='EMAIL_REG_FORM_SUBMIT']")
    private WebElement createAccountbutton;

    @FindBy(xpath = "//span[@id='password_err']")
    private WebElement invalidPasswordErrorMessage;


    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCreateAccountbutton(){
        return createAccountbutton;
    }

    public boolean isErrorMessageDisplayed() {
       return invalidPasswordErrorMessage.isDisplayed();
    }

    public void clickCreateAccountbutton() {
        createAccountbutton.click();
    }

    public void enterTextPasswordInput(final String password) {
        passwordInput.click();
        firstNameInput.sendKeys(password);
    }

    public void enterTextFirstNameIput(final String firstnameText) {
        firstNameInput.click();
        firstNameInput.sendKeys(firstnameText);
    }

    public void enterTextLastNameIput(final String lastnameText) {
        lastNameInput.click();
        lastNameInput.sendKeys(lastnameText);
    }

    public void enterTextEmailIput(final String emailText) {
        emailInput.click();
        emailInput.sendKeys(emailText);
    }

}
