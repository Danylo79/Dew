package dev.dankom.dew.test;

public class RuntimeTest {

    private final String name;
    private final CallTime callTime;

    public RuntimeTest(String name, CallTime callTime) {
        this.name = name;
        this.callTime = callTime;
    }

    public void assertEquals(String assertName, boolean value, boolean actual) {
        new Assert(assertName, value, actual);
    }

    public void assertEquals(String assertName, int value, int actual) {
        new Assert(assertName, value, actual);
    }

    public void assertEquals(String assertName, String value, String actual) {
        new Assert(assertName, value, actual);
    }

    public void assertEquals(String assertName, Object value, Object actual) {
        new Assert(assertName, value, actual);
    }

    public String getName() {
        return name;
    }

    public CallTime getCallTime() {
        return callTime;
    }
}
