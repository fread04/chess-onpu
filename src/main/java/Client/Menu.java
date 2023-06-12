package Client;

import Server.Server;

import javax.swing.*;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Menu {
    private final JFrame frame = new JFrame();
    private final int PORT = 9091;
    private Server server;
    private Client client;

    public Menu() {
        initFrame();
        createMenuPanel();
    }

    private void initFrame() {
        frame.setBounds(700, 200,  532, 552);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void createMenuPanel() {
        JPanel menuPanel = new Panel(frame, 0, 0, 532, 552) {
            @Override
            public void addButtons() {

                JButton playButton = new Button("Play", 100, 70, 100, 30, this.getPanel()).getButton();
                JButton onlineButton = new Button("Online", 100, 110, 100, 30, this.getPanel()).getButton();
                JButton exitButton = new Button("Exit", 100, 150, 100, 30, this.getPanel()).getButton();

                playButton.addActionListener(e -> {
                    frame.setVisible(false);
                    new Game();
                });

                onlineButton.addActionListener(e -> {
                    removeAllPanels();
                    createOnlinePanel();
                });

                exitButton.addActionListener(e -> {
                    System.exit(0);
                });
            }
        }.getPanel();

        frame.add(menuPanel);
    }

    private void createOnlinePanel() {
        JPanel hostPanel = new Panel(frame, 0, 0, 532, 552) {
            @Override
            public void addButtons() {
                JButton hostButton = new Button("Host", 100, 70, 100, 30, this.getPanel()).getButton();
                JButton connectButton = new Button("Connect", 100, 110, 100, 30, this.getPanel()).getButton();
                JButton backButton = new Button("Back", 100, 150, 100, 30, this.getPanel()).getButton();

                hostButton.addActionListener(e -> {// click to host game
                    removeAllPanels();
                    //TODO: create new panel attached to this button

                    server = new Server();
                    System.out.println(server);
                    new Thread(() -> server.startServer()).start();

                    frame.setVisible(false);
                    new Game(frame, server);

                });

                connectButton.addActionListener(e -> {// click to connect to existing game
                    removeAllPanels();
                    frame.setVisible(false);

                    try {
                        client = new Client("localhost", PORT);
                        System.out.println(client);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        exit();
                    }
                    new Game(frame, client);
                });

                backButton.addActionListener(e -> {
                    removeAllPanels();
                    createMenuPanel();
                });

            }
        }.getPanel();
    }

    //#
    private void createHostPanel() {
        JPanel hostPanel = new Panel(frame, 0, 0, 532, 552) {
            @Override
            public void addButtons() {
                JButton createGameButton = new Button("Create game", 100, 70, 100, 30, this.getPanel()).getButton();
                JButton backButton = new Button("Back", 100, 150, 100, 30, this.getPanel()).getButton();

                createGameButton.addActionListener(e -> {
                    //TODO: create new panel attached to this button
                });

                backButton.addActionListener(e -> {
                    removeAllPanels();
                    createMenuPanel();
                });
            }
        }.getPanel();
    }

    private void removeAllPanels() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    private int exit() {
        return 0;
    }

    public static void main(String[] args) {
        new Menu();
    }
}
