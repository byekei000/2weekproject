import java.awt.*;
import java.awt.geom.Line2D;

public class Mountain extends Terrain{
    public Mountain(int magnitude, Color color){
        super(new Line2D[]{new Line2D.Double(3,4,5,6)}, color);
    }
}
