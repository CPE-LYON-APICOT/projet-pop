package tp;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import org.springframework.stereotype.Component;

import tp.Controllers.SnakeController;
import tp.Services.SnakeSingleton;
import tp.View.Grid;


@Component
public class Game {
    private SnakeSingleton snakeSingleton;
    private Grid grid;
    private SnakeController snakeController;

    public Game(SnakeSingleton snakeSingleton, Grid grid, SnakeController snakeController) {
        
        this.snakeSingleton = snakeSingleton;
        this.grid = grid;
        this.snakeController = snakeController;
    }

    public void launch() throws InterruptedException {
        JFrame f = new JFrame("Snake");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1300, 800);
        f.setLayout(null);
        f.setVisible(true);
        
        f.addKeyListener(snakeController);
        JLabel l = new JLabel();
        l.setFont(new Font("Monospaced", Font.BOLD, 40));
        JLabel score = new JLabel("score : ");
        score = new JLabel("score : "+grid.getSnake().getPoints());
        score.setFont(new Font("Monospaced", Font.PLAIN, 40));
        
        JPanel p = new JPanel(null);
        p.setBounds(0, 0, f.getWidth(), f.getHeight());
        l.setBounds(50, 0, 500, 600);   
        score.setBounds(f.getWidth() - 700, 20, 3000, 40);

        p.add(l);
        p.add(score);

        f.add(p);

        // f.addComponentListener(new ComponentAdapter() {
        //     public void componentResized(ComponentEvent evt) {
        //         // Adjust the score label position dynamically
        //         score.setBounds(f.getWidth() - 300, 20, 250, 40);  // Adjust position and size dynamically
        //         p.setBounds(0, 0, f.getWidth(), f.getHeight());  // Adjust panel bounds
        //     }
        // });

        // Revalidate and repaint to ensure proper layout
        f.revalidate();
        f.repaint();

        // Dimension size = score.getPreferredSize();
        // score.setBounds(0,0, size.width, size.height);
        // score.setBounds(f.getWidth()/10, f.getHeight()/10, 100, 30);

        
        // System.out.println("hauteur : " + grid.getHeight() + "largeur : " + grid.getWidth());
        Integer defaultGameSpeed = 500;

        while (!(snakeSingleton.getInstance().tailTouched() || grid.snakeOutOfBounds() /*|| grid.getSnake().getSize() == grid.getHeight() * grid.getWidth()*/)) {
            // grid.getSnake().IncreaseSize();
            if (grid.getSnake().getSize() == grid.getHeight() * grid.getWidth()) {
                break;
            }
            snakeController.moveSnake();
            grid.updateSnakePos();
            // System.out.println(grid.getSnake().getCurrentPosition());
            System.out.println(grid.getSnake().getX());
            grid.getSnake().updateDirections(grid.getSnake().getDirection());
            // System.out.println(grid.getSnake().getLastDirections());
            grid.generateItem(grid.getObjetService().getListItems());
            // grid.displayGrid();
            l.setText("<html>" + grid.getGrid() + "</html>");
            Integer newSpeed = (int) Math.floor(defaultGameSpeed/grid.getSnake().getSpeed());
            score.setText("score : "+grid.getSnake().getPoints());

            //System.out.println(grid.getObjetService().getListItems());
            
            TimeUnit.MILLISECONDS.sleep(newSpeed);
            
        }
        System.out.println("fin partie");
    }
}

