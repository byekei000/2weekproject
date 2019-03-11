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
        sprites.clear();
        sprites.add(new Rocket(50,50,25,40,Color.pink));
        generateTerrain();
    }
    public void generateTerrain(){
        for(int i = 0; i < 20; i++){
            int newY = (int)(Math.random()*100+400);
            sprites.add(new Landing(i*40,newY,20));
            sprites.add(new Terrain(i*40+40,newY 20));
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(int i = 0; i < sprites.size(); i++){
            sprites.get(i).paint(g);
        }
        g.setColor(Color.black);
        g.fillRect(0,500,getWidth(),getHeight()-500);
        g.setColor(Color.blue);
        g.fillRect(500,490,50,10);
    }

    public void explode(Graphics g){
        g.setColor(Color.orange);
        g.fillOval(sprites.get(0).getX()-sprites.get(0).getWidth(),sprites.get(0).getY()-sprites.get(0).getHeight(), 100,100 );
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){

        }
        init();
    }

    public void actionPerformed(ActionEvent e) {
        thrust();
        sprites.get(0).move();
        if(sprites.get(0).getBounds().intersects(new Rectangle(500,490,50,10))){
            sprites.get(0).setDx(0);
            sprites.get(0).setDy(0);
            sprites.get(0).setY(490 - sprites.get(0).getHeight() / 2);
        } else if(sprites.get(0).getY() >= 500 - sprites.get(0).getHeight()/2){
            if(sprites.get(0).getDx() + sprites.get(0).getDy() >= 5 ||
                    Math.abs(sprites.get(0).getTheta())%360 <= 330 &&
                            Math.abs(sprites.get(0).getTheta())%360 >= 30){
                explode(getGraphics());
            }
            sprites.get(0).setDx(0);
            sprites.get(0).setDy(0);
            sprites.get(0).setY(500 - sprites.get(0).getHeight() / 2);
        } else turn();
        repaint();
    }
    public void turn(){
        if(d){
            sprites.get(0).setTheta((sprites.get(0).getTheta())+2);
        } else if(a){
            sprites.get(0).setTheta((sprites.get(0).getTheta())-2);
        }
    }
    public void thrust(){
        if(w){
            sprites.get(0).setDx(sprites.get(0).getDx()+0.05*Math.sin(Math.toRadians(sprites.get(0).getTheta())));
            sprites.get(0).setDy(sprites.get(0).getDy()-0.05*Math.cos(Math.toRadians(sprites.get(0).getTheta())));
            sprites.get(0).setThrusting(true);
        } else sprites.get(0).setThrusting(false);
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
