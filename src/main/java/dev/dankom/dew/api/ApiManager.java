package dev.dankom.dew.api;

import dev.dankom.dew.config.PackageConfig;
import dev.dankom.dew.file.json.JsonObjectBuilder;
import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import dev.dankom.dew.util.ListUtil;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class ApiManager {

    public static List<ApiMain> apiMains = new ArrayList<>();
    private static Logger logger = new Logger(LogLevel.INFO);

    public static void init() {
        PackageConfig.getInstance().purge();
    }

    public static void register(ApiMain apiMain) {
        if (apiMain.getMainPackage() != null && apiMain.getName() != null) {
            apiMains.add(apiMain);
            new Logger(LogLevel.INFO).log("ApiManager", "Registered api " + apiMain.getName() + " with main package " + apiMain.getMainPackage());
            PackageConfig.getInstance().addToArray("Packages", new JsonObjectBuilder()
                    .addKeyValuePair("Main-Directory", apiMain.getMainPackage())
                    .addKeyValuePair("Name", apiMain.getName())
                    .addKeyValuePair("Type", apiMain.getApiType().name())
                    .addArray("Dependencies", apiMain.getDependencies())
                    .build());
        }
    }

    public static void unregister(ApiMain apiMain) {
        if (apiMain.getMainPackage() != null && apiMain.getName() != null) {
            apiMains.remove(apiMain);
        }
    }

    public static Class<? extends ApiMain> getAPI(String name) {
        Reflections reflections;
        Class<? extends ApiMain> out = null;
        for (ApiMain am : apiMains) {
            if (am.getName().equals(name)) {
                reflections = new Reflections(am.getMainPackage());
                List<Class<? extends ApiMain>> reflect = new ListUtil<Class<? extends ApiMain>>().toList(reflections.getSubTypesOf(ApiMain.class));
                out = reflect.get(0);
            }
        }
        return out;
    }
}
