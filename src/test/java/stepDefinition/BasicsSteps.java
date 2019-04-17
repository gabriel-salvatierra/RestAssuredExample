package stepDefinition;

import basicsRequests.BasicGET;
import basicsRequests.BasicPOST;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasicsSteps {

    @Given("Everything is set up")
    public void everything_is_set_up() {
        System.out.println("Everything set up");
    }

    @When("Test is run")
    public void test_is_run() {
        System.out.println("Actually is run in next step");
    }

    @Then("GET Response is successful")
    public void get_Response_is_successful() {
        BasicGET.BasicGETMethod();
        System.out.println("BasicGET.BasicGETMethod() method run OK");
    }

    @Then("POST response is successful")
    public void post_response_is_successful() {
        BasicPOST.BasicPOSTMethod();
        System.out.println("BasicPOST.BasicPOSTMethod() method run OK");
    }
}
