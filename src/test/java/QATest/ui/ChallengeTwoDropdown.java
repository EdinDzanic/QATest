package QATest.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ChallengeTwoDropdown {
    public static Target DROPDOWN =
            Target.the("Dropdown").located(By.cssSelector(".dropdown"));
    public static Target DROPDOWN_BUTTON =
            Target.the("Dropdown Button").locatedBy(".dropbtn");

    public static Target getItem(String value) {
        String xpath = "//a[contains(text(), '" + value + "')]";
        return Target.the("Dropdown item " + value).locatedBy(xpath);
    }
}

