package io.turntabl;

public abstract class Client {
    private final String ClientId;
    private String name;
    private ServiceLevel level;

    public Client(String clientId, String name, ServiceLevel level) {
        ClientId = clientId;
        this.name = name;
        this.level = level;
    }

    public String getClientId() {
        return ClientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceLevel getLevel() {
        return level;
    }

    public void setLevel(ServiceLevel level) {
        this.level = level;
    }

    public abstract String getContactPerson();

    @Override
    public String toString() {
        return String.format("{\nClientId: %s\tName: %s\tLevel: %s\n}", getClientId(), getName(), getLevel());
    }
}
