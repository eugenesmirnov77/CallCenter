package by.epam.entity;

import by.epam.entity.Client;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Operator {

    private String name;
    private ArrayList<Client> clients;
    private final static int COUNT = 2;

    private Semaphore semaphore = new Semaphore(COUNT);
    private Lock lock = new ReentrantLock();

    public Operator() {
        clients = new ArrayList();
    }

    public Operator(String name) {
        this.name = name;
        clients = new ArrayList();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(Client client) {
        clients.add(client);
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public Lock getLock() {
        return lock;
    }

    public void setClientsCount(int count) {
        semaphore = new Semaphore(count);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                " name = " + name;
    }
}
