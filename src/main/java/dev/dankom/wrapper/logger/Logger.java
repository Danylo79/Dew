package dev.dankom.wrapper.logger;

import dev.dankom.wrapper.config.Config;
import org.json.simple.JSONArray;

import java.awt.*;

public class Logger {

    private static LogLevel logLevel;

    public Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public static void log(LogLevel loggingLevel, String msg) {
        setLogLevel(loggingLevel);
        run(msg);
    }

    public void log(String msg) {
        run(msg);
    }

    private static void run(String msg) {
        JSONArray filteredLogLevels = (JSONArray) Config.getInstance().getConfig().get("FilteredLogLevels");
        if (!filteredLogLevels.contains(logLevel.getName())) {
            System.out.println(getLogLevel().getColor() + "[" + getLogLevel().getName() + "] " + msg);
        }
    }

    private static LogLevel getLogLevel() {
        return logLevel;
    }

    private static void setLogLevel(LogLevel logLevel) {
        Logger.logLevel = logLevel;
    }
}
