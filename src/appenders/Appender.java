package appenders;

import models.LogMessage;

public interface Appender {
    void append(LogMessage logMessage);
}
