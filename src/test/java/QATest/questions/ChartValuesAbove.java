package QATest.questions;

import QATest.ui.Chart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

@Subject("The chart values above the bars")
public class ChartValuesAbove implements Question<List<Integer>> {

    public static Question<List<Integer>> are() {
        return new ChartValuesAbove();
    }

    @Override
    public List<Integer> answeredBy(Actor actor) {
        return Text.of(Chart.CHART_VALUES).viewedBy(actor).asListOf(Integer.class);
    }
}
