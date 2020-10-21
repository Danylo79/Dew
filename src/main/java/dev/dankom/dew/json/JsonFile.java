package dev.dankom.dew.json;

import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class JsonFile {
    private String name;
    private JSONObject Default;

    public JsonFile(String name, JSONObject Default) {
        this.name = name + ".json";
        this.Default = Default;
    }

    public void generateConfig() {
        if (!isGenerated()) {
            create();
        } else {
            update();
        }
    }

    public JSONObject getConfig() {
        if (!isGenerated()) {
            generateConfig();
        }
        File out = new File("./" + getName());
        JSONParser parser = new JSONParser();

        try {
            return (JSONObject) parser.parse(new FileReader(out));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void create() {
        Logger.logO(LogLevel.INFO, "Creating " + getName());
        JSONObject obj = Default;

        try (FileWriter file = new FileWriter(new File("./" + getName()))) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            Logger.logO(LogLevel.FATAL, "Failed to create " + getName() + "!");
            e.printStackTrace();
        }
    }

    private void update() {
        JSONObject obj = getConfig();
        boolean updated = false;

        for(Iterator iterator = Default.keySet().iterator(); iterator.hasNext();) {
            String key = (String) iterator.next();
            Object val = Default.get(key);

            if (obj.containsKey(key)) {
                continue;
            } else {
                obj.put(key, val);
                updated = true;
            }
        }

        if (updated) {
            try (FileWriter file = new FileWriter(new File("./" + getName()))) {
                file.write(obj.toJSONString());
            } catch (IOException e) {
                Logger.logO(LogLevel.FATAL, "Failed to create " + getName() + "!");
                e.printStackTrace();
            }
            Logger.logO(LogLevel.INFO, "Updated " + getName() + "! This is maybe because of a missing value or an update in the library.");
        }
    }

    public boolean isGenerated() {
        try {
            File main = new File("./" + getName());
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(main));
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void purge() {
        try (FileWriter file = new FileWriter(new File("./" + getName()))) {
            file.write(Default.toJSONString());
            Logger.logO(LogLevel.INFO, "Purged " + getName());
        } catch (IOException e) {
            Logger.logO(LogLevel.FATAL, "Failed to purge " + getName() + "!");
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
