package homework6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 80);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Scanner input = new Scanner(System.in);

        //обработка поступающих от сервера сообщений
        Thread outputService = new Thread(() -> {
            while (true) {
                try {
                    String messageFromServer = in.readUTF();
                    System.out.println("Server: " + messageFromServer);
                    if (messageFromServer.equals("exclude")&&flag) {
                        socket.close();
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        outputService.start();

        //обработка отправления сообщений клиента
        while (true) {
            String message = input.nextLine();
            out.writeUTF(message);
            out.flush();
            if (message.equals("quit")) {
                flag = true;
                return;
            }
        }
    }
}
