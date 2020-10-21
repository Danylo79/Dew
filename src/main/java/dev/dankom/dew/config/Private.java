package dev.dankom.dew.config;

import dev.dankom.dew.json.JsonFile;
import dev.dankom.dew.json.JsonObjectBuilder;

import java.util.ArrayList;

public class Private extends JsonFile {
    private static Private instance;
    public Private() {
        super("private", new JsonObjectBuilder()
                .addKeyValuePair("jdaToken", "")
                .build());
    }

    public static Private getInstance() {
        if (instance == null) {
            instance = new Private();
        }
        return instance;
    }
}
