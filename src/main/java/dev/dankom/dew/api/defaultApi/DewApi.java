package dev.dankom.dew.api.defaultApi;

import dev.dankom.dew.api.ApiMain;
import dev.dankom.dew.api.ApiType;

public class DewApi extends ApiMain {
    public DewApi() {
        setName("DewApi");
        setMainPackage("dev.dankom.dew");
        setApiType(ApiType.DEV);
    }
}
