package com.nwhite.multithreading.webserver;

/**
 * Start the server and go to http://localhost:8080/ in the browser
 */
public class MainTest {

    public static void main(String[] args) {
        MultithreadedWebServer server = new MultithreadedWebServer(8080);
        Thread serverThread = new Thread(server::startServer);
        serverThread.start();
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
