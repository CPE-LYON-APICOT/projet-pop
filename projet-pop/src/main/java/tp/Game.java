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

        l.setFont(new Font("Monospaced", Font.PLAIN, 20));

        p.add(l);
 
        f.add(p);
        f.setSize(1000, 700);
        f.setVisible(true);

        f.addKeyListener(snakeController);
        
        // System.out.println("hauteur : " + grid.getHeight() + "largeur : " + grid.getWidth());
        Integer defaultGameSpeed = 1500;

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
            
            //System.out.println(grid.getObjetService().getListItems());
            
            TimeUnit.MILLISECONDS.sleep(newSpeed);
        }
        System.out.println("fin partie");
    }
}

