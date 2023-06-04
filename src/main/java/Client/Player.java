package Client;

import java.util.Objects;

public class Player {

    private final String color;
    private boolean activeTurn;

    public Player(String color) {
        if(Objects.equals(color, "white") || Objects.equals(color, "black")) {
            this.color = color;
        } else throw new IllegalArgumentException("value may be 'white' or 'black'");;
    }

    public void setActiveTurn(boolean activeTurn) {
        this.activeTurn = activeTurn;
    }

    public String getColor() {
        return color;
    }

    public boolean getActiveTurn() {
        return activeTurn;
    }
}

