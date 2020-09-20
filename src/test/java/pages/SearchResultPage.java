package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[contains(@class,'a-section a-spacing-medium')]//span[contains(text(),'Dyson Supersonic Hair Dryer, White/Silver')]")
    private WebElement productDescription;

    @FindBy(xpath = "//span[contains(text(),'Thinking in Java (4th Edition')]")
    private WebElement productDescriptionBookThinkingInJava;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public void clickOnProductDescription() {
        productDescription.click();
    }

    public void clickOnProductDescriptionBookThinkingInJava() {
        productDescriptionBookThinkingInJava.click();
    }
}

