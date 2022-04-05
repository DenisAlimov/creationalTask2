import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        System.out.println("Введите размер списка: ");

        int N = numCheck();

        logger.log("Размер списка пользователя: " + N);


        System.out.println("Введите верхнюю границу для значений: ");

        int M = numCheck();

        logger.log("Верхняя граница для значений: " + M);

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>(N);
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            list.add(random.nextInt(M));
        }

        System.out.println("Вот случайный список: " + list);
        System.out.println("Введите порог для фильтра: ");

        int f = numCheck();

        Filter filter = new Filter(f);
        filter.filterOut(list);
        logger.log("Завершаем программу");
    }

    public static int numCheck() {
        Logger logger = Logger.getInstance();
        String scan = null;
        int num = 0;
        do {
            scan = sc.next();
            if (!isNumeric(scan))
                logger.log("Вы ввели не число, введите число!");
            if (isNumeric(scan)) {
                num = Integer.parseInt(scan);
                if (num < 0)
                    logger.log("Введенное число некорректно, оно должно быть больше нуля!");
            }
        } while (!isNumeric(scan) | num < 0);
        return num;
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        try {
            int i = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}