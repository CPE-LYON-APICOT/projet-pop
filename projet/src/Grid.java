import java.util.List;

public class Grid {
    private Integer height;
    private Integer width;
    private Integer maxSnakeSize;
    private Snake snake;
    private Integer[][] grid;

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

        this.grid[snakeY][snakeX] = 1;
    }

    public void generateItem(List<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            this.grid[itemList.get(i).x][itemList.get(i).y] = 5;
        }
    }
}
