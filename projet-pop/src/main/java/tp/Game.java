package tp;

import java.awt.Font;
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
       
    

        JFrame f = new JFrame("label");
        JLabel l = new JLabel();
        JPanel p = new JPanel();
        JLabel score = new JLabel("score : ");

        l.setFont(new Font("Monospaced", Font.PLAIN, 20));

        score = new JLabel("score : "+grid.getSnake().getPoints());
        score.setFont(new Font("Monospaced", Font.PLAIN, 10));
        
        p.add(l);
        p.add(score);
        f.add(p);
        
        f.setSize(1000, 700);
        f.setVisible(true);

        f.addKeyListener(snakeController);
        
        // System.out.println("hauteur : " + grid.getHeight() + "largeur : " + grid.getWidth());
        Integer defaultGameSpeed = 500;

        while (!(snakeSingleton.getInstance().tailTouched() || grid.snakeOutOfBounds())) {
            // grid.getSnake().IncreaseSize();
            snakeController.moveSnake();
            grid.updateSnakePos();
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

