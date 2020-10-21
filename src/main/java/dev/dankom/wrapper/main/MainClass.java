package dev.dankom.wrapper.main;

public class MainClass {

    private MainClassType mainClassType;

    public MainClass(MainClassType mainClassType) {
        this.mainClassType = mainClassType;
    }

    public static void main(String[] args) {}

    public MainClassType getType() {
        return mainClassType;
    }

    public void setType(MainClassType mainClassType) {
        this.mainClassType = mainClassType;
    }
}
