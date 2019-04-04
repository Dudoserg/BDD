
public class Game {

    private int size;

    private int [][] arr;

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
        this.initialize();
    }

    public Game() {
        this.size = 4;
        this.initialize();
    }

    private void initialize(){
        this.arr = new int[this.size][this.size];
    }

    public int getSize() {
        return this.size;
    }


    public int[][] getArr() {
        return this.arr;
    }
}
