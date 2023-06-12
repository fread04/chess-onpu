package Client;

import Server.Server;

import javax.swing.*;

public class Game {
    private final Board board;
    private JFrame gamePanel;


    public Game(JFrame mainFrame, Client client) {
        this.board = new Board(mainFrame, client);
        client.initBoard(board);
        System.out.println("Game client: " + client);
        gamePanel = board.getFrame();
    }

    public Game(JFrame mainFrame, Server server) {
        this.board = new Board(mainFrame, server);
        server.initBoard(board);
        System.out.println("Game server: " + server);
        gamePanel = board.getFrame();
    }

    public Game() {
        this.board = new Board();
    }
}
