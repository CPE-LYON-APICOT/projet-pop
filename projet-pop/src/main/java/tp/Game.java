package tp;

import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import javax.swing.*;

import org.springframework.stereotype.Component;

import tp.Controllers.SnakeController;
import tp.Services.SnakeSingleton;
import tp.View.Grid;


@Component
public class Game {
    private SnakeSingleton snakeSingleton;
    private Grid game;
    private SnakeController snakeController;

    public Game(SnakeSingleton snakeSingleton, Grid game, SnakeController snakeController) {
        
        this.snakeSingleton = snakeSingleton;
        this.game = game;
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
        
        // System.out.println("hauteur : " + game.getHeight() + "largeur : " + game.getWidth());
        while (!(snakeSingleton.getInstance().tailTouched() || game.snakeOutOfBounds())) {
            // game.getSnake().IncreaseSize();
            snakeController.moveSnake();
            game.updateSnakePos();
            game.getSnake().updateDirections(game.getSnake().getDirection());
            // System.out.println(game.getSnake().getLastDirections());
            
            // game.displayGrid();
            
            l.setText("<html>" + game.getGrid() + "</html>");

            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("fin partie");
    }
}

