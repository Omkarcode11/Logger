
import appenders.*;
import enums.*;
import java.util.*;
import models.LogMessage;

public class Logger {

    private static Logger instance;

    private LogLevel currLevel;
    private List<Appender> appenders;

    private Logger(LogLevel level) {
        this.currLevel = level;
        this.appenders = new ArrayList<>();
    }

    public static synchronized Logger getInstance(LogLevel level) {
        if (instance == null) {
            return new Logger(level);
        }

        return instance;
    }

    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    public void setLogLevel(LogLevel level) {
        this.currLevel = level;
    }

    public void info(String message) {
        log(currLevel, message, null);
    }

    public void error(String message, Map<String, String> errors) {
        log(LogLevel.ERROR, message, errors);
    }

    public void log(LogLevel level, String message, Map<String, String> metadata) {
        if (level.getPrority() < currLevel.getPrority()) {
            return;
        }

        LogMessage logMessage = new LogMessage(level, message, message, metadata);

        for (Appender appender : appenders) {
            appender.append(logMessage);
        }
    }

}
