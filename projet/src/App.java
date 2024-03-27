import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        Grid game = new Grid(20,20);
        game.initGrid();
        Snake snek = new Snake(10,10);
        game.addSnake(snek);
        // game.updateSnakePos(snek);
        // game.displayGrid();
        // game.moveSnake(snek, Direction.UP);
        // game.updateSnakePos(snek);
        // game.displayGrid();

        Frame test = new Frame("test");
        test.setLayout(new FlowLayout());
        test.setSize(500, 500);
        Label l = new Label();
        l.setText("This is a demonstration");
        test.add(l);
        test.setVisible(true);

        test.addKeyListener(game);

        while (true) {
            game.moveSnake();
            game.updateSnakePos();
            game.displayGrid();
            // game.moveSnake(snek, Direction.RIGHT);
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
