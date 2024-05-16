package tp.Services;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Random;

// import javax.swing.RowFilter.Entry;

import org.springframework.stereotype.Component;

import tp.Model.basicFruit;
import tp.Model.Item;
import tp.Model.Snake;
import tp.View.Grid;

@SuppressWarnings({ "deprecation", "unused" })
@Component
public class ObjetService {
    private ArrayList<Item> listItems;
    private Snake instance;

        

    public ObjetService(SnakeSingleton snakeSingleton) {
        this.instance = snakeSingleton.getInstance();
        setListItems(new ArrayList<>());
        generateItemsList();
        
        instance.addObserver((e, f) -> DetectIfSnakeAteItem(e, f));

        /*
         * 
         * instance.AddObserver()
         */
    }

    public ArrayList<Item> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<Item> listItems) {
        this.listItems = listItems;
    }

    private void DetectIfSnakeAteItem(Observable e, Object f) {
        if (f instanceof Snake) {
            var sn = ((Snake) f);
            /*
             * System.out.println(sn.getX() + " " + sn.getY()+ " |" +getListItems().stream()
             * .map(p->p.getX() + " " + p.getY()).collect(Collectors.joining(", ")));
             */
            // System.out.println(getListItems().stream().toString());
            var potentialItem = getListItems().stream()
                    .filter(o -> o.getX().equals(sn.getX()) && o.getY().equals(sn.getY())).findAny();
            if (potentialItem.isPresent()) {
                Item item = potentialItem.get();
                getListItems().remove(potentialItem.get());
                generateItemsList();
                System.out.println("L'objet " + item.getClass().getName() + " a été ramassé");
                if (item.getClass().getName() == "tp.Model.basicFruit") {
                    basicFruit fruit = (basicFruit) potentialItem.get();
                    System.out.println("nom");
                    sn.IncreaseSize();

                    System.out.println(fruit.getPoints());
                }
            }
        }
    }

    private List<Entry<Integer, Integer>> wholeGrid () {
        for 
    }

    public Entry<Integer, Integer> randomPositionGenerator() {
        Random random = new Random();
        List<Entry<Integer, Integer>> snake_pos =  this.instance.getCurrentPosition();
        
        Integer random1 = random.nextInt(grid_width);  
        Integer random2 = random.nextInt(grid_height);

        Entry<Integer,Integer> ran_pos = new AbstractMap.SimpleEntry(random1,random2);

        // while (snake_pos.contains(ran_pos)) {
        //     random1 = random.nextInt(grid_width);
        //     random2 = random.nextInt(grid_height);
        // }
        return new AbstractMap.SimpleEntry<>(random1, random2);
    }

    public void generateItemsList() {
        Map.Entry<Integer, Integer> entry = randomPositionGenerator();
        Integer x = entry.getKey();
        Integer y = entry.getValue();
        getListItems().add(new basicFruit(x, y));
    }


}