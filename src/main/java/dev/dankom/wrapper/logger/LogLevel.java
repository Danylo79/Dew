package dev.dankom.wrapper.logger;

public enum LogLevel {

    INFO("INFO", ""),
    ERROR("ERROR", "\033[31m"),
    FATAL("FATAL", "\033[31m")
    ;

    private final String name;
    private final String color;

    LogLevel(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
}
