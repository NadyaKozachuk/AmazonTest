package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DysonPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//td[contains(@id,'priceblock_ourprice_lbl')]")
    private WebElement priceLable;

    @FindBy(xpath = "//span[contains(@id,'priceblock')]")
    private WebElement priceAmount;

    public DysonPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getPriceLable() {
        return priceLable.getText();
    }

    public String getPriceAmount() {
        return priceAmount.getText();
    }
}
