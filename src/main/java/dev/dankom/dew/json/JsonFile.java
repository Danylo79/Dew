package dev.dankom.dew.json;

import dev.dankom.dew.logger.LogLevel;
import dev.dankom.dew.logger.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonFile {
    private String name;
    private static JsonFile instance;
    private JSONObject Default;

    public JsonFile(String name, JSONObject Default) {
        this.name = name + ".json";
        this.Default = Default;
        instance = this;
    }

    public void generateConfig() {
        if (!isConfigGenerated()) {
            create();
        }
    }

    public JSONObject getConfig() {
        if (!isConfigGenerated()) {
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
        Logger.logO(LogLevel.INFO, "Creating devConfig.json");
        JSONObject obj = Default;

        try (FileWriter file = new FileWriter(new File("./" + getName()))) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            Logger.logO(LogLevel.FATAL, "Failed to create devConfig.json!");
            e.printStackTrace();
        }
    }

    public boolean isConfigGenerated() {
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

    public String getName() {
        return name;
    }
}
