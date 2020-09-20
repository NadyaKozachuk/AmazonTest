package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'bxc-grid__container')]//a[contains(@aria-label,'eGift')]")
    private WebElement eGiftcatalogueButton;

    @FindBy(xpath = "//input[@id='gc-buy-box-atc']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='a-box-inner a-alert-container']//div[contains(text(),'Please enter an email address')]")
    private WebElement alertMessageEgiftCard;

    public GiftCardsPage(WebDriver driver) {
        super(driver);
    }

    public void clickEgiftCatalogueButton() {
        eGiftcatalogueButton.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getAlertMessageEgiftCard() {
        return alertMessageEgiftCard.getText();
    }
}
