import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {
    Timer timer;
    private List<Sprite> sprites = new ArrayList<>();
    public Board(){
        setPreferredSize(new Dimension(800,600));
        setBackground(Color.darkGray);
        timer = new Timer(1000, this);
        timer.start();
    }
    public void init(){
        sprites.add(new Sprite(100,100,25,25,Color.pink));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        sprites.get(0).paint(g);
    }

    public void actionPerformed(ActionEvent e) {
        sprites.get(0).move();
        repaint();
    }
}
