package dev.dankom.dew;

import dev.dankom.dew.api.ApiMain;
import dev.dankom.dew.api.ApiManager;
import dev.dankom.dew.config.Config;
import dev.dankom.dew.config.PackageConfig;
import dev.dankom.dew.config.Private;
import dev.dankom.dew.file.json.JsonFile;
import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import dev.dankom.dew.main.MainClass;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        init();
    }

    private static void init() {

        if (!canStart()) return;

        Config.getInstance().generateConfig();
        Private.getInstance().generateConfig();
        PackageConfig.getInstance().generateConfig();

        ApiManager.init();

        List<Class<? extends MainClass>> classes = getMainClasses();

        for (Class<? extends MainClass> c : classes) {
            try {
                MainClass mClass = c.newInstance();
                Registry.registerClass(mClass);
                if (mClass instanceof ApiMain && !c.getSimpleName().equals("ApiMain")) {
                    ApiManager.register((ApiMain) mClass);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean canStart() {
        try {
            new Logger(LogLevel.IMPORTANT).log("Starting Logger");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static List<Class<? extends MainClass>> getMainClasses() {
        Reflections reflections;
        List<Class<? extends  MainClass>> out = new ArrayList<>();
        JSONObject json = Config.getInstance().getConfig();
        JSONArray directories = ((JSONArray) json.get("MainDirectories"));

        for (int i = 0; i < directories.size(); i++) {
            reflections = new Reflections(directories.get(i));
            for (Class<? extends  MainClass> c : reflections.getSubTypesOf(MainClass.class)) {
                out.add(c);
            }
        }

        //Register this directory as a main directory
        reflections = new Reflections("dev.dankom.dew");
        for (Class<? extends  MainClass> c : reflections.getSubTypesOf(MainClass.class)) {
            out.add(c);
        }

        return out;
    }
}
