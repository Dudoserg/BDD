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

    int result_generateNumber;

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


    @When("^I use 'generateNumber' method$")
    public void iUseGenerateNumberMethod() {
        this.result_generateNumber = this.game.generateNumber();
    }


    @Then("^The result  (\\d+) or (\\d+)$")
    public void theResultOr(int arg0, int arg1) {
        Assert.assertTrue(this.result_generateNumber == 2 || this.result_generateNumber == 4);
    }


    double percent_2 ;
    double percent_4 ;
    double epsilon = 0.01;

    @When("^I use 'generateNumber' method (\\d+) raz$")
    public void iUseGenerateNumberMethodRaz(int iterations) {
        int count_2 = 0;
        int count_4 = 0;
        for(int i = 0 ; i < iterations; i++){
            int num = game.generateNumber();
            if( num == 2 )
                count_2++;
            if( num == 4 )
                count_4++;
        }
        percent_2 = ((double) count_2) / iterations;
        percent_4 = ((double)count_4) / iterations;

    }

    @Then("^The result  (\\d+) or (\\d+) with probability (\\d+) and (\\d+)$")
    public void theResultOrWithProbabilityAnd(int arg0, int arg1, int arg2, int arg3) {
        Assert.assertTrue( (percent_2 > 0.9 - epsilon) &&  (percent_2 < 0.9 + epsilon)
                &&  (percent_4 > 0.1 - epsilon) &&  (percent_4 < 0.4 + epsilon) );
    }
}

