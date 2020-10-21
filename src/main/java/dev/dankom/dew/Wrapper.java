package dev.dankom.dew;

import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import dev.dankom.dew.main.MainClass;
import dev.dankom.dew.main.MainClassType;
import dev.dankom.dew.util.Color;

public class Wrapper extends MainClass {
    public Wrapper() {
        super(MainClassType.NONE);
        Logger.log(LogLevel.IMPORTANT, Color.ANSI_RED + "Dew " + Color.ANSI_MAGENTA +  "is up and running!");
    }
}
