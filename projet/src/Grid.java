import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Grid {
    private Integer height;
    private Integer width;
    private Snake snake;
    private Integer[][] grid;

    public Grid(Integer height, Integer width) {
        this.height = height;
        this.width = width;
        this.grid = new Integer[this.height][this.width];
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
                System.out.print(grid[i][j] + " ");
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

        List<Entry<Integer, Integer>> last_positions = this.snake.getLastPositions();
        // List<Entry<Integer,Integer>> last_positions =
        // this.snake.getLastPositions().subList(this.snake.getLastPositions().size()-this.snake.getSize(),
        // this.snake.getLastPositions().size());

        // A REGLER
        // Faire en sorte que les n dernières positions du serpent soient des 1, et les
        // autres des 0
        if (last_positions.size() >= this.snake.getSize()) {
            List<Entry<Integer, Integer>> positions = last_positions.reversed().subList(0, this.snake.getSize());
            System.out.println(positions);
            for (Entry<Integer, Integer> i : last_positions) {
                if (positions.contains(i)) {
                    this.grid[i.getValue()][i.getKey()] = 1;
                } else {
                    this.grid[i.getValue()][i.getKey()] = 0;
                }
            }
        } else {
            this.grid[snakeY][snakeX] = 1;
        }

        for (int i = last_positions.size(); i > 0; i--) {

            // if (i <= this.snake.getSize()) {
            // this.grid[last_positions.get(i).getValue()][last_positions.get(i).getKey()] =
            // 0;
            // }
        }
    }
}
