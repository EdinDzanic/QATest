package QATest.features;

import QATest.questions.ExampleButtonText;
import QATest.tasks.ExampleButton;
import QATest.tasks.OpenTheWebpage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class Challenges {

    Actor user = Actor.named("User");

    @Managed(uniqueSession = true)
    public WebDriver browser;

    @Steps
    OpenTheWebpage openTheWebpage;

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
}