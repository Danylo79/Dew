package dev.dankom.wrapper;

import dev.dankom.wrapper.main.MainClass;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private static List<MainClass> bootClasses = new ArrayList<MainClass>();

    public static void registerClass(MainClass mainClass) {
        bootClasses.add(mainClass);
    }

    public static void unregisterClass(MainClass mainClass) {
        bootClasses.remove(mainClass);
    }
}
