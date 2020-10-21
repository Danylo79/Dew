package dev.dankom.wrapper;

import dev.dankom.wrapper.logger.LogLevel;
import dev.dankom.wrapper.logger.Logger;
import dev.dankom.wrapper.main.MainClass;
import dev.dankom.wrapper.main.MainClassType;

public class Wrapper extends MainClass {
    public Wrapper() {
        super(MainClassType.NONE);
        Logger.log(LogLevel.IMPORTANT, "Wrapper is up and running!");
    }
}
