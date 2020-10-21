package dev.dankom.dew.config;

import dev.dankom.dew.json.JsonFile;
import dev.dankom.dew.json.JsonObjectBuilder;

import java.util.ArrayList;

public class Config extends JsonFile {
    private static Config instance;
    public Config() {
        super("dewConfig", new JsonObjectBuilder().addArray("MainDirectories", new ArrayList<>()).addArray("FilteredLogLevels", new ArrayList<>()).build());
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
