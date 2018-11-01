package QATest.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import QATest.ui.RubiconQAPage;

public class OpenTheWebpage implements Task {

    RubiconQAPage rubiconQAPage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(rubiconQAPage)
        );
    }
}
