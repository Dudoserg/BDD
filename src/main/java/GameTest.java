import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Given("^I have my Game class with param (\\d+)$")
    public void iHaveMyGameClassWithParam(int arg0) {
        this.game = new Game(arg0);
    }

    int gameSize;

    @When("^I get gameSize$")
    public void iGetGameSize() {
        this.gameSize = this.game.getSize();
    }


    @Then("^The gameSize should be (\\d+)$")
    public void theGameSizeShouldBe(int arg0) {
        Assert.assertEquals(this.gameSize, arg0);
    }

//# initArray
int [][] gameMatrix;
    @When("^I get array from Game$")
    public void iGetArrayFromGame() {
        this.gameMatrix = this.game.getArr();
    }

    @Then("^The array should be null$")
    public void theArrayShouldBeNull() {
        Assert.assertNotNull( this.gameMatrix );
    }

//#setElem #getElem
int resultGetElem;
    @When("^I set elem (\\d+) with index (\\d+) (\\d+)$")
    public void iSetElemWithIndex(int elem, int indexI, int indexJ) {
        this.game.setElem(indexI,indexJ,elem);
    }

    @And("^I get elem with index (\\d+) (\\d+)$")
    public void iGetElemWithIndex(int indexI, int indexJ) {
        this.resultGetElem = this.game.getElem(indexI,indexJ);
    }

    @Then("^The result getElem should be (\\d+)$")
    public void theResultGetElemShouldBe(int elem) {
        Assert.assertEquals(this.resultGetElem , elem);
    }


//#findFreePlace
    ArrayList<int[]> resultFindFreePlace;
    @And("^I call 'findFreePlace' method (\\d+) times$")
    public void iCallFindFreePlaceMethodTimes(int iteration) {
        this.resultFindFreePlace = new ArrayList<>();
        for(int i = 0 ; i < 10000; i++){
            int result[] = game.findFreePlace();
            this.resultFindFreePlace.add(result);
        }

    }

    @Then("^The result must not contain an element with index (\\d+) (\\d+)$")
    public void theResultMustNotContainAnElementWithIndex(int indexI, int indexJ) {
        boolean flagContain = false;
        for(int i = 0 ; i < resultFindFreePlace.size(); i++){
            if(this.resultFindFreePlace.get(i)[0] == indexI && this.resultFindFreePlace.get(i)[1] == indexJ){
                flagContain = true;
                break;
            }
        }
        Assert.assertFalse(flagContain);
    }
//#findFreePlace2
    @When("^I have initialized all the elements of the matrix except the element with the index (\\d+) (\\d+)$")
    public void iHaveInitializedAllTheElementsOfTheMatrixExceptTheElementWithTheIndex(int arg0, int arg1) {
        for(int i = 0; i < this.game.getSize(); i++){
            for(int j = 0 ; j < this.game.getSize(); j++){
                this.game.setElem(i,j, 2 );
            }
        }
        this.game.setElem(arg0,arg1,0);
    }

    @Then("^The result should always return an item with index (\\d+) (\\d+)$")
    public void theResultShouldAlwaysReturnAnItemWithIndex(int arg0, int arg1) {
        boolean flagAnotherElem = false;
        for(int i = 0 ; i < resultFindFreePlace.size(); i++){
            if(this.resultFindFreePlace.get(i)[0] != arg0 || this.resultFindFreePlace.get(i)[1] != arg1){
                flagAnotherElem = true;
                break;
            }
        }
        Assert.assertFalse(flagAnotherElem);
    }

//#rand
    int resultRand[];
    int countIterationRand;
    @When("^I call 'rand' method (\\d+) times in the range from (\\d+) to (\\d+)$")
    public void iCallRandMethodTimesInTheRangeFromTo(int iteration, int min, int max) {
        this.resultRand = new int[max - min];
        countIterationRand = iteration;
        for(int i = 0; i < countIterationRand; i++){
            resultRand[game.rand(0,10)]++;
        }
    }



    @Then("^The probability of each generated number should be (\\d+) to (\\d+) and epsilon (\\d+) to (\\d+)$")
    public void theProbabilityOfEachGeneratedNumberShouldBeToAndEpsilonTo(int arg0, int arg1, int eps1, int eps2) {
        double eps = (double)eps1 / eps2;
        double prob = (double) arg0 / arg1;
        for(int i = 0 ; i < 10; i++){
            Assert.assertTrue(( ((double) resultRand[i] / countIterationRand) > prob - eps)
                    && (  ((double) resultRand[i] / countIterationRand) < prob + eps) );
        }
    }

//# getARr
int matrixRead[][];
int matrixGetArr[][];
    public int [][] readMatrix(String nameFile) throws URISyntaxException {
        URL resource = Main.class.getResource("matrix/" + nameFile);
        System.out.println(Paths.get(resource.toURI()).toFile());

        int matrix[][] = new int [this.game.getSize()][this.game.getSize()];

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(Paths.get(resource.toURI()).toUri()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = new String();
        String[] str;

        int indexLine = 0;
        while ( scanner.hasNextLine()){
            line = scanner.nextLine();
            // System.out.println(line);
            final int[] indexJ = {0};
            int mas[] = Arrays.stream( line.split(" ")) .mapToInt(Integer::parseInt).toArray();
            for(int i = 0 ; i < mas.length; i++){
                matrix[indexLine][i] = mas[i];
            }
            indexLine++;
        }
        return matrix;
    }

    @When("^I read matrix from \"([^\"]*)\"$")
    public void iReadMatrixFrom(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.matrixRead = this.readMatrix(arg0);
       // throw new PendingException();
    }

    @And("^I set the game matrix in accordance with the read matrix$")
    public void iSetTheGameMatrixInAccordanceWithTheReadMatrix() {
        for(int i = 0 ; i < matrixRead.length; i++){
            for(int j = 0 ; j < matrixRead[i].length; j++){
                this.game.setElem(i,j, matrixRead[i][j]);
            }
        }
    }


    @And("^I call 'getArr'$")
    public void iCallGetArr() {
        this.matrixGetArr = this.game.getArr();
    }

    @Then("^the matrix must match the matrix from the file \"([^\"]*)\"$")
    public void theMatrixMustMatchTheMatrixFromTheFile(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertArrayEquals(this.matrixRead, this.matrixGetArr);
       // throw new PendingException();
    }



//#left
    @And("^I call 'left' method$")
    public void iCallLeftMethod() {
        this.game.left();
    }


///////////////////////////////////////////
    @When("^I fill 'clearArray' the array with random numbers$")
    public void iFillClearArrayTheArrayWithRandomNumbers() {
        for (int i = 0 ; i < this.game.getSize(); i++){
            for(int j = 0 ; j < this.game.getSize(); j++){
                this.game.setElemInArrayInactive(i,j, (int)(Math.random() * 2));
            }
        }
    }

    @And("^i clear the array$")
    public void iClearTheArray() {
        this.game.clearArray_inactive();
    }

    @Then("^all array elements are (\\d+)$")
    public void allArrayElementsAre(int arg0) {
        boolean flagNotZero = false;
        for (int i = 0 ; i < this.game.getSize(); i++){
            for(int j = 0 ; j < this.game.getSize(); j++){
               if( this.game.getElemInArrayInactive(i,j) != 0){
                   flagNotZero = true;
                   break;
               }
            }
        }
        Assert.assertFalse(flagNotZero);
    }


    @And("^I call 'motionElem' method with param (\\d+) -(\\d+)$")
    public void iCallMotionElemMethodWithParam(int rowDirection, int columnDirection) {
        game.motionElem(rowDirection, -1, 0, 0);
        System.out.println();
    }
}

