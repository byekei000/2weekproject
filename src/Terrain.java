import java.awt.*;

public class Terrain{
    private Polygon polygon;
    private Color color;
    public Terrain(Polygon polygon, Color color){
        this.polygon = polygon;
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillPolygon(polygon);
    }
    public Polygon getBounds() {
        return polygon;
    }
}
