package tp.Controllers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.AbstractMap;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import tp.Services.SnakeSingleton;
import tp.View.Grid;
import tp.enums.Direction;
@Component
public class SnakeController implements KeyListener {
    private tp.Model.Snake snake;

    public SnakeController(SnakeSingleton snake, Grid grid) {
        this.snake = snake.getInstance();
    }

    //MOUVEMENTS
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.snake.setValidDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                this.snake.setValidDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                this.snake.setValidDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                this.snake.setValidDirection(Direction.LEFT);
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void moveSnake() {
        Integer last_x = this.snake.getX();
        Integer last_y = this.snake.getY();
        Direction direction = this.snake.getDirection();

        switch (direction) {
            case UP: 
                last_y--;
                break;
            case DOWN: 
                last_y++;
                break;
            case RIGHT: 
                last_x++;
                break;
            case LEFT: 
                last_x--;
                break;
        }
        Entry<Integer,Integer> new_pos = new AbstractMap.SimpleEntry<>(last_x,last_y);
        this.snake.move(new_pos);
    }
}
