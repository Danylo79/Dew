package dev.dankom.dew.test;

import dev.dankom.dew.config.Config;
import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import dev.dankom.dew.main.MainClass;
import dev.dankom.dew.main.MainClassType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner extends MainClass {
    public TestRunner() {
        super(MainClassType.NONE);
        Logger.logO(LogLevel.INFO, "Starting test runner");
        runTests();
    }

    public void runTests() {
        Logger logger = new Logger(LogLevel.INFO);

        for (Class<? extends RuntimeTest> c : getTestClasses()) {
            try {
                RuntimeTest test = c.newInstance();
                if (test.getCallTime() == CallTime.RUNTIME) {
                    for (Method m : c.getDeclaredMethods()) {
                        m.invoke(c.newInstance());
                    }
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Class<? extends RuntimeTest>> getTestClasses() {
        Reflections reflections;
        List<Class<? extends  RuntimeTest>> out = new ArrayList<>();
        JSONObject json = Config.getInstance().getConfig();
        JSONArray directories = ((JSONArray) json.get("TestDirectories"));

        for (int i = 0; i < directories.size(); i++) {
            reflections = new Reflections(directories.get(i));
            for (Class<? extends  RuntimeTest> c : reflections.getSubTypesOf(RuntimeTest.class)) {
                out.add(c);
            }
        }

        //Register this directory as a test directory
        reflections = new Reflections("dev.dankom.dew");
        for (Class<? extends  RuntimeTest> c : reflections.getSubTypesOf(RuntimeTest.class)) {
            out.add(c);
        }

        return out;
    }
}
