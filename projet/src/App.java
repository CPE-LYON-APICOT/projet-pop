import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        /* Création des items */
        ArrayList<Item> listItems = new ArrayList<>();
        Item item1 = new Candy(0, 2, 1.2);
        Item item2 = new Candy(4, 5, 0.2);
        Item item3 = new Wall(4, 2);
        Item item4 = new Wall(16, 14);
        Item item5 = new Fruit(19, 19);
        listItems.add(item1);
        listItems.add(item2);
        listItems.add(item3);
        listItems.add(item4);
        listItems.add(item5);

        Grid game = new Grid(20, 20);
        game.initGrid();
        Snake snek = new Snake(10, 10);
        game.addSnake(snek);
        SnakeController controls = new SnakeController(snek, game);
        // game.updateSnakePos(snek);
        // game.displayGrid();
        // game.moveSnake(snek, Direction.UP);
        // game.updateSnakePos(snek);
        // game.displayGrid();

        game.generateItem(listItems);

        Frame test = new Frame("test");
        test.setLayout(new FlowLayout());
        test.setSize(500, 500);
        Label l = new Label();
        l.setText("This is a demonstration");
        test.add(l);
        test.setVisible(true);

        test.addKeyListener(controls);

        while (true) {
            controls.moveSnake();
            game.updateSnakePos();
            game.displayGrid();
            // game.moveSnake(snek, Direction.RIGHT);
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

}
