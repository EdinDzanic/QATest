package QATest.questions;

import QATest.ui.Chart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

@Subject("The values of the Y axis labels")
public class YAxisLabels implements Question<List<String>> {
    public static Question<List<String>> are() {
        return new YAxisLabels();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(Chart.Y_AXIS_LABELS).viewedBy(actor).asList();
    }
}
