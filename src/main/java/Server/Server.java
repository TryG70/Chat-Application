package Server;



import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) {


        try (ServerSocket server = new ServerSocket(PORT)) {

            while (true) {
                ServerThread serverThread = new ServerThread(server.accept());
                serverThread.start();
                try {
                    serverThread.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
