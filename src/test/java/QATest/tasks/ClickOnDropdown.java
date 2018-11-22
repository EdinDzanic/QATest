package QATest.tasks;

import QATest.ui.ChallengeTwoDropdown;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hover;
import net.serenitybdd.screenplay.targets.Target;

public class ClickOnDropdown implements Task {

    private final String position;

    protected ClickOnDropdown(String position) {
        this.position = position;
    }

    public static ClickOnDropdown item(String position) {
        return Instrumented.instanceOf(ClickOnDropdown.class).withProperties(position);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target item = ChallengeTwoDropdown.getItem(position);
        actor.attemptsTo(
                Hover.over(item),
                Click.on(item)
        );
    }
}
