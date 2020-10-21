package dev.dankom.wrapper;

import dev.dankom.wrapper.main.MainClass;
import dev.dankom.wrapper.util.ListUtil;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
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
        Reflections reflections = new Reflections("dev.dankom.wrapper");
        return new ListUtil<Class<? extends MainClass>>().toList(reflections.getSubTypesOf(MainClass.class));
    }
}
