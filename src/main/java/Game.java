
public class Game {

    private int size;


    public int add(int firstNum, int secondNum) {
        // todo
        return 4;
    }

    public int generateNumber() {
        double rand =  Math.random();
        if(rand < 0.1)
            return 4;
        return 2;
    }

    public Game(int size) {
        this.size = size;
    }

    public Game() {
        this.size = 4;
    }

}
