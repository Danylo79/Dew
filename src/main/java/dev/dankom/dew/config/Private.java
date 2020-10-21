package dev.dankom.dew.config;

import dev.dankom.dew.file.json.JsonFile;
import dev.dankom.dew.file.json.JsonObjectBuilder;

import java.io.File;

public class Private extends JsonFile {
    private static Private instance;
    public Private() {
        super(new File("."), "private", new JsonObjectBuilder()
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
