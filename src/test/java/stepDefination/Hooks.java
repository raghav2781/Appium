package stepDefination;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	TestContext testContext;


	 


    public Hooks(TestContext context) {

        testContext = context;

    }


 


    @Before

    public void beforeScenario(Scenario scenario) {

        Reporter.assignAuthor("Sudeep Rana");

    }


 


    


 


    @After(order = 1)

    public void afterScenario(Scenario scenario) {

    }


 


    @After(order = 0)

    public void AfterSteps() {

    }

}
