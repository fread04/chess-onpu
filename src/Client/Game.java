package Client;

import javax.swing.*;
import java.util.Objects;

public class Game {
    private Player activePlayer;
    private Player whitePlayer;
    private Player blackPlayer;
    Board board = new Board();
    JFrame gameFrame = board.getFrame();


    public Game() throws Exception {
        createPlayers();

    }

    private void createPlayers() throws Exception {
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
    public JFrame getGameFrame() {
        return gameFrame;
    }

}
/**
*вынести фрейм из доски

*/
