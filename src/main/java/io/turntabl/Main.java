package io.turntabl;

import java.util.ArrayList;
import java.util.List;

import static io.turntabl.ServiceLevel.*;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Private("121", "Jane", GOLD);
        Client client2 = new Corporate("122", "John", GOLD);
        Client client3 = new Private("123", "Jack", PLATINUM);
        Client client4 = new Private("123", "Jack", PLATINUM);
        Client client5 = new Corporate("123", "Jack", PREMIUM);
        Client client6 = new Private("123", "Jack", GOLD);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);

        Register register = new Register(clients);

//        System.out.println(register);
        register.countByLevel();
//        System.out.println(register.getClientNameById("122"));

        System.out.println(register.getGoldClients());
    }
}
