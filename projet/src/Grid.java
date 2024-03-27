import java.util.AbstractMap;
import java.util.Map.Entry;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Grid implements KeyListener {
    private Integer height;
    private Integer width;
    private Integer maxSnakeSize;
    private Snake snake;
    private Integer [][] grid;

    public Grid(Integer height, Integer width) {
        this.height = height;
        this.width = width;
        this.grid = new Integer[this.height][this.width];
        this.maxSnakeSize = this.height * this.width;
    }

    public void initGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void displayGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void addSnake(Snake snake) {
        this.snake = snake;
    }

    public void updateSnakePos() {
        Integer snakeX = this.snake.getX();
        Integer snakeY = this.snake.getY();

        this.grid[snakeY][snakeX] = 1;
    }

    //MOUVEMENTS
    @Override
    public void keyTyped(KeyEvent e) {
        // System.out.println(e.getKeyCode());
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("VK_UP");
                this.snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("VK_DOWN");
                this.snake.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("VK_RIGHT");
                this.snake.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("VK_LEFT");
                this.snake.setDirection(Direction.LEFT);
                break;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // System.out.println(e.getKeyCode());
        
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
