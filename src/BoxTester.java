import javax.swing.*;
import java.awt.*;

public class BoxTester extends JFrame {
    final int FRAME_WIDTH = 400;
    final int FRAME_HEIGHT = 400;
    Rectangle box;

    public BoxTester{
        box = new Rectangle(10,10, 100, 100);
        setTitle("Box Tester");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        draw(g2);
    }

    public void draw(Graphics2D g) {
        Graphics2D g2 = (Graphics2D) g;


    }
}
