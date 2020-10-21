package dev.dankom.dew.logger;

import dev.dankom.dew.util.Color;

public enum LogLevel {

    INFO("INFO", Color.ANSI_YELLOW),
    ERROR("ERROR", Color.ANSI_RED),
    FATAL("FATAL", Color.ANSI_RED),
    IMPORTANT("IMPORTANT", Color.ANSI_MAGENTA)
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
