import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {

        /* Création des items */
        ArrayList<Item> listItems = new ArrayList<>();
       
        Item item3 = new Wall(4, 2);
        Item item4 = new Wall(16, 14);
        
        listItems.add(item3);
        listItems.add(item4);

        Grid game = new Grid(20, 20);
        game.initGrid();
        Snake snek = new Snake(10, 10);
        game.addSnake(snek);
        SnakeController controls = new SnakeController(snek, game);

        game.generateItem(listItems);

        JFrame f = new JFrame("label");
        JLabel l = new JLabel();
        JPanel p = new JPanel();

        l.setFont(new Font("Monospaced", Font.PLAIN, 20));

        p.add(l);
 
        f.add(p);
        f.setSize(1000, 700);
        f.setVisible(true);

        f.addKeyListener(controls);
        
        System.out.println("hauteur : " + game.getHeight() + "largeur : " + game.getWidth());
        while (!(snek.tailTouched() || game.snakeOutOfBounds())) {
            // game.getSnake().IncreaseSize();
            controls.moveSnake();
            game.updateSnakePos();
            game.getSnake().updateDirections(game.getSnake().getDirection());
            // System.out.println(game.getSnake().getLastDirections());
            
            // game.displayGrid();
            
            l.setText("<html>" + game.getGrid() + "</html>");

            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("fin partie");
    }

}
