import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GameTest {
    Game game ;
    @Given("^I have my Game class$")
    public void iHaveMyGameClass() {
        this.game = new Game();
    }

    @When("^I have entered (\\d+) as first operand$")
    public void iHaveEnteredAsFirstOperand(int arg0) {
    }

    @And("^I have entered (\\d+) as second operand$")
    public void iHaveEnteredAsSecondOperand(int arg0) {
    }

    @And("^I use 'add' method$")
    public void iUseAddMethod() {

    }

    @Then("^The result should be (\\d+)$")
    public void theResultShouldBe(int arg0) {
    }
}
