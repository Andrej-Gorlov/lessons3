package Output;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class BaseMenu {

    protected final Scanner _scn;
    public BaseMenu(){
        _scn = new Scanner(System.in);
    }

    public void displaySort(){}
    public void displayDiagonalSum() {}
    public void displayValueFibonacci (){}
    protected void  cloceScanner(Scanner _scn){
        _scn.close();
    }

    /**
     * Выбор меню пользователя.
     *
     * @return целое число.
     */
    public int getUserChoice (){
        try {
            menuDefault();
            return _scn.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введите целое число.");
            _scn.next(); // Очистка неверного ввода
        }
        return  0;
    }

    // Выбор меню по умолчанию.
    private  void menuDefault(){
        System.out.println("\n 1) Сортировки массива пузырьком");
        System.out.println(" 2) Сумма диагоналей массива");
        System.out.println(" 3) Последовательность чисел Фибоначчи");
        System.out.println(" 0) Выход \n");
    }
}
