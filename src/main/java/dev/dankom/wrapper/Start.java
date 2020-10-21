package dev.dankom.wrapper;

import dev.dankom.wrapper.config.Config;
import dev.dankom.wrapper.main.MainClass;
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

        Config.getInstance().generateConfig();

        List<Class<? extends MainClass>> classes = getMainClasses();

        for (Class<? extends MainClass> c : classes) {
            try {
                MainClass mClass = c.newInstance();
                Registry.registerClass(mClass);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
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
        return out;
    }
}
