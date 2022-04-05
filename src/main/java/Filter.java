import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        int i = 0;
        List<Integer> result = new ArrayList<>();
        logger.log("Запускаем фильтрацию");
        for (int k : source) {
            if (k < treshold)
                System.out.printf("Элемент \"%d\" не проходит\n", k);
            else {
                System.out.printf("Элемент \"%d\" проходит\n", k);
                result.add(k);
                i++;
            }
        }
        logger.log("Прошло фильтр " + i + " элемента из " + source.size());
        logger.log("Выводим список элементов на экран ");

        System.out.println("Отфильтрованный список " + result);

        return result;
    }
}