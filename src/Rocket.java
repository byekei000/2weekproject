import java.awt.*;
import java.awt.geom.AffineTransform;

public class Rocket extends Sprite{
    public Rocket(int x, int y, int width, int height, Color color){
        super(x,y,width,height,color);
    }
    public void paint(Graphics g){
        AffineTransform old = ((Graphics2D) g).getTransform();
        g.translate(getX(),getY());
        ((Graphics2D) g).rotate(Math.toRadians(getTheta()));
        g.setColor(getColor());
        g.fillRect(-getWidth()/2,-getHeight()/2,getWidth(),getHeight());
        ((Graphics2D) g).setTransform(old);
    }
}
