package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SearchTests extends BaseTest {

    public static final String SEARCH_KEYWORD_ELECTRONICS = "dyson hairdryer";
    public static final String EXPECTED_SEARCH_QUERY = "dyson";
    public static final String SEARCH_RESULT_ELECTRONICS = "dyson";
    public static final String SEARCH_KEYWORD_BOOKS = "thinking in java";
    public static final String SEARCH_WORD_BOOKS = "java";
    public static final String SEARCH_KEYWORD_INCORRECT_INPUT = "ZzDiZ8VQmaPxc3z111";
    public static final String PRICE_LABLE = "Price:";
    public static final String PRICE_AMOUNT = "$399.99";
    public static final String ALERT_MESSAGE_INCORRECT_INPUT = "Try checking your spelling or use more general terms";
    public static final String EXPECTED_HOME_PAGE_TITLE = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

    @Test(priority = 11)
    public void verifyWebsiteTitle() {
        assertTrue(getDriver().getTitle().contains(EXPECTED_HOME_PAGE_TITLE));
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD_ELECTRONICS);
        getBasePage().implicitWait(30);
        assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_SEARCH_QUERY));
    }

    @Test(priority = 2)
    public void searchResultContainsSearchWord() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD_BOOKS);
        getBasePage().implicitWait(10);
        for (WebElement webElement : getSearchResultPage().getProductList()) {
            assertTrue(webElement.getText().contains(SEARCH_WORD_BOOKS));
        }
    }

    @Test(priority = 3)
    public void checkItemCardHasPriceBadgeAndPriceAmount() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD_ELECTRONICS);
        getBasePage().waitForPageLoadComplete(30);
        getSearchResultPage().clickOnProductDescription();
        getBasePage().implicitWait(40);
        assertEquals(getDysonPage().getPriceLable(), PRICE_LABLE);
        assertEquals(getDysonPage().getPriceAmount(), PRICE_AMOUNT);
    }

    @Test(priority = 4)
    public void checkAlertMessageWhenEnterIncorrectWordInSearchField() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD_INCORRECT_INPUT);
        getBasePage().implicitWait(30);
        String AlertMessage = getHomePage().getAlertMessageIncorrectSearchInput();
        assertTrue(AlertMessage.contains(ALERT_MESSAGE_INCORRECT_INPUT));
    }
}
