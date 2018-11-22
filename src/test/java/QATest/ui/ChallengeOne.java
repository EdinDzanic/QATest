package QATest.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ChallengeOne {
    public static Target CHECKBOX = Target.the("Checkbox").located(By.id("ch1-checkbox"));
    public static Target DROPDOWN = Target.the("Dropdown").located(By.id("ch1-select"));
    public static Target BUTTON_WITH_BLACK_TEXT =
            Target.the("Button with black text").
                    located(By.cssSelector("button[style*='black']"));
    public static Target RUBICON_ICON = Target.the("Rubicon Icon").located(By.id("ch1img"));
}
