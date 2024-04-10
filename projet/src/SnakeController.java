import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.AbstractMap;
import java.util.Map.Entry;

public class SnakeController implements KeyListener {
    private Snake snake;

    public SnakeController(Snake snake, Grid grid) {
        this.snake = snake;
    }

    //MOUVEMENTS
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                // System.out.println("VK_UP");
                this.snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                // System.out.println("VK_DOWN");
                this.snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                // System.out.println("VK_RIGHT");
                this.snake.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                // System.out.println("VK_LEFT");
                this.snake.setDirection(Direction.LEFT);
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
