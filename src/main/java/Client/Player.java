package Client;

public class Player {
    private final boolean color;
    private boolean isActiveTurn;

    public Player(boolean color) {
        this.color = color;
        isActiveTurn = this.color;
    }

    public boolean getColor() {
        return color;
    }

    public boolean isActiveTurn() {
        return isActiveTurn;
    }

    public void switchTurn() {
        isActiveTurn = !isActiveTurn;
    }
}
