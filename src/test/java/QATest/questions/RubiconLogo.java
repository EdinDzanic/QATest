package QATest.questions;

import QATest.ui.ChallengeOne;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Visibility;

@Subject("The visibility of the Rubicon Icon")
public class RubiconLogo implements Question<Boolean> {

    public static Question<Boolean> presented() {
        return new RubiconLogo();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ChallengeOne.RUBICON_ICON).viewedBy(actor).asBoolean();
    }
}
