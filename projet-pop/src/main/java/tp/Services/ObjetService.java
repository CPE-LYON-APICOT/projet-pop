package tp.Services;

import java.util.ArrayList;
import java.util.Observable;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tp.Model.Candy;
import tp.Model.Fruit;
import tp.Model.Item;
import tp.Model.Snake;
import tp.Model.Wall;

@Component
public class ObjetService {
    private ArrayList<Item> listItems;

    @SuppressWarnings("deprecation")
    public ObjetService(SnakeSingleton snakeSingleton) {
        Snake instance = snakeSingleton.getInstance();
        setListItems(new ArrayList<>());
        generateItems();
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
            /*System.out.println(sn.getX() + " " + sn.getY()+ " |" +getListItems().stream()
            .map(p->p.getX() + " " + p.getY()).collect(Collectors.joining(", ")));*/
            // System.out.println(getListItems().stream().toString());
            var potentialItem = getListItems().stream().filter(o -> o.getX().equals(sn.getX()) && o.getY().equals(sn.getY())).findAny();
            if (potentialItem.isPresent()) {
                Item item = potentialItem.get();
                System.out.println("L'objet " + item.getClass().getName() + " a été ramassé");
            }
        }
    }

    private void generateItems() {
        getListItems().add(new Candy(0, 2, 1.2));
        getListItems().add(new Candy(4, 5, 0.2));
        getListItems().add(new Wall(4, 2));
        getListItems().add(new Wall(16, 14));
        getListItems().add(new Fruit(0, 2, 15000));
        getListItems().add(new Fruit(4, 5, 15000));
        getListItems().add(new Fruit(10, 8, 15000));
        getListItems().add(new Fruit(19, 19, 15000));
        getListItems().add(new Fruit(19, 18, 15000));
        getListItems().add(new Fruit(18, 19, 15000));
        getListItems().add(new Fruit(18, 18, 15000));
    }

}