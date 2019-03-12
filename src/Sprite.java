import java.awt.*;

public class Sprite {
    private int width,height,theta = 0;
    private double G = 0.098;
    private double terminalVelocity = 150*G;
    private double x,y,dx=0,dy=0;
    private Color color;
    private boolean thrusting = false;
    public Sprite(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),width,height);
    }
    public void move(){
        x += dx;
        y += dy;
        if(dy <= terminalVelocity){
            dy += G;
        }
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(getX(),getY(),width,height);
    }

    public int getX() {
        return (int)x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return (int)y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getG() {
        return G;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTheta() {
        return theta;
    }

    public void setTheta(int theta) {
        this.theta = theta;
    }

    public void setThrusting(boolean thrusting) {
        this.thrusting = thrusting;
    }

    public boolean isThrusting() {
        return thrusting;
    }

    public void setG(double g) {
        G = g;
    }
}
