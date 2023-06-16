package Server;

import Client.Board;
import Client.Player;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private final int PORT = 9091;
    private Handler handler;
    private Board board;
    private final Player player = new Player(true);

    public Server() {
        try {
            System.out.println(this.player);
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            closeServer();
        }
    }

    public void startServer() {
        System.out.println("[SERVER]: server listening on port: " + PORT);
        while (!serverSocket.isClosed()) {
            new Thread(() -> {
                try {
                    this.socket = serverSocket.accept();
                    this.handler = new Handler(socket, board, player);
                    System.out.println("[SERVER]: new client connected");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void initBoard(Board board) {
        this.board = board;
    }

    private void closeServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Handler getHandler() {
        return this.handler;
    }

    public static void main(String[] args) {
        new Server();
    }

    public Player getPlayer() {
        return player;
    }
}
