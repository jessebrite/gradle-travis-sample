package io.turntabl;

public class AccountManager {
    private final String id;
    private String  name;

    public AccountManager(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("{\nID: %s\tName: %s\t\n}", getId(), getName());
    }
}
