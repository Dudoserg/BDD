import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int size;

    private int [][] arr;


    /**
     * Суммирование двух чисел
     * @param firstNum Число кратное 2 (2,4,8,16...)
     * @param secondNum Число кратное 2 (2,4,8,16...)
     * @return сумма двух чисел
     */
    public int add(int firstNum, int secondNum) {
        // todo
        return 4;
    }


    /**
     * Метод по генерации числа для вставки. 2 или 4 с вероятностью 90% и 10% соответственно
     * @return число : 2 или 4 с вероятностью 90% и 10% соответственно
     */
    public int generateNumber() {
        double rand =  Math.random();
        if(rand < 0.1)
            return 4;
        return 2;
    }


    /**
     * Конструктор для создания класса Game.
     * @param size параметр, который задает размер матрицы поля.
     */
    public Game(int size) {
        this.size = size;
        this.initialize();
    }


    /**
     * Конструктор для создания класса Game. Без параметров
     */
    public Game() {
        this.size = 4;
        this.initialize();
    }

    private void initialize(){
        this.arr = new int[this.size][this.size];
    }


    /**
     * Метод для получения размера матрицы
     * @return размер матрицы (int)
     */
    public int getSize() {
        return this.size;
    }


    /**
     * Метод для получения матрицы поля
     * @return массив типа int, размером size*size
     */
    public int[][] getArr() {
        return this.arr;
    }


    /**
     * Устанавливаем элемент матрицы по индексу определенным значением
     * @param indexI индекс i (строки матрицы) нумерация от 0
     * @param indexJ индекс ж (столбец матрицы) нумерация от 0
     * @param elem значение элемента
     */
    public void setElem(int indexI, int indexJ, int elem) {
        this.arr[indexI][indexJ] = elem;
    }


    /**
     * Получаем элемент матрицы по инедксу
     * @param indexI индекс i (строки матрицы) нумерация от 0
     * @param indexJ индекс ж (столбец матрицы) нумерация от 0
     * @return значение элемента по заданному индексу
     */
    public int getElem(int indexI, int indexJ) {
        return this.arr[indexI][indexJ];
    }

    /**
     * Получаем случайным образом индекс свободного места в массиве
     * @return массив int. Первый элемент - строка, второй элемент столбец. Нумерация начинается с 0;
     */
    public int[] findFreePlace() {
        ArrayList<ArrayList<Integer>> freePlace = new ArrayList<>();
        for(int i = 0 ; i < this.size; i++){
            for(int j = 0 ; j < this.size; j++){
                if(this.arr[i][j] == 0){
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    freePlace.add( tmp);
                }
            }
        }
        int sizeFreePlace = freePlace.size();
        //int rand = this.rand(0, sizeFreePlace);
        int rand = new Random().nextInt(freePlace.size());
        return new int[]{freePlace.get(rand).get(0), freePlace.get(rand).get(1)};
    }

    public int rand(int from, int to) {
        return from + (int) (Math.random() * to);
    }
}
