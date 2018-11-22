package QATest.features;

import QATest.questions.*;
import QATest.tasks.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SerenityRunner.class)
public class Challenges {

    Actor user = Actor.named("User");

    @Managed(uniqueSession = true)
    public WebDriver browser;

    @Steps
    OpenTheWebpage openTheWebpage;

    @Steps
    CheckCheckbox checkCheckbox;

    @Steps
    ClickButtonWithBlackText clickButtonWithBlackText;

    @Steps
    HoverOverDropdown hoverOverDropdown;

    @Before
    public void canBrowseTheWeb() {
        user.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void exampleTest() {

        givenThat(user).wasAbleTo(openTheWebpage);

        when(user).attemptsTo(ExampleButton.click());

        then(user).should(eventually(seeThat(new ExampleButtonText(), equalTo("Clicked."))));
    }

    @Test
    public void scenario1() {
        givenThat(user).wasAbleTo(OpenChallenge.one());

        when(user).attemptsTo(checkCheckbox);
        and(user).attemptsTo(SetDropdownValue.to("Java"));
        and(user).attemptsTo(clickButtonWithBlackText);

        then(user).should(seeThat(RubiconLogo.presented(), is(true)));
    }

    @Test
    public void scenario2() {
        givenThat(user).wasAbleTo(OpenChallenge.two());

        when(user).attemptsTo(hoverOverDropdown);
        and(user).attemptsTo(ClickOnDropdown.item("QA Engineer"));

        then(user).should(seeThat(DropdownSelectedItem.text(), is("QA Engineer")));
    }

    @Test
    public void scenario3() {
        List<Integer> expectedChartValues = Arrays.asList(30, 12, 37, 17, 18, 40, 47, 43, 32, 6);
        List<String> expectedYAxisLabels = Arrays.asList("0", "10", "20", "30", "40", "50");
        List<String> lastTenWorkingDays = getLastTenWorkingDays();
        final String EXPECTED_COLOR = "#7cb5ec"; // rgb(124, 181, 236)

        givenThat(user).wasAbleTo(OpenChallenge.three());

        then(user).should(seeThat(ChartValuesAbove.are(), equalTo(expectedChartValues)));
        and(user).should(seeThat(YAxisLabels.are(), equalTo(expectedYAxisLabels)));

        // this part will always fail because the x axis will have the last 10 days
        // not including Friday and Saturday, and the labels are in the wrong format
        and(user).should(seeThat(XAxisLabels.are(), equalTo(lastTenWorkingDays)));

        // this part can fail if the mouse is hovered over a chart bar during the test
        and(user).should(seeThat(ChartBarColor.is(EXPECTED_COLOR), is(true)));
    }

    private List<String> getLastTenWorkingDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM YYYY");
        LocalDateTime day = LocalDateTime.now();
        int howManyDays = 10;

        List<String> result = new ArrayList<>();
        while (howManyDays > 0) {
            boolean isWorkDay = !day.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                    && !day.getDayOfWeek().equals(DayOfWeek.SUNDAY);
            if (isWorkDay) {
                result.add(0, day.format(formatter));
                howManyDays--;
            }
            day = day.minusDays(1);
        }

        return result;
    }
}