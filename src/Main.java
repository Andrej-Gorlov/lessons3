import Output.Menu;


public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        while (true) {

            int choice = menu.getUserChoice();

            switch (choice) {
                case 1:
                    menu.displaySort();
                    break;
                case 2:
                    menu.displayDiagonalSum();
                    break;
                case 3:
                    menu.displayValueFibonacci();
                    break;
                case 0:
                    menu.setClose(true);
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}