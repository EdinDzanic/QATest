package QATest.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Buttons {
    // This is the button located on the example page
    public static Target EXAMPLE_BUTTON = Target.the("example button").located(By.id("ebtn"));
}
