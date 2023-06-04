package Client;

import javax.swing.*;

abstract class Panel {
    private final JPanel panel = new JPanel();

    private JFrame frame;

    Panel(JFrame frame, int x, int y, int width, int height) {
        this.frame = frame;
        initPanel(x, y, width, height);
    }

    private void initPanel(int x, int y, int width, int height) {
        this.panel.setBounds(x, y, width, height);
        addButtons();
        this.frame.add(this.panel);
    }

    public abstract void addButtons();

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }
}


