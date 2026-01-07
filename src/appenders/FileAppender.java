package appenders;

import java.io.FileWriter;
import java.io.IOException;
import models.LogMessage;

public class FileAppender implements Appender {

    private final String filePath;

    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    public synchronized void append(LogMessage logMessage) {
        try (FileWriter filewriter = new FileWriter(filePath, true)) {
            filewriter.write(formate(logMessage));
            filewriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String formate(LogMessage logMessage) {
        return String.format(
            "[%s] [%s] [%s] %s",
            logMessage.getTimestamp(),
            logMessage.getLevel(),
            logMessage.getServiceName(),
            logMessage.getMessage()
        );
     }

}
