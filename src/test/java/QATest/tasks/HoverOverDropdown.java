package QATest.tasks;

import QATest.ui.ChallengeTwoDropdown;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Hover;

public class HoverOverDropdown implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Hover.over(ChallengeTwoDropdown.DROPDOWN)
        );
    }
}
