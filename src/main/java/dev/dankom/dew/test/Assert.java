package dev.dankom.dew.test;

import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;

public class Assert {
    private String assertName;
    private Object value;
    private Object actual;

    public Assert(String assertName, Object value, Object actual) {
        this.assertName = assertName;
        this.value = value;
        this.actual = actual;

        if (value == actual) {
            Logger.log(LogLevel.TEST, assertName + " has passed!");
        } else {
            Logger.log(LogLevel.FATAL, assertName + " has failed!");
        }
    }

    public boolean passed() {
        return value == actual;
    }
}
