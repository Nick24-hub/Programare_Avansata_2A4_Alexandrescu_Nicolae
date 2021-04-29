import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private final Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Send the response to the oputput stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns;
            String request;
            while (true) {
                request = in.readLine();
                String[] words = request.split(" ");
                if (request.equals("stop")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                    System.exit(0);
                }
                else if (request.equals("exit")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                    break;
                }
                else if (words[0].equals("register")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                }
                else if (words[0].equals("login")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                }
                else if (words[0].equals("friend")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                }
                else if (words[0].equals("send")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                }
                else if (request.equals("read")) {
                    raspuns = request;
                    out.println(raspuns);
                    out.flush();
                }
                else{
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

