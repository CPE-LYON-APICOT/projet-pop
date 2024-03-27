public class Grid {
    private Integer height;
    private Integer width;
    private Integer maxSnakeSize;
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

    public void updateSnakePos(Snake snake) {
        Integer snakeX = snake.getPos().getKey();
        Integer snakeY = snake.getPos().getValue();

        this.grid[snakeX][snakeY] = 1;
    }
}
