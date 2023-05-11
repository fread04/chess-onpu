public class Player {

    private final int color;
    private int activeTurn;

    public Player(int color) throws Exception {
        if(color < -1 || color > 1) {
            throw new IllegalArgumentException("value  may be within [0, 1]");
        } else this.color = color;
    }

    public void setActiveTurn(int activeTurn) throws Exception {
        if(activeTurn < -1 || activeTurn > 1) {
            throw new IllegalArgumentException("value  may be within [0, 1]");
        } else this.activeTurn = activeTurn;
    }

    public int getColor() {
        return color;
    }

    public int getActiveTurn() {
        return activeTurn;
    }
}

