package io.turntabl;

public class AccountManager {
    private int id;
    private String  name;

    public AccountManager(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{\nID: %d\tName: %s\t\n}", getId(), getName());
    }
}
