package homework6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);
        Socket connected = server.accept();
        System.out.println("Connected " + connected.getInetAddress());
        DataInputStream in = new DataInputStream(connected.getInputStream());
        DataOutputStream out = new DataOutputStream(connected.getOutputStream());
        Scanner input = new Scanner(System.in);

        //обработка отправления сообщений сервера
        Thread inputService = new Thread(() -> {
            while (true) {
                String command = input.nextLine();
                if (server.isClosed()) break;
                try {
                    out.writeUTF(command);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        inputService.start();

        //обработка поступающих от клиента сообщений
        while (true) {
            String clientMessage = in.readUTF();
            if (clientMessage.equals("quit")) {
                out.writeUTF("exclude");
                out.flush();
                server.close();
                // ожидание ввода команды сервера после отключения со стороны клиента
                // так и не получилось исправить
                System.out.println("Press something to exit...");
                return;
            }
            System.out.println("Client: " + clientMessage);
            if (clientMessage.contains("Hello")) {
                out.writeUTF("Hello, " + connected.getInetAddress() + "! We know all about you...");
            } else {
                out.writeUTF(clientMessage);
            }
            out.flush();
        }
    }
}
