package QATest.questions;

import QATest.ui.Chart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

@Subject("The values of the X axis labels")
public class XAxisLabels implements Question<List<String>> {
    public static Question<List<String>> are() {
        return new XAxisLabels();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(Chart.X_AXIS_LABELS).viewedBy(actor).asList();
    }
}
