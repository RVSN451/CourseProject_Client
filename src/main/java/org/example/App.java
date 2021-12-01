package org.example;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public final static Logger log = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {

        Thread.currentThread().setName("GENERAL_APP");
        Client newClient = new Client("localhost", 8080);

        if (!newClient.isClientIsInterrupt()) {

        }
        Thread threadClient = new Thread(newClient);
        threadClient.setName("ClientThread");
        threadClient.setDaemon(true);
        threadClient.start();
        log.info("Клиент {} запущен.", newClient.getClientID());

        while (true) {


            if (threadClient.isInterrupted()) {
                log.info("Клиент {} с именем {} завершил работу приложения.",
                        newClient.getClientID(), newClient.getClientName());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static void stopApplication() {
        log.error("Сервер недоступен.");
        Thread.currentThread().interrupt();
    }
}
