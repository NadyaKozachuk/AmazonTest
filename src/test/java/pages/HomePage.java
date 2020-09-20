package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='nav-xshop-container']//a[contains(text(),'Gift Cards')]")
    private WebElement catalogueGiftCardButton;

    @FindBy(xpath = "//span[contains(@id,'nav-cart-count')]")
    private WebElement amountOfProductInCart;

    @FindBy(xpath = "//span[contains(@id,'nav-cart-count')]")
    private WebElement cartButton;

    @FindBy(xpath = "//input[contains(@data-action,'delete')]")
    private WebElement deleteProductFromCartButton;

    @FindBy(xpath = "//div[contains(@class,'a-row a-size-base a-color-base')]//span")
    private WebElement alertMessageIncorrectSearchInput;

    @FindBy(xpath = "//div[contains(@id,'nav-packard-glow-loc-icon')]")
    private WebElement deliverToButton;

    @FindBy(xpath = "//div[contains(@class,'a-column a-span4 a-span-last')]//input")
    private WebElement applyButton;

    @FindBy(xpath = "//div[contains(@class,'a-column a-span8')]//input")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//span[contains(@class,'GLUX_Hidden')]//div[contains(text(),'Please enter a valid US zip code')]")
    private WebElement alertMessageEnterValidUSZipCode;

    @FindBy(xpath = "//div[@class='a-row']//h1")
    private WebElement alertMessageItemNotAddedToCart;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeywords(String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickCatalogueGiftCardButton() {
        catalogueGiftCardButton.click();
    }

    public String getAmountOfProductInCart() {
        return amountOfProductInCart.getText();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickDeleteProductFromCart() {
        deleteProductFromCartButton.click();
    }

    public String getAlertMessageIncorrectSearchInput() {
        return alertMessageIncorrectSearchInput.getText();
    }

    public void clickDeliverToButton() {

        deliverToButton.click();
    }

    public void clickApplyButton() {
        applyButton.click();
    }

    public void inputZipCode(String keyword) {
        zipCodeInput.sendKeys(keyword, Keys.ENTER);
    }

    public String getAlertMessageEnterValidUSZipCode() {
        return alertMessageEnterValidUSZipCode.getText();
    }

    public String getAlertMessageItemNotAddedToCart() {
        return alertMessageItemNotAddedToCart.getText();
    }
}



