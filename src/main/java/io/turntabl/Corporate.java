package io.turntabl;

public class Corporate extends Client {
    private AccountManager accountManager;

//    public Corporate(String clientId, String name, ServiceLevel level) {
//        super(clientId, name, level);
//    }

    public Corporate(String clientId, String name, ServiceLevel level, AccountManager accountManager) {
        super(clientId, name, level);
        this.accountManager = accountManager;
    }

    @Override
    public String getContactPerson() {
        return accountManager.getName();
    }
}
