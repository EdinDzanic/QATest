package QATest.questions;

import QATest.ui.ChallengeTwoDropdown;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class DropdownSelectedItem implements Question<String> {
    public static Question<String> text() {
        return new DropdownSelectedItem();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ChallengeTwoDropdown.DROPDOWN_BUTTON).viewedBy(actor).asString();
    }
}
