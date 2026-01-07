package appenders;

import models.LogMessage;

public class ConsoleAppender implements Appender {

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formateMessage(logMessage));
    }

    public String formateMessage(LogMessage logMessage) {
        return String.format(
                "[%s] [%s] [%s] %s",
                logMessage.getTimestamp(),
                logMessage.getLevel(),
                logMessage.getServiceName(),
                logMessage.getMessage()
        );
    }

}
