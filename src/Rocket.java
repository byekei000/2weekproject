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
        g.setColor(Color.red);
        g.fillPolygon(new int[]{-getWidth()/2,0,getWidth()/2}, new int[]{-getHeight()/2,-getHeight()/2-15,-getHeight()/2},3);
        g.fillPolygon(new int[]{-getWidth()/2,-getWidth()/2-10,-getWidth()/2}, new int[]{getHeight()/2,getHeight()/2,0},3);
        g.fillPolygon(new int[]{getWidth()/2,getWidth()/2+10,getWidth()/2}, new int[]{getHeight()/2,getHeight()/2,0},3);
        if(isThrusting()){
            g.fillPolygon(new int[]{-getWidth()/2,-getWidth()/3,-getWidth()/6}, new int[]{getHeight()/2,getHeight()/2+10,getHeight()/2},3);
            g.translate(getWidth()/3,0);
            g.fillPolygon(new int[]{-getWidth()/2,-getWidth()/3,-getWidth()/6}, new int[]{getHeight()/2,getHeight()/2+10,getHeight()/2},3);
            g.translate(getWidth()/3,0);
            g.fillPolygon(new int[]{-getWidth()/2,-getWidth()/3,-getWidth()/6}, new int[]{getHeight()/2,getHeight()/2+10,getHeight()/2},3);
        }
        ((Graphics2D) g).setTransform(old);
    }
}
