import java.util.List;
import java.util.Map.Entry;

public class Grid {
    private Integer height;
    private Integer width;
    private Snake snake;
    private Integer[][] grid;

    public Integer getHeight() {
        return height;
    }
    public Integer getWidth() {
        return width;
    }
    
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
    
    public String getGrid() {
        String res = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res += grid[i][j] + " ";
            }
            res += "<br>";
        }
        res += "<br>";
        return res;
    }
    
    public Snake getSnake() {
        return snake;
    }
    
    public void addSnake(Snake snake) {
        this.snake = snake;
    }

    public void updateSnakePos() {
        Integer snakeX = this.snake.getX();
        Integer snakeY = this.snake.getY();
        
        
        List<Entry<Integer,Integer>> last_positions = this.snake.getLastPositions();

        if (last_positions.size() >= this.snake.getSize()) {
            List<Entry<Integer,Integer>> positions = last_positions.reversed().subList(0, this.snake.getSize());

            for (Entry<Integer,Integer> i : last_positions) {
                if (positions.contains(i)) {
                    this.grid[i.getValue()][i.getKey()] = 1;
                } else {
                    this.grid[i.getValue()][i.getKey()] = 0;
                }
            }
        } else {
            this.grid[snakeY][snakeX] = 1;
        }

    }

    public void generateItem(List<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            this.grid[itemList.get(i).x][itemList.get(i).y] = 5;
        }
    }
}
