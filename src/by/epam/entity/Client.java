package by.epam.entity;

import java.util.concurrent.TimeUnit;

import by.epam.util.FileInit;
import org.apache.logging.log4j.Logger;

public class Client implements Runnable{

    private static final Logger LOGGER = Logger.getLogger(Client.class);

    private static final String PATH = "names.txt";
    private static int TIME_CALLING = 3;
    private Operator operator = new Operator();
    private FileInit fileInit = new FileInit();

    public Client() {

    }


    @Override
    public void run() {

        String nameClient = fileInit.readName(Client.PATH);

        try {
            operator.getLock().lock();
            operator.getSemaphore().acquire();
            operator.setClients(this);
            System.out.println(operator.getName() + " is speaking with " + nameClient);
            TimeUnit.SECONDS.sleep(Client.TIME_CALLING);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("IException was founded", e);
        } finally {
            operator.getLock().unlock();
        }

    }
}
