package tp.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import tp.Interfaces.iItem;
import tp.Model.Snake;
import tp.Services.ObjetService;
import tp.Services.SnakeSingleton;

@Component
public class Grid {
    private Integer height;
    private Integer width;
    private Snake snake;
    private Integer[][] grid;
    private ObjetService objetService;

    public ObjetService getObjetService() {
        return objetService;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Grid(SnakeSingleton snakeSingleton, ObjetService objetService) {
        this.objetService = objetService;
        this.snake = snakeSingleton.getInstance();
        this.height = objetService.getGrid_height();
        this.width = objetService.getGrid_width();
        this.grid = new Integer[this.height][this.width];
        initGrid();
        generateItem(objetService.getListItems());
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
        List<String> colors = Arrays.asList("#732d00", "green", "#535353", "#535353", "#15e700", "#15e700", "#ff953c", "#ff953c", "#ff0b0b", "#ff0b0b");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res += "<font color='" + colors.get(grid[i][j]) + "'>" + grid[i][j] + "</font> ";
            }
            res += "<br>";
        }
        res += "<br>";
        return res;
    }

    public Snake getSnake() {
        return snake;
    }

    public boolean snakeOutOfBounds() {
        if (snake.getX() >= width || snake.getX() < 0 || snake.getY() >= height || snake.getY() < 0) {
            return true;
        }
        return false;
    }

    public void updateSnakePos() {
        if (!(snakeOutOfBounds())) {
            Integer snakeX = this.snake.getX();
            Integer snakeY = this.snake.getY();

            List<Entry<Integer, Integer>> last_positions = this.snake.getLastPositions();

            if (last_positions.size() >= this.snake.getSize()) {
                List<Entry<Integer, Integer>> positions = last_positions.reversed().subList(0, this.snake.getSize());

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
        }

    }

    public void generateItem(List<iItem> itemList) {
        for (iItem item : itemList) {
            int number;
            switch (item.getClass().getName()) {
                case "tp.Model.basicFruit":
                    number = 2;
                    break;
    
                case "tp.Model.basicCandy":
                    number = 3;
                    break;
    
                case "tp.Decorators.greenFruitDecorator":
                    number = 4;
                    break;
    
                case "tp.Decorators.greenCandyDecorator":
                    number = 5;
                    break;
    
                case "tp.Decorators.orangeFruitDecorator":
                    number = 6;
                    break;
    
                case "tp.Decorators.orangeCandyDecorator":
                    number = 7;
                    break;

                case "tp.Decorators.redFruitDecorator":
                    number = 8;
                    break;

                case "tp.Decorators.redCandyDecorator":
                    number = 9;
                    break;
                default:
                    number = 99;
    
                }
            this.grid[item.getY()][item.getX()] = number;
        }
        

    }
}