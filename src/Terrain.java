import java.awt.*;

public class Terrain extends Sprite{
    public Terrain(int x, int y,int y2, int width){
        super(x,y,width,100, Color.black);
        setY2(y2);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillPolygon(new int[]{getX(),getX()+20,getX()+20,getX()},new int[]{getY(),getY2(),600,600},4);
    }

    public Polygon getBounds(){
        return new Polygon();
    }
}
