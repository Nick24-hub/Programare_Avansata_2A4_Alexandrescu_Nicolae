package server;

import socialnetwork.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ClientThread extends Thread {
    private final Socket socket;
    private final SimpleServer server;

    public ClientThread(Socket socket, SimpleServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Person client = null;
            String raspuns = null;
            String request;
            while (true) {
                request = in.readLine();
                String[] words = request.split(" ");
                if (request.equals("stop")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                    server.stopServer();
                    break;
                } else if (request.equals("exit")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                    break;
                } else if (words[0].equals("register")) {
                    boolean ok = true;
                    for (Person person : server.getSocialNetwork()) {
                        if (words[1].equals(person.getName())) {
                            raspuns = "This user already exists.";
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        client = new Person(words[1]);
                        server.addPerson(new Person(words[1]));
                        raspuns = "Registered successfully.";
                    }
                    out.println(raspuns);
                    out.flush();
                } else if (words[0].equals("login")) {
                    boolean ok = false;
                    for (Person person : server.getSocialNetwork()) {
                        if (words[1].equals(person.getName())) {
                            client = new Person(words[1]);
                            raspuns = "Logged in successfully.";
                            ok = true;
                            break;
                        }
                    }
                    if (!ok) {
                        raspuns = "Login failed, this user is not registered.";
                    }
                    out.println(raspuns);
                    out.flush();
                } else if (words[0].equals("friend")) {
                    if (client != null) {
                        List<Person> friendList = new ArrayList<Person>();
                        for (String s : words) {
                            for (Person person : server.getSocialNetwork()) {
                                if (s.equals(person.getName())) {
                                    friendList.add(person);
                                }
                            }
                        }
                        client.setFriendList(friendList);
                        raspuns = "Friends added successfully.";
                    } else {
                        raspuns = "You need to be logged in.";
                    }
                    out.println(raspuns);
                    out.flush();
                } else if (words[0].equals("send")) {
                    String str = "";
                    str += words[1];
                    for (int i = 2; i < words.length; ++i) {
                        str += " ";
                        str += words[i];
                    }
                    if (client != null) {
                        for (Person person : client.getFriendList()) {
                            person.addMessage(str);
                        }
                        raspuns = "Message sent successfully.";
                    } else {
                        raspuns = "You need to be logged in.";
                    }
                    out.println(raspuns);
                    out.flush();
                } else if (request.equals("read")) {
                    if (client != null) {
                        raspuns = "";
                        for (String str : client.getMessageList()) {
                            raspuns += str;
                            raspuns += "\n";
                        }
                    } else {
                        raspuns = "You need to be logged in.";
                    }
                    out.println(raspuns);
                    out.flush();
                } else {
                    raspuns = "Invalid command";
                    out.println(raspuns);
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}

