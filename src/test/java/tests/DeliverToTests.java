package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DeliverToTests extends BaseTest {
    public static final String EXPECTED_ALERT_MESSAGE_INCORRECT_ZIP_CODE = "Please enter a valid US zip code";
    public static final String INPUT_INCORRECT_US_ZIP_CODE = "02100";
    public static final String INPUT_ZERO_US_ZIP_CODE = "0";

    @Test(priority = 9)
    public void checkAlertMessageWhenChangeYourLocationWithIncorrectZipCodeField() {
        getHomePage().clickDeliverToButton();
        getBasePage().implicitWait(15);
        getHomePage().inputZipCode(INPUT_INCORRECT_US_ZIP_CODE);
        getHomePage().clickApplyButton();
        getBasePage().waitForPageLoadComplete(10);
        assertEquals(getHomePage().getAlertMessageEnterValidUSZipCode(), EXPECTED_ALERT_MESSAGE_INCORRECT_ZIP_CODE);
    }

    @Test(priority = 10)
    public void checkAlertMessageWhenChangeYourLocationWithZeroZipCodeField() {
        getHomePage().clickDeliverToButton();
        getBasePage().implicitWait(35);
        getHomePage().inputZipCode(INPUT_ZERO_US_ZIP_CODE);
        getHomePage().clickApplyButton();
        getBasePage().waitForPageLoadComplete(10);
        assertEquals(getHomePage().getAlertMessageEnterValidUSZipCode(), EXPECTED_ALERT_MESSAGE_INCORRECT_ZIP_CODE);
    }
}
