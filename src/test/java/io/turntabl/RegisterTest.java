package io.turntabl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.turntabl.ServiceLevel.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class RegisterTest {

    @Mock
    AutoCloseable closeable;
    Client client1;
    Client client2;
    Client client3;
    Client client4;
    Client client5;
    Client client6;
    AccountManager manager1;
    AccountManager manager2;
    Register register;

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
//        mock for Private
        client1 = mock(Private.class);
        client1 = new Private("121", "Jane", GOLD);
        client3 = new Private("123", "Jack", PLATINUM);
        client4 = new Private("124", "Jack", PLATINUM);
        client6 = new Private("126", "Jack", GOLD);

//        mock for Corporate
        manager1 = mock(AccountManager.class);
        manager1 = new AccountManager("12", "Eric");
        manager2 = new AccountManager("11", "Emma");

//        mock for Corporate
        client2 = mock(Corporate.class);
        client2 = new Corporate("122", "John", GOLD, manager1);
        client5 = new Corporate("125", "Jack", PREMIUM, manager2);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);

//        mock for Register
        register = new Register(clients);

    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    @DisplayName("It should get only GOLD clients")
    public void shouldGetGoldClients() {
        List<Client> expected = new ArrayList<>();
        expected.add(client1);
        expected.add(client2);
        expected.add(client6);
        assertArrayEquals(expected.toArray(), register.getGoldClients().toArray());
    }

    @Test
    @DisplayName("It should get client name by their ID")
    public void shouldGetClientNameById() {
        assertEquals("Jane", register.getClientNameById("121").orElse("nin"));
    }

    @Test
    @DisplayName("It should count clients by their level")
    public void shouldCountClientsByLevel() {
        Map<ServiceLevel, Long> expected = new HashMap<>();
        expected.put(PLATINUM, 2L);
        expected.put(PREMIUM, 1L);
        expected.put(GOLD, 3L);

        assertEquals(expected, register.countByLevel());
    }
}