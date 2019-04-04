import java.util.ArrayList;
import java.util.Random;

public class Game {

    private int size;

    private int [][] arr;

    private int array_inactive[][];

    /**
     * Суммирование двух чисел
     * @param firstNum Число кратное 2 (2,4,8,16...)
     * @param secondNum Число кратное 2 (2,4,8,16...)
     * @return сумма двух чисел
     */
    public int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
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

        for(int i = 0 ; i < size; i++)
            for(int j = 0 ; j < size; j++)
                this.arr[i][j] = 0;

        this.array_inactive = new int[size][size];
        for(int i = 0 ; i < size; i++)
            for(int j = 0 ; j < size; j++)
                this.array_inactive[i][j] = 0;
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


    public boolean left() {
        // todo
        this.arr = new int [][]{
                {16,8,0,0},
                {2,0,0,0},
                {4,0,0,0},
                {0,0,0,0},
        };
        return true;
    }



    public void setElemInArrayInactive(int i, int j, int i1) {
        this.array_inactive[i][j] = i1;
    }

    public void clearArray_inactive() {
        for(int i = 0 ; i < size; i++)
            for(int j = 0 ; j < size; j++)
                this.array_inactive[i][j] = 0;
    }

    public int getElemInArrayInactive(int i, int j) {
        return this.array_inactive[i][j];
    }

    public boolean motionElem(int vectX, int vectY, int i, int j) {
        try {
            if(this.arr[i][j] == 0){        //Если сдвигаемый элемент равен нулю, то ничего не делаем
                return false;
            }
            // Если в стороне сдвига пустой элемент
            if(this.arr[i + vectX][j + vectY] == 0){
                this.arr[i + vectX][j + vectY] = this.arr[i][j]; // Присваиваем пустому элементу значение текущего
                this.arr[i][j] = 0;                         // Текущий элемент теперь равен нулю
                // Теперь опять двигаем элемент(теперь уже под новым индексом) Мб он еще сдвинется
                this.motionElem(vectX, vectY, i + vectX, j + vectY);
                return true;
            }
            // Если равны, и элемет в стороне сдвига активен, то сдвигаем
            if(this.arr[i + vectX][j + vectY] == this.arr[i][j]  && this.array_inactive[i + vectX][j + vectY] == 0){

                // Суммируем элементы, и присваиваем значение элементу в сторону которого идет сдвиг
                this.arr[i + vectX][j + vectY] = this.add( this.arr[i + vectX][j + vectY],  this.arr[i][j ]);
                // Текущий элемент теперь равен нулю
                this.arr[i][j] = 0;

                // Делаем элемент, к которому прибавили число неактивным. ДАЛЕЕ ОН НЕ МОЖЕТ ПРИНЯТЬ УЧАСТИЕ В СЛОЖЕНИИ С ДРУГИМИ ЧИСЛАМИ
                this.array_inactive[i + vectX][j + vectY] = 1;
                return true;
            }
            return false;


        }catch (ArrayIndexOutOfBoundsException ex){
            return false;

        }
    }
}
