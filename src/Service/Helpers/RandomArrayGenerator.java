package Service.Helpers;

import java.util.Random;

public class RandomArrayGenerator {

    private final Random _rnd;

    public RandomArrayGenerator() {
        _rnd = new Random();
    }

    // Генерация массива случайными числами.
    public int[] generateRandomArray(int sizeAr) {
        int[] array = new int[sizeAr];
        for (int i = 0; i < array.length; i++) {
            array[i] = _rnd.nextInt(100 ); // Заполнение массива случайными числами
        }
        return array;
    }

    // Генерация двумерного массива размером N x N.
    public int[][] generateRandom2DArray(int N) {
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = _rnd.nextInt(100); // случайные числа от 0 до 99
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }
}
