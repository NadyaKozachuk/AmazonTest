package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class AddToCartTests extends BaseTest {
    private static final String EXPECTED_ALERT_MESSAGE_WHEN_ADD_TO_CART_EGIFT_CARD_WITH_EMPTY_REQUARED_FIELDS = "Please enter an email address";
    private static final String EXPECTED_ADDED_PRODUCT_COUNT_IN_CART = "1";
    private static final String EXPECTED_DELETED_PRODUCT_COUNT_IN_CART = "0";
    public static final String SEARCH_RESULT_ELECTRONICS = "dyson";
    public static final String SEARCH_KEYWORD_ELECTRONICS = "dyson hairdryer";
    public static final String SEARCH_KEYWORD_BOOKS = "thinking in java";
    public static final String EXPECTED_ALERT_MESSAGE_ITEM_NOT_ADDED = "Not added";


    @Test(priority = 5)
    public void checkAddItemToCart() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD_BOOKS);
        getSearchResultPage().clickOnProductDescriptionBookThinkingInJava();
        getBasePage().implicitWait(40);
        getThinkingInJavaPage().clickOnAddToCartButton();
        assertEquals(getHomePage().getAmountOfProductInCart(), EXPECTED_ADDED_PRODUCT_COUNT_IN_CART);
    }

    @Test(priority = 6)
    public void checkAlertMessageWhenAddToCartGiftCardWithEmptyRequiredFields() {
        getHomePage().clickCatalogueGiftCardButton();
        getGiftCardsPage().clickEgiftCatalogueButton();
        getGiftCardsPage().clickAddToCartButton();
        getBasePage().implicitWait(40);
        getGiftCardsPage().getAlertMessageEgiftCard();
        String AlertMessage = getGiftCardsPage().getAlertMessageEgiftCard();
        assertTrue(AlertMessage.contains(EXPECTED_ALERT_MESSAGE_WHEN_ADD_TO_CART_EGIFT_CARD_WITH_EMPTY_REQUARED_FIELDS));
    }

    @Test(priority = 7)
    public void checkRemoveItemFromCart() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD_ELECTRONICS);
        getSearchResultPage().clickOnProductDescription();
        getBasePage().implicitWait(40);
        getDysonPage().clickAddToCartButton();
        getBasePage().implicitWait(30);
        assertEquals(getHomePage().getAmountOfProductInCart(), EXPECTED_ADDED_PRODUCT_COUNT_IN_CART);
        getBasePage().implicitWait(40);
        getHomePage().clickCartButton();
        getHomePage().waitForPageLoadComplete(30);
        getHomePage().clickDeleteProductFromCart();
        getBasePage().implicitWait(40);
        assertEquals(getHomePage().getAmountOfProductInCart(), EXPECTED_DELETED_PRODUCT_COUNT_IN_CART);
    }

    @Test(priority = 8)
    public void checkAlertMessageWhenAddToCartMoreItemsThanInStock() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD_BOOKS);
        getSearchResultPage().clickOnProductDescriptionBookThinkingInJava();
        getBasePage().implicitWait(40);
        getThinkingInJavaPage().clickOnAddToCartButton();
        assertEquals(getHomePage().getAmountOfProductInCart(), EXPECTED_ADDED_PRODUCT_COUNT_IN_CART);
        getHomePage().searchByKeywords(SEARCH_KEYWORD_BOOKS);
        getSearchResultPage().clickOnProductDescriptionBookThinkingInJava();
        getThinkingInJavaPage().clickOnAddToCartButton();
        getBasePage().implicitWait(40);
        String AlertMessage = getHomePage().getAlertMessageItemNotAddedToCart();
        assertTrue(AlertMessage.contains(EXPECTED_ALERT_MESSAGE_ITEM_NOT_ADDED));
    }
}
