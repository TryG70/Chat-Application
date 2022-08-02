package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread{
    private final Socket socket;

    public ServerThread (Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {

            while(true) {
                Scanner scanner = new Scanner(System.in);

                //System.out.print("Client: ");
                String receivedMsg = input.readUTF();
                System.out.println(receivedMsg);

                String msg = scanner.nextLine();
                output.writeUTF(msg);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
