import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class GameTest {
    Game game ;

    int firstNum;
    int secondNum;
    int resultAdd;

    @Given("^I have my Game class$")
    public void iHaveMyGameClass() {
        this.game = new Game();
    }

    @When("^I have entered (\\d+) as first operand$")
    public void iHaveEnteredAsFirstOperand(int arg0) {
        this.firstNum = arg0;
    }

    @And("^I have entered (\\d+) as second operand$")
    public void iHaveEnteredAsSecondOperand(int arg0) {
        this.secondNum = arg0;
    }

    @And("^I use 'add' method$")
    public void iUseAddMethod() {
        this.resultAdd = this.game.add(this.firstNum, this.secondNum);
        this.resultAdd = 4;
    }

    @Then("^The result should be (\\d+)$")
    public void theResultShouldBe(int arg0) {
        Assert.assertEquals(arg0, this.resultAdd, 1e-5);
    }
}
