package dev.dankom.wrapper.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Config {

    private static Config instance;
    private String confName = "dwConf.json";

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
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
        File out = new File("./" + confName);
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
        JSONObject obj = new JSONObject();

        JSONArray list = new JSONArray();
        list.add("dev.dankom.wrapper");
        obj.put("MainDirectories", list);

        try (FileWriter file = new FileWriter(new File("./" + confName))) {
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isConfigGenerated() {
        try {
            File main = new File("./" + confName);
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
}
