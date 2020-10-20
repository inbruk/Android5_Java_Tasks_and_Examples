package JavaLessons.Task521;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SmallServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8090);
        Socket sock = server.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintStream ps = new PrintStream(sock.getOutputStream());
        Scanner scan = new Scanner(System.in);

        ps.println("Вы присоединились к SmallServerSocket !");
        ps.flush();
        System.out.println("Клиент присоединился к серверу !");

        boolean contFlag = true;
        while(contFlag == true) {

            if( br.ready() ) {
                System.out.print("cli: ");
                String message = br.readLine();
                System.out.println(message);
            }

            System.out.print("srv: ");
            String input = scan.nextLine();
            if( input.equals("quit") )
                contFlag = false;
        }

        sock.close();
        server.close();
    }
}


