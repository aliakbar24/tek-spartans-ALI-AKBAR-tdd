package tekTdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import tekTdd.page.HomePage;
import tekTdd.page.SignInPage;
import tekTdd.page.SignUpPage;
import tekTdd.utility.SeleniumUtility;

public class UIBaseClass extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(UIBaseClass.class);

    public HomePage homePage;
    public SignInPage signInPage;
    public SignUpPage signUpPage;
    public AccountProfilePage accountProfilePage;

    @BeforeMethod
    public void setupTests() {
        LOGGER.info("Setup Test and opening browser");
        setupBrowser();
        homePage = new HomePage();
        signInPage = new SignInPage();
        signUpPage = new SignUpPage();
        accountProfilePage = new AccountProfilePage();
    }

    @AfterMethod
    public void testCleanup(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            String shot = screenshot.getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest()
                    .fail("Test Failed Taking screen shot" ,
                            MediaEntityBuilder.createScreenCaptureFromBase64String(shot).build());
        LOGGER.info("running after each test and quite browser");
        quitBrowser();
    }
    public void validCredentialSignIn() {
        clickOnElement(homePage.signInLink);
        signInPage.doSignIn("ali.akbar@gmail.com" , "Password@123");
    }

}
