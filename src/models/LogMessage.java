package models;

import enums.*;
import java.time.LocalDateTime;
import java.util.Map;

public class LogMessage {

    private final LocalDateTime timestamp;
    private final LogLevel level;
    private final String message;
    private final String serviceName;
    private final Map<String, String> metaData;

    public LogMessage(LogLevel level, String message, String serviceName,
            Map<String, String> metaData) {
        this.timestamp = LocalDateTime.now();
        this.level = level;
        this.message = message;
        this.serviceName = serviceName;
        this.metaData = metaData;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Map<String, String> getMetaData() {
        return metaData;
    }

}
