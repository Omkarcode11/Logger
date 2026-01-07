package enums;

public enum LogLevel {
    INFO(1),
    DEBUG(2),
    WARN(3),
    ERROR(4);

    private  final int priority;

    LogLevel(int priority){
        this.priority = priority;
    }

    public int getPrority(){
        return priority;
    }
}
