package by.epam.runner;

import by.epam.entity.Client;
import by.epam.entity.Operator;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) {

        LOGGER.info("Call Center opened");

        Operator operatorFirst = new Operator("ALICE");
        operatorFirst.setClientsCount(10);

        Operator operatorSecond = new Operator("LUCY");
        operatorSecond.setClientsCount(7);

        Client client = new Client();

        Thread thread = new Thread(client);
        thread.start();

    }
}
