package util;

public enum LoggerLevel {

	DEBUG(0),
	LOG(1),
    WARNING(2),
    ERROR(3),
    FATAL(4);

    private Integer severity;

    LoggerLevel(int severity) {
        this.severity = severity;
    }

    public boolean shouldPrint(LoggerLevel other) {
        return this.severity <= other.severity;
    }
}