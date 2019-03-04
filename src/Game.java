import javax.swing.*;

public class Game extends JFrame {
    public Game(){
        setTitle("New Game");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
        Board board  = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
        board.init();
    }
    public static void main(String[] args){
        new Game();
    }
}
