package Output;

import Service.Implementations.BubbleSort;
import Service.Implementations.Diagonal;
import Service.Implementations.Fibonacci;
import Service.Helpers.RandomArrayGenerator;
import java.util.InputMismatchException;

public class Menu extends BaseMenu{

    private final RandomArrayGenerator _rndArrGen;

    //region get set
    private boolean close = false;
    private boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        if (close)
            cloceScanner(_scn);
    }
    //endregion

   public Menu(){
       _rndArrGen = new RandomArrayGenerator();
    }

    //region сортировка пузырьком
    /**
     * Отображение меню сортировки массива.
     *  Исключения:
     * - InputMismatchException:  Ввод нецелого числа.
     * - NegativeArraySizeException: Ввод отрицательного размера массива.
     * - Exception: обрабатка всех ошибок.
     */
    public void displaySort(){
        try {
            System.out.println("Введите размер массива: ");
            int sizeAr = _scn.nextInt();

            // Генерация случайного массива
            int[] array = _rndArrGen.generateRandomArray(sizeAr);

            // Сортировка массива
            BubbleSort bubbleSort = new BubbleSort();
            int iterationCount = bubbleSort.sort(array);
            //int iterationCount = bubbleSort.sort(array, array.length, 0);

            // Вывод отсортированного массива
            System.out.println("Отсортированный массив:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("\nКоличество итераций: " + iterationCount);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите целое число для размера массива.");
            _scn.next();
        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
    //endregion

    //region Сумма диагоналей массива
    /**
     * Отображение суммы диагоналей двумерного массива.
     *
     * @throws IllegalArgumentException Введенное значение не является целым числом
     *         или если N не положительное число.
     */
    public void displayDiagonalSum() {
        System.out.print("Введите целое число N: ");

        try {
            int N = getUserInput();

            // Создание двумерного массива размером N на N
            int[][] array = _rndArrGen.generateRandom2DArray(N);

            Diagonal diagonalSum = new Diagonal();
            System.out.println("Сумма диагоналей массива: " + diagonalSum.sum(N, array));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    /**
     * Получения целого числа от пользователя.
     *
     * @return корректное целое число
     * @throws IllegalArgumentException если введенное значение не является целым числом
     *         или если число не положительное.
     */
    private int getUserInput() {
        if (!_scn.hasNextInt())
            throw new IllegalArgumentException("Ошибка: введено не целое число.");

        int N = _scn.nextInt();

        if (N <= 0)
            throw new IllegalArgumentException("Ошибка: N должно быть положительным целым числом.");

        return N;
    }
    //endregion

    //region Последовательность чисел Фибоначчи
    /**
     * Выводит последовательности чисел Фибоначчи.
     *
     * @throws InputMismatchException Некорректное значение (не целое число).
     * @throws IllegalArgumentException Отрицательное значение (N).
     */
    public void displayValueFibonacci () {
        try {
            System.out.print("Введите значение N: ");
            int N = _scn.nextInt();

            if (N < 0)
                throw new IllegalArgumentException("Значение N должно быть неотрицательным.");

            System.out.println("Последовательность чисел Фибоначчи до " + N + ":");

            Fibonacci fibonacci = new Fibonacci();
            for (int i = 0; i < N; i++)
                System.out.print(fibonacci.calculatingNumber(i) + " ");

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: Введите целое число.");
            _scn.next();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
    //endregion

}
