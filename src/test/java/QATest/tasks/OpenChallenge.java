package QATest.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenChallenge implements Task {

    private final String BASE = "https://enisjahic.github.io/rubiconQA/";
    private final String challenge;

    protected OpenChallenge(String challenge) {
        this.challenge = challenge;
    }

    public static OpenChallenge one() {
        return Instrumented.instanceOf(OpenChallenge.class).withProperties("challengeone.html");
    }

    public static OpenChallenge two() {
        return Instrumented.instanceOf(OpenChallenge.class).withProperties("challengetwo.html");
    }

    public static OpenChallenge three() {
        return Instrumented.instanceOf(OpenChallenge.class).withProperties("challengethree.html");
    }

    @Override
    @Step("{0} opens challenge #challenge")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(BASE + challenge)
        );
    }
}
