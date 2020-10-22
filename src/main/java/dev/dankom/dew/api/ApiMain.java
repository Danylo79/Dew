package dev.dankom.dew.api;

import dev.dankom.dew.main.MainClass;
import dev.dankom.dew.main.MainClassType;

import java.util.ArrayList;
import java.util.List;

public class ApiMain extends MainClass {
    private String name;
    private String mainPackage;
    private List<String> dependencies;
    private ApiType apiType;

    public ApiMain() {
        super(MainClassType.BUNDLE);
        name = "";
        mainPackage = "";
        dependencies = new ArrayList<>();
        apiType = ApiType.NONE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainPackage() {
        return mainPackage;
    }

    public void setMainPackage(String mainPackage) {
        this.mainPackage = mainPackage;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public ApiType getApiType() {
        return apiType;
    }

    public void setApiType(ApiType apiType) {
        this.apiType = apiType;
    }
}
