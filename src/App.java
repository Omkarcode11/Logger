import appenders.ConsoleAppender;
import appenders.FileAppender;
import enums.*;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
         Logger logger = Logger.getInstance(LogLevel.INFO);

        logger.addAppender(new ConsoleAppender());
        logger.addAppender(new FileAppender("app.log"));

        logger.info("Application started");
        logger.error("Database connection failed", Map.of("db", "users"));
        
    }
}
