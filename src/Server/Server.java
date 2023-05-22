package Server;

import java.net.*;
import java.io.*;
import java.util.Scanner;

class Server {
    public static void main(String arg[]) throws IOException {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        Socket socket = null;
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            try {
                Socket s = server.accept();
                System.out.println("Client connected");

                inputStreamReader = new InputStreamReader(s.getInputStream());
                outputStreamWriter = new OutputStreamWriter(s.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                Scanner scanner = new Scanner(System.in);

                while (true) {
                    String msgFromClient = bufferedReader.readLine();
                    System.out.println("Client: " + msgFromClient);

                    System.out.print("Server.Server: ");
                    String msgToClient = scanner.nextLine();

                    bufferedWriter.write(msgToClient);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if(msgFromClient.equalsIgnoreCase("bye")) break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (socket != null)
                    socket.close();
            }
        }
    }
}
