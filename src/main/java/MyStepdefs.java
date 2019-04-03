import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

    private Calculator calc;

    @Given("^I have my software calculator$")
    public void iHaveMySoftwareCalculator() {
        this.calc = new Calculator();
    }

    @When("^I have entered (\\d+) as first operand$")
    public void iHaveEnteredAsFirstOperand(int arg0) {
    }

    @And("^I have entered (\\d+) as second operand$")
    public void iHaveEnteredAsSecondOperand(int arg0) {
    }

    @And("^I press 'Add'$")
    public void iPressAdd() {

    }

    @Then("^The result should be (\\d+)$")
    public void theResultShouldBe(int arg0) {
    }
}
