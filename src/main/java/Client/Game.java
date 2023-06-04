package Client;

import javax.swing.*;

public class Game {
    private Player activePlayer;
    private Player whitePlayer;
    private Player blackPlayer;
    private final Board board = new Board();
    private final JFrame gamePanel = board.getFrame();


    public Game() {
        createPlayers();
    }

    private void createPlayers() {
        this.whitePlayer = new Player("white");
        this.blackPlayer = new Player("black");
    }

    private void swapTurn() {
        if(whitePlayer.getActiveTurn()) {
            blackPlayer.setActiveTurn(true);
        } else {
            whitePlayer.setActiveTurn(true);
        }
    }

    public void makeTurn(Player p) {
        setActivePlayer(p);
    }

    public void setActivePlayer(Player p) {
        this.activePlayer = p;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
    public JFrame getGamePanel() {
        return gamePanel;
    }

    public Board getBoard() {
        return board;
    }
}
