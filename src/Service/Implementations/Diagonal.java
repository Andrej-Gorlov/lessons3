package Service.Implementations;

public class Diagonal {

    /**
     * Сумма диагоналей двухмерного массива.
     *
     * @param N размер двухмерного массива(количество строк и столбцов).
     * @param array двумерный массив.
     * @return сумма диагоналей двухмерного массива.
     * @throws IllegalArgumentException равен null, размер N меньше или равен 0, или размер массива не соответствует N.
     */
    public int sum(int N, int[][] array) {
        if (array == null || N <= 0 || array.length != N)
            throw new IllegalArgumentException("Некорректный размер массива");

        int diagonalSum = 0;

        for (int i = 0; i < N; i++) {
            diagonalSum += array[i][i]; // Главная диагональ
            if (i != N - 1 - i) { // Центральный элемент
                diagonalSum += array[i][N - 1 - i]; // Побочная диагональ
            }
        }
        return diagonalSum;
    }
}
