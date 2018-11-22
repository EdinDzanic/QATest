package QATest.questions;

import QATest.ui.Chart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Attribute;

import java.util.List;

@Subject("Is the Chart Color equal to #color")
public class ChartBarColor implements Question<Boolean> {

    private String color;

    public ChartBarColor(String color) {
        this.color = color;
    }

    public static Question<Boolean> is(String color) {
        return new ChartBarColor(color);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // each bar in the chart might have a different color
        // that is why we need to check every color
        List<String> colors = Attribute.of(Chart.CHART_BAR_COLORS).named("fill").viewedBy(actor).asList();
        return colors.stream().allMatch(color -> color.equals(this.color));
    }
}
