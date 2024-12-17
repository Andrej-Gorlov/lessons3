package Service.Implementations;

import java.util.HashMap;

public class Fibonacci {

    //  индекс числа Фибоначчи / значение число Фибоначчи
    private final HashMap<Integer, Integer> memo = new HashMap<>();

    /**
     * Вычисление числа Фибоначчи.
     *
     * @param n индекс числа Фибоначчи [Если n <= 1, возвращает n (0 или 1)].
     * @return n-е число Фибоначчи.
     * @throws IllegalArgumentException Выход за диапазон значений [int до 2,147,483,647].
     */
    public int calculatingNumber(int n) {

        if (n <= 1)
            return n;

        // предотврщение повторного вычисления
        if (memo.containsKey(n))
            return memo.get(n);

        int result = calculatingNumber(n - 1) + calculatingNumber(n - 2);

        if (result < 0)
            throw new IllegalArgumentException("\n Выход за диапазон значений (возможный диапазон до 2,147,483,647)");

        memo.put(n, result); // Сохраняем вычисленное значение
        return result;
    }
}
