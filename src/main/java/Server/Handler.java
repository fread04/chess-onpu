package Server;

import Client.Board;

import java.io.*;
import java.net.Socket;

public class Handler {
    private Socket socket;
    private BufferedWriter writer;
    private BufferedReader reader;
    private String messageFromClient;
    private Board board;
    private final int[] parsedString = new int[4];


    Handler(Socket socket, Board board) {
        try {
            this.socket = socket;
            this.board = board;
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Thread listener = new Thread(this::listen);
            listener.start();
        } catch (IOException e) {
            closeSocket(socket, writer, reader);
        }
    }

    public void initBoard(Board board) {
        this.board = board;
    }

    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        while(socket.isConnected()) {
            try {
                messageFromClient = reader.readLine();
                System.out.println("[Client]: " + messageFromClient);
                parseString();
                board.performMove(parsedString[0], parsedString[1], parsedString[2], parsedString[3]);
            } catch (IOException e) {
                closeSocket(socket, writer, reader);
                break;
            }
        }
    }

    private void parseString() {
        String[] token = messageFromClient.split(" ");
        for(int i = 0; i < token.length; i++) {
            parsedString[i] = Integer.parseInt(token[i]);
        }
    }

    private void closeSocket(Socket socket, BufferedWriter writer, BufferedReader reader) {
        System.out.println("[SERVER]: client has left");
        try {
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
