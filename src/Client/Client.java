package Client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

class Client {
    public static void main(String arg[]) throws IOException {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        Socket socket = null;

        try {
            socket = new Socket("localhost", 1234);
            System.out.println("Connected to server");

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Client.Client: ");
                String msgToServer = scanner.nextLine();

                bufferedWriter.write(msgToServer);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                String msgFromServer = bufferedReader.readLine();
                System.out.println("Server.Server: " + msgFromServer);

                if(msgToServer.equalsIgnoreCase("bye")) break;

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
