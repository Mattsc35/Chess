package util;

public enum LoggerLevel {

	LOG(0),
	DEBUG(2),
    WARNING(4),
    ERROR(6),
    FATAL(8);

    private Integer severity;

    LoggerLevel(int severity) {
        this.severity = severity;
    }

    public boolean shouldPrint(LoggerLevel other) {
        return this.severity <= other.severity;
    }
}