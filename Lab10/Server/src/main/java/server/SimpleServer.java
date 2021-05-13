import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static final int PORT = 8100;
    private boolean ok;

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            ok=true;
            serverSocket = new ServerSocket(PORT);
            while (ok) {
                System.out.println("Waiting for a client ...");
                serverSocket.setSoTimeout(10000);
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket, this).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    public void StopServer() {
        ok = false;
    }
}
