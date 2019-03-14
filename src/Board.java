import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {
    private Timer timer;
    private Game game;
    private boolean w, a, d, space;
    private List<Sprite> sprites = new ArrayList<>();
    private List<Terrain> terrain = new ArrayList<>();
    private Terrain level1[] = {new Terrain(new Line2D.Double(0,400,100,350), Color.black),new Terrain(new Line2D.Double(100,350,200,450), Color.black),new Terrain(new Line2D.Double(200,450,300,400), Color.black),new Terrain(new Line2D.Double(300,400,400,350), Color.black),new Landing(new Line2D.Double(400,350,500,350), Color.black)};
    private int level = 1;

    public Board(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.darkGray);
        timer = new Timer(1000 / 60, this);
        timer.start();
    }

    public void init() {
        sprites.clear();
        sprites.add(new Rocket(50, 50, 25, 40, Color.white));
        generateTerrain(level);
    }

    public void generateTerrain(int lev) {
        if (lev == 1) {
            for(int i = 0; i < 5; i++){
                terrain.add(level1[i]);
            }
//            terrain.add(new Landing());
//            terrain.add(new Terrain());
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).paint(g);
        }
        for (int i = 0; i < terrain.size(); i++) {
            terrain.get(i).paint(g);
        }
        g.setColor(Color.black);
        g.fillRect(0, 500, getWidth(), getHeight() - 500);
        g.setColor(Color.blue);
        g.fillRect(500, 490, 50, 10);
    }

    public void explode(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(sprites.get(0).getX()-55, sprites.get(0).getY()-55, 110, 110);
        g.setColor(Color.orange);
        g.fillOval(sprites.get(0).getX()-50, sprites.get(0).getY()-50, 100, 100);
        g.setColor(Color.yellow);
        g.fillOval(sprites.get(0).getX()-40, sprites.get(0).getY()-40, 80, 80);
        g.setColor(Color.white);
        g.fillOval(sprites.get(0).getX()-30, sprites.get(0).getY()-30, 60, 60);
        JOptionPane.showMessageDialog(game, "You Exploded!");
    }

    public void actionPerformed(ActionEvent e) {
        thrust();
        sprites.get(0).move();
        for(int i = 0; i < terrain.size(); i++){
            if(sprites.get(0).getBounds().intersectsLine(terrain.get(i).getBounds())){
                if(terrain.get(i) instanceof Landing){
                    sprites.get(0).setDx(0);
                    sprites.get(0).setDy(0);
                    sprites.get(0).setY((int)(terrain.get(i).getLine().getY1() - sprites.get(0).getHeight() / 2));
                    JOptionPane.showMessageDialog(game, "Perfect Landing");
                    init();
                    break;
                } else {
                    explode(getGraphics());
                    init();
                    break;
                }
            }
        }
//        if (sprites.get(0).getBounds().intersects(new Rectangle(500, 490, 50, 10))) {
//            sprites.get(0).setDx(0);
//            sprites.get(0).setDy(0);
//            sprites.get(0).setY(490 - sprites.get(0).getHeight() / 2);
//        } else if (sprites.get(0).getY() >= 500 - sprites.get(0).getHeight() / 2) {
//            if (sprites.get(0).getDx() + sprites.get(0).getDy() >= 5 ||
//                    Math.abs(sprites.get(0).getTheta()) % 360 <= 330 &&
//                            Math.abs(sprites.get(0).getTheta()) % 360 >= 30) {
//                explode(getGraphics());
//            }
//            sprites.get(0).setDx(0);
//            sprites.get(0).setDy(0);
//            sprites.get(0).setY(500 - sprites.get(0).getHeight() / 2);
//        } else
            turn();
        repaint();
    }

    public void turn() {
        if (d) {
            sprites.get(0).setTheta((sprites.get(0).getTheta()) + 2);
        } else if (a) {
            sprites.get(0).setTheta((sprites.get(0).getTheta()) - 2);
        }
    }

    public void thrust() {
        if (w) {
            sprites.get(0).setDx(sprites.get(0).getDx() + 0.2 * Math.sin(Math.toRadians(sprites.get(0).getTheta())));
            sprites.get(0).setDy(sprites.get(0).getDy() - 0.2 * Math.cos(Math.toRadians(sprites.get(0).getTheta())));
            sprites.get(0).setThrusting(true);
        } else sprites.get(0).setThrusting(false);
    }

    public void setW(boolean w) {
        this.w = w;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public void setD(boolean d) {
        this.d = d;
    }
}
