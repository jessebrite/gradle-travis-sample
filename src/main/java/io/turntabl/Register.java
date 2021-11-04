package io.turntabl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.turntabl.ServiceLevel.GOLD;

public class Register {
    private final List<Client> clients;

    public Register(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getGoldClients() {
        return clients.stream()
                .filter(x -> x.getLevel().equals(GOLD))
                .collect(Collectors.toList());
    }

    public Optional<String> getClientNameById(String clientId) {
        return clients
                .stream()
                .filter(x -> x.getClientId().equals(clientId))
                .map(Client::getContactPerson).findFirst();
    }

    public Map<ServiceLevel, Long> countByLevel() {
        return  clients.stream()
                .collect(Collectors.groupingBy(Client::getLevel, Collectors.counting()));
//        clientCountByLevel.forEach(((level, aLong) -> System.out.printf("%s has %d clients(s)%n", level, aLong)));
    }

    @Override
    public String toString() {
        return "Register{" +
                "clients=" + clients +
                '}';
    }
}
