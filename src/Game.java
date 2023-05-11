import javax.swing.*;

public class Game {
    private Player activePlayer;
    private Player whitePlayer = new Player(0);
    private Player blackPlayer = new Player(1);

    JFrame gameFrame = new Board().getFrame();

    public Game() throws Exception {
        createPlayers();

    }

    private void createPlayers() throws Exception {
        this.whitePlayer = new Player(0);
        this.blackPlayer = new Player(1);
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
}

