package Server;

import App.Quiztastic;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Scanner;

public class Server implements Runnable{

    private final Socket socket;


    public Server(Socket socket) {

        this.socket = socket;
    }


    @Override
    public void run() {


        try{
            Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            Quiztastic quiz = new Quiztastic();
            quiz.injectInputToReader(scanner, writer);
            socket.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();

        }

    }

    public static volatile boolean keepRunning = true;

    public static void main(String[] args) throws IOException {

        System.out.println("Connect: telnet 127.0.0.1 6060");

        final int port = 6060;

        final ServerSocket serverSocket = new ServerSocket(port);

        while (keepRunning){

            Socket socket = serverSocket.accept();

            System.out.println("[CONECTED] client IP: " + socket.getInetAddress() + " client port: " + socket.getPort());
            System.out.println("From local IP: " + socket.getLocalAddress() + " local port: " + socket.getLocalPort());


            Thread thread = new Thread(new Server(socket));

            thread.start();

        }

    }

}

