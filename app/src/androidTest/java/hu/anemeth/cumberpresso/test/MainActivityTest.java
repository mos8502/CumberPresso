package hu.anemeth.cumberpresso.test;




import android.test.ActivityInstrumentationTestCase2;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
//import cucumber.api.android.CucumberInstrumentation;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import hu.anemeth.cumberpresso.MainActivity;
import hu.anemeth.cumberpresso.R;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;

/**
 * Created by nemi on 2015.01.16..
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "features")
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setup() {
        getActivity();
    }

    @When("^I enter message \"(.*?)\"$")
    public void i_enter_message(String message) {
        onView(withId(R.id.message_text)).perform(typeText(message));
    }

    @Then("^I click button with text \"(.+)\"$")
    public void i_click_button_labeled(String buttonText) {
        onView(withText(buttonText)).perform(click());
    }

    @Then("^I see dialog with message \"(.*?)\"$")
    public void i_see_dialog_with_message(String message) {
        onView(withId(android.R.id.message)).check(matches(withText(message)));
    }
}
