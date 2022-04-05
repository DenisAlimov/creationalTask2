import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    protected int num = 1;
    private static Logger instance = null;

    public void log(String msg) {
        System.out.println("[" + LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("dd.MM.yyyy HH:mm:ss")) + " " + num++ + "] " + msg);
    }

    private static Logger logger;

    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }
}