import java.awt.*;

public class Landing extends Terrain{
    public Landing(int x, int y, int width, Color color, Board board){
        super(new Polygon(new int[]{x,x+width,x+width,x}, new int[]{y,y,board.getHeight(),board.getHeight()}, 4), color);
    }
}
