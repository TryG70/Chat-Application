package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localHost";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {


        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {

            while(true) {
                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                String myName = "Amanda: ";
                output.writeUTF(myName + msg);

                System.out.print("TryGod: ");
                String receivedMsg = input.readUTF();
                System.out.println(receivedMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
