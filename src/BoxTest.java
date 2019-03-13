import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

public class BoxTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 600;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Drawing a box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxComponent component = new BoxComponent();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(component, BorderLayout.CENTER);


        JButton button = new JButton("Reset");
        panel.add(button, BorderLayout.SOUTH);

        frame.add(panel);

        class resetListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                component.setPos(100,200);
                component.box2.setLocation(0,0);
                component.box3.setLocation(150, 0);
            }
        }
        resetListener listener1 = new resetListener();
        button.addActionListener(listener1);

        class MousePressListener implements MouseListener {
            public void mousePressed(MouseEvent event) {}
            public void mouseReleased(MouseEvent  event) {
                if(component.box.intersects(component.box2) &&
                        component.box.getX() > component.box2.getX() &&
                        component.box.intersects(component.box3) &&
                        component.box.getX() < component.box3.getX()) {
                    component.setPos((int) component.box2.getX() + 150, (int) component.box2.getY());
                    component.box3.setLocation((int) component.box.getX() + 150, (int) component.box.getY());
                } else if(component.box.intersects(component.box3) &&
                        component.box.getX() > component.box3.getX()) {
                    component.setPos((int) component.box3.getX() + 150, (int) component.box3.getY());
                } else if (component.box.intersects(component.box2) &&
                        component.box.getX() < component.box2.getX()) {
                    component.setPos(0, 0);
                    component.box2.setLocation((int) component.box.getX() + 150, (int) component.box.getY());
                    component.box3.setLocation((int) component.box2.getX() + 150, (int) component.box2.getY());
                }
            }
            public void mouseClicked(MouseEvent event) {}
            public void mouseEntered(MouseEvent event) {}
            public void mouseExited(MouseEvent event) {}
        }
        MouseListener mListener = new MousePressListener();
        component.addMouseListener(mListener);

        class MouseMotion implements MouseMotionListener {
            public void mouseDragged(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                component.setPos(x ,y);
            }

            public void mouseMoved(MouseEvent event) {}
        }

        MouseMotion motionListener = new MouseMotion();
        component.addMouseMotionListener(motionListener);

        frame.setVisible(true);
    }
}

class BoxComponent extends JComponent {
    Rectangle box;
    int x;
    int y;
    int height;
    int width;
    Rectangle box2;
    Rectangle box3;

    BoxComponent(){
        x = 100;
        y = 200;
        height = width = 150;
        box = new Rectangle(x, y, width, height);

        box2 = new Rectangle(0, 0, 150, 150);
        box3 = new Rectangle(150, 0, 150, 150);
    }

    public void setPos(int x, int y ) {
        this.x = x;
        this.y = y;
        box = new Rectangle(x, y, width, height);
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        String text = "Rectangle";
        //box.setLocation(200,100);
        ////////
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        g2.setFont(font);
        int textWidth = (int) font.getStringBounds(text, context).getWidth();
        LineMetrics ln = font.getLineMetrics(text, context);
        int textHeight = (int) (ln.getAscent() + ln.getDescent());
        int x1 = x + (width - textWidth)/2;
        int y1 = (int)(y + (height + textHeight)/2 - ln.getDescent());
        g2.setColor(Color.GRAY);
        g2.fill(box);
        /////////
        g2.drawString(text, x1, y1);
        g2.draw(box);

        g2.setColor(Color.ORANGE);
        g2.fill(box2);
        g2.draw(box2);

        g2.setColor(Color.BLUE);
        g2.fill(box3);
        g2.draw(box3);
    }
}