package QATest.tasks;

import QATest.ui.ChallengeOne;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SetDropdownValue implements Task {

    private final String language;

    protected SetDropdownValue(String language) {
        this.language = language;
    }

    public static SetDropdownValue to(String language) {
        return Instrumented.instanceOf(SetDropdownValue.class).withProperties(language);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byVisibleText(language).from(ChallengeOne.DROPDOWN)
        );
    }
}
