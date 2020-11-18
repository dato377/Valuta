package ge.edu.btu.client;

import ge.edu.btu.model.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 9091);
        System.out.println("კავშირის დამყარება...");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        while (true) {
            System.out.print("დასვი კითხვა: ");
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            Message message = new Message(msg);
            objectOutputStream.writeObject(message);
            Message receivedText = (Message) objectInputStream.readObject();
            System.out.println("პასუხი: " + receivedText.getMessage());
            if (receivedText.getMessage().contains("ნახვამდის")) break;
        }

        System.out.println("კავშირის დასასრული !!!");

        objectInputStream.close();
        objectOutputStream.close();
        socket.close();
    }
}
