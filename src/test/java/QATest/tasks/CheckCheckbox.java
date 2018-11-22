package QATest.tasks;

import QATest.ui.ChallengeOne;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class CheckCheckbox implements Task {

    @Override
    @Step("{0} checks checkbox")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ChallengeOne.CHECKBOX)
        );
    }
}
