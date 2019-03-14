import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame {
    public Game(){
        setTitle("New Game");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
        Board board  = new Board(this);
        add(board);
        pack();
        setLocationRelativeTo(null);
        board.init();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_W){
                    board.setW(true);
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    board.setA(true);
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    board.setD(true);
                }
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode() == KeyEvent.VK_W){
                    board.setW(false);
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    board.setA(false);
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    board.setD(false);
                }
            }
        });
    }
    public static void main(String[] args){
        new Game();
    }
}
