import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class chessGame {
    public static void main(String[] args) throws IOException {

        JFrame gameFrame = new Board().getFrame();
    }
}



/*
        final BufferedImage image = ImageIO.read(new File("C:/Users/Professional/IdeaProjects/chess-onpu/img/b_rook_png_128px.png"));

        JPanel pane = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        pane.setBounds(0, 0, 500, 500);

        gameFrame.add(pane);
        gameFrame.repaint();

        JPanel panel = new JPanel();
        panel.setBounds(728, 728, 10, 10);
        panel.setBackground(Color.BLACK);

        gameFrame.add(panel);
*/


//new Color(106, 119, 135)
//new Color(42, 47, 54)