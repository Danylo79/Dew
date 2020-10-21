package dev.dankom.dew;

import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import dev.dankom.dew.main.MainClass;
import dev.dankom.dew.main.MainClassType;

public class Wrapper extends MainClass {
    public Wrapper() {
        super(MainClassType.NONE);
        Logger.log(LogLevel.IMPORTANT, "Wrapper is up and running!");
    }
}
