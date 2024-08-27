package tekTdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tekTdd.base.UIBaseClass;

public class BasicSetupTest {
    import org.openqa.selenium.By;
    import org.testng.Assert;
    import org.testng.annotations.Test;
    import tekTdd.base.UIBaseClass;
    import tekTdd.page.HomePage;

    public class BasicSetupTest extends UIBaseClass {

        private void validateLogo() {
            String actualLogoText = getElementText(homePage.topLeftLogo);
            Assert.assertEquals(actualLogoText, "TEKSCHOOL",
                    "Logo text should match");
        }

        @Test
        public void validateTopLeftCornerLogo() {
            validateLogo();
        }

        /* Activity
        Navigate to retail app and make sure top-left corner text in TEKSCHOOL
        And make sure Sign in button is enabled.
         */
        @Test
        public void testingLoginButtonAndLogo() {
            validateLogo();
            boolean isEnabled = isElementEnabled(homePage.signInLink);
            Assert.assertTrue(isEnabled, "Sign in button should be enabled");
        }

    }
}
