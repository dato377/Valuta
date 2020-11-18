package ge.edu.btu.server;


import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(9091);
        System.out.println("სერვერი ჩაირთო");

        while (true){
            Socket currentSocket = serverSocket.accept();
            System.out.println("კლიენტი დაკავშრდა");
            ServerThread thread = new ServerThread(currentSocket);
            thread.start();
        }

    }
}
