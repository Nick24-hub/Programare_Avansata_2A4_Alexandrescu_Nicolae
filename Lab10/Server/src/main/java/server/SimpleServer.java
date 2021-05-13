package server;

import socialnetwork.Person;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SimpleServer {
    public static final int PORT = 8100;
    private boolean ok;
    private List<Person> socialNetwork = new ArrayList<Person>();

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            ok = true;
            serverSocket = new ServerSocket(PORT);
            while (ok) {
                System.out.println("Waiting for a client ...");
                serverSocket.setSoTimeout(300000);
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket, this).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    public void addPerson(Person x) {
        socialNetwork.add(x);
    }

    public void stopServer() {
        ok = false;
    }

    public List<Person> getSocialNetwork() {
        return socialNetwork;
    }
}
