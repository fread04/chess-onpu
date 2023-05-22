import javax.swing.*;
import java.util.concurrent.atomic.AtomicReference;

public class Menu {
    private JFrame frame;
    private JPanel menuPanel;
    private JPanel playPanel;
    private JPanel settingsPanel;
    private JPanel hostPanel;
    private JPanel joinPanel;

    public Menu() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(700, 200,  532, 552);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 532, 552);
        menuPanel.setLayout(null);
        frame.add(menuPanel);

        playPanel = new JPanel();
        playPanel.setBounds(0, 0, 532, 552);
        playPanel.setLayout(null);

        settingsPanel = new JPanel();
        settingsPanel.setBounds(0, 0, 532, 552);
        settingsPanel.setLayout(null);

        hostPanel = new JPanel();
        hostPanel.setBounds(0, 0, 532, 552);
        hostPanel.setLayout(null);

        joinPanel = new JPanel();
        joinPanel.setBounds(0, 0, 532, 552);
        joinPanel.setLayout(null);

        switchToMainMenu();

        frame.setVisible(true);
    }

    private void switchToMainMenu() {
        removeAllPanels();
        frame.getContentPane().add(menuPanel);

        JButton playButton = new JButton("Play");
        playButton.setBounds(100, 30, 100, 30);
        playButton.addActionListener(e -> switchToPlayMenu());
        menuPanel.add(playButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(100, 70, 100, 30);
        settingsButton.addActionListener(e -> switchToSettingsMenu());
        menuPanel.add(settingsButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 110, 100, 30);
        exitButton.addActionListener(e -> System.exit(0));
        menuPanel.add(exitButton);

        menuPanel.setVisible(true);
        frame.revalidate();
    }

    private void switchToPlayMenu() {
        removeAllPanels();

        JButton hostButton = new JButton("Host");
        hostButton.setBounds(100, 30, 100, 30);
        hostButton.addActionListener(e -> switchToHostMenu());
        playPanel.add(hostButton);

        JButton joinButton = new JButton("Join");
        joinButton.setBounds(100, 70, 100, 30);
        joinButton.addActionListener(e -> switchToJoinMenu());
        playPanel.add(joinButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 110, 100, 30);
        backButton.addActionListener(e -> switchToMainMenu());
        playPanel.add(backButton);

        frame.getContentPane().add(playPanel);
        playPanel.setVisible(true);
        frame.revalidate();
    }

    private void switchToHostMenu() {
        removeAllPanels();
        AtomicReference<JFrame> gameFrame = null;

        JButton whiteButton = new JButton("White");
        whiteButton.setBounds(40, 30, 100, 30);
        whiteButton.addActionListener(e -> gameFrame.set(new Board().getFrame()));
        hostPanel.add(whiteButton);

        JButton randomButton = new JButton("Random");
        randomButton.setBounds(170, 30, 100, 30);
        hostPanel.add(randomButton);

        JButton blackButton = new JButton("Black");
        blackButton.setBounds(300, 30, 100, 30);
        hostPanel.add(blackButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(170, 70, 100, 30);
        backButton.addActionListener(e -> switchToPlayMenu());
        hostPanel.add(backButton);

        frame.getContentPane().add(hostPanel);
        hostPanel.setVisible(true);
        frame.revalidate();
    }

    private void switchToJoinMenu() {
        removeAllPanels();

        JButton backButton = new JButton("Back");
        backButton.setBounds(170, 70, 100, 30);
        backButton.addActionListener(e -> switchToPlayMenu());
        joinPanel.add(backButton);

        frame.getContentPane().add(joinPanel);
        joinPanel.setVisible(true);
        frame.revalidate();
    }

    private void switchToSettingsMenu() {
        removeAllPanels();

        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 110, 100, 30);
        backButton.addActionListener(e -> switchToMainMenu());
        settingsPanel.add(backButton);

        frame.getContentPane().add(settingsPanel);
        settingsPanel.setVisible(true);
        frame.revalidate();
    }

    private void removeAllPanels() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
