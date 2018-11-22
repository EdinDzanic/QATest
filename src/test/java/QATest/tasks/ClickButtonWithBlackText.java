package QATest.tasks;

import QATest.ui.ChallengeOne;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ClickButtonWithBlackText implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ChallengeOne.BUTTON_WITH_BLACK_TEXT)
        );
    }
}
