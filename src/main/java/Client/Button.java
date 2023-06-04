package Client;

import javax.swing.*;

public class Button {
    JButton button;

    Button(String text, int x, int y, int width, int height, JPanel panel) {
        initButton(text, x, y, width, height);
        panel.add(this.getButton());
    }

    private void initButton(String text, int x, int y, int width, int height) {
        this.button = new JButton();
        this.button.setLocation(x, y);
        this.button.setSize(width, height);
        this.button.setText(text);
    }

    public JButton getButton() {
        return button;
    }
}



