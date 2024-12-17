package Service.Implementations;

public class BubbleSort {

    //region Первый способ сортировки пузырьком
    /**
     * Сортировка массива пузырьком.
     *
     * @param array массив целых чисел.
     * @return количество итераций.
     * @throws NullPointerException если массив равен null
     * @throws IllegalArgumentException если массив пустой
     */
    public int sort(int[] array) {
        // Проверка на null
        if (array == null)
            throw new NullPointerException("Массив не должен быть null.");

        // Проверка на пустой массив
        if (array.length == 0)
            throw new IllegalArgumentException("Массив не должен быть пустым.");

        int iterationCount = 0; // Счетчик итераций
        boolean swapped; // Переменная для отслеживания обменов

        do {
            swapped = false; // Сбрасываем флаг обмена на каждой итерации
            for (int i = 0; i < array.length - 1; i++) {
                iterationCount++;
                if (array[i] > array[i + 1]) {
                    // Обмен элементов
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true; // Устанавливаем флаг, если произошел обмен
                }
            }
        } while (swapped); // Продолжаем, пока были обмены

        return iterationCount; // Возвращаем количество итераций
    }
    //endregion

    //region Втрой способ сортировки пузырьком
    /**
     * Сортировка массива пузырьком (рекурисия).
     *
     * @param array массив целых чисел.
     * @param n размер массива
     * @param iterationCount количество итераций.
     * @return количество итераций.
     * @throws NullPointerException Равен null
     * @throws IllegalArgumentException Пустой или размер массиа (n) не соответствует длине массива
     */
    public int sort(int[] array, int n, int iterationCount) {

        // Проверка на null
        if (array == null)
            throw new NullPointerException("Массив не должен быть null.");

        // Проверка на пустой массив и корректность размера n
        if (n <= 0 || n > array.length)
            throw new IllegalArgumentException("Размер массива должен быть положительным и не превышать длину массива.");

        // Базовый случай: если размер массива равен 1, он уже отсортирован
        if (n == 1)
            return iterationCount;

        // Переменная для отслеживания, произошли ли обмены
        boolean swapped = false;

        // Проход по массиву и обмен соседних элементов при необходимости
        for (int i = 0; i < n - 1; i++) {
            iterationCount++;
            if (array[i] > array[i + 1]) {
                // Обмен элементов
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                swapped = true;
            }
        }

        // Если обменов не было, массив уже отсортирован
        if (!swapped) {
            return iterationCount;
        }
        return sort(array, n - 1, iterationCount);
    }
    //endregion
}
