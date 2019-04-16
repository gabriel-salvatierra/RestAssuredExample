package stepDefinition;

import basics.Basics1;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Basics1Steps {

    @Given("Everything is set up")
    public void everything_is_set_up() {
        System.out.println("Everything set up");
    }

    @When("Test is run")
    public void test_is_run() {
        System.out.println("Actually is run in next step");
    }

    @Then("Response is successful")
    public void response_is_successful() {
        Basics1.Test();
        System.out.println("Basics1.Test() method run OK");
    }
}
