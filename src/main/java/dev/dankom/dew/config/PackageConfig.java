package dev.dankom.dew.config;

import dev.dankom.dew.file.json.JsonFile;
import dev.dankom.dew.file.json.JsonObjectBuilder;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class PackageConfig extends JsonFile {

    private static PackageConfig instance;

    public PackageConfig() {
        super(new File("./dew/package"), "packageConf", new JsonObjectBuilder().addArray("Packages", new ArrayList<>()).build());
    }

    public static PackageConfig getInstance() {
        if (instance == null) {
            instance = new PackageConfig();
        }
        return instance;
    }
}
