import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private boolean w,a,d,space;
    private List<Sprite> sprites = new ArrayList<>();
    public Board(){
        setPreferredSize(new Dimension(800,600));
        setBackground(Color.darkGray);
        timer = new Timer(1000/60, this);
        timer.start();
    }
    public void init(){
        sprites.add(new Rocket(100,100,25,40,Color.pink));
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        sprites.get(0).paint(g);
        g.fillRect(0,400,getWidth(),getHeight()-400);
    }

    public void actionPerformed(ActionEvent e) {
        turn();
        thrust();
        sprites.get(0).move();
        if(sprites.get(0).getY() >= 400 - sprites.get(0).getHeight()/2){
            sprites.get(0).setDx(0);
            sprites.get(0).setDy(0);
        }
        repaint();
    }
    public void turn(){
        if(d){
            sprites.get(0).setTheta((sprites.get(0).getTheta())+5);
        } else if(a){
            sprites.get(0).setTheta((sprites.get(0).getTheta())-5);
        }
    }
    public void thrust(){
        if(w){
            sprites.get(0).setDx(sprites.get(0).getDx()+0.2*Math.sin(Math.toRadians(sprites.get(0).getTheta())));
            sprites.get(0).setDy(sprites.get(0).getDy()-0.2*Math.cos(Math.toRadians(sprites.get(0).getTheta())));
        }
    }

    public void setW(boolean w){
        this.w = w;
    }
    public void setA(boolean a){
        this.a = a;
    }
    public void setD(boolean d){
        this.d = d;
    }
}
