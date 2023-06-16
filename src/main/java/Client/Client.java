package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.lang.ref.Cleaner;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private Socket socket;
    private BufferedWriter writer;
    private String messageFromServer;
    private BufferedReader reader;
    private Board board;
    private final int[] parsedString = new int[5];//signature: [0] - oldX, [1] - oldY, [2] - curX, [3] - curY, [4] - move(0 - performMove, 1 - capture);


    Client(String host, int port) throws IOException{
        try {
            socket = new Socket(host, port);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Thread listener = new Thread(this::listen);
            listener.start();
        } catch (IOException e) {
            closeClient();
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
            closeClient();
        }
    }

    private void listen() {
        while(socket.isConnected()) {
            try {
                messageFromServer = reader.readLine();
                System.out.println("[SERVER]: " + messageFromServer);
                parseString();
                if(parsedString[4] == 0) {
                    board.performMove(parsedString[0], parsedString[1], parsedString[2], parsedString[3]);
                } else if(parsedString[4] == 1) {
                    if(Objects.equals(board.getPiece(parsedString[2], parsedString[3]).getName(), "king")
                        && !board.getPiece(parsedString[2], parsedString[3]).isWhite()) {
                        System.out.println("you lost");
                    }
                    if(Objects.equals(board.getPiece(parsedString[2], parsedString[3]).getName(), "king")
                            && board.getPiece(parsedString[2], parsedString[3]).isWhite()) {
                        System.out.println("you won");
                    }
                    board.capture(parsedString[0], parsedString[1], parsedString[2], parsedString[3]);
                }
            } catch (IOException e) {
                closeClient();
            }
        }
    }

    private void parseString() {
        String[] token = messageFromServer.split(" ");
        for(int i = 0; i < token.length; i++) {
            parsedString[i] = Integer.parseInt(token[i]);
        }
    }

    private void closeClient() {
        try {
            socket.close();
            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public BufferedReader getReader() {
        return reader;
    }
}