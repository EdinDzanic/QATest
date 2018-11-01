package QATest.questions;

import QATest.ui.Buttons;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

@Subject("the text of the example button")
public class ExampleButtonText implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(Buttons.EXAMPLE_BUTTON).viewedBy(actor).asString();

//        or:
//        return BrowseTheWeb.as(actor).find(By.id("ebtn")).getText();
    }
}