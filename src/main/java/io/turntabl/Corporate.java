package io.turntabl;

public class Corporate extends Client {
    private AccountManager accountManager;

    public Corporate(String clientId, String name, ServiceLevel level) {
        super(clientId, name, level);
    }

    @Override
    public String getContactPerson() {
        return accountManager.getName();
    }
}
