package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThinkingInJavaPage extends BasePage {
    @FindBy(xpath = "//input[@id='add-to-cart-button-ubb']")
    private WebElement addToCartButton;

    public ThinkingInJavaPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }
}
