import java.awt.*;
import java.awt.geom.Line2D;

public class Terrain{
    private Line2D[] line;
    private Color color;
    public Terrain(Line2D[] line, Color color){
        this.line = line;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(color);
        for(int i = 0; i < line.length; i++){
            g.drawLine((int)line.getX1(),(int)line.getY1(),(int)line.getX2(),(int)line.getY2());
        }
    }

    public Line2D[] getBounds() {
        return line;
    }

    public Line2D[] getLine() {
        return line;
    }
}
