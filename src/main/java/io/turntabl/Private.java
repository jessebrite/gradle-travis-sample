package io.turntabl;

public class Private extends Client {

    public Private(String clientId, String name, ServiceLevel level) {
        super(clientId, name, level);
    }

    @Override
    public String getContactPerson() {
        return getName();
    }
}
