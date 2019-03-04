import java.awt.*;

public class Sprite {
    private int x,y,width,height;
    private double dx=1,dy=0;
    private Color color;
    public Sprite(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y ;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public void move(){
        x += dx*width;
        y += dy*height;
    }
    public void paint(Graphics g){
        g.fillRect(x,y,width,height);
    }
}
