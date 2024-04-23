package tp.Services;

import java.util.ArrayList;
import java.util.Observable;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tp.Model.basicCandy;
import tp.Model.basicFruit;
import tp.Model.greenFruitDecorator;
import tp.Model.Item;
import tp.Model.Snake;
import tp.Model.Wall;
import tp.Model.iFruit;

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
                if (item.getClass().getName() == "tp.Model.basicFruit") {
                    basicFruit fruit = (basicFruit) potentialItem.get();
                    System.out.println("nom");
                    sn.IncreaseSize();
                    System.out.println(fruit.getPoints());
                }
            }
        }
    }

    private void generateItems() {
        // getListItems().add(new Candy(0, 2, 1.2));
        // getListItems().add(new Candy(4, 5, 0.2));
        // getListItems().add(new Wall(4, 2));
        // getListItems().add(new Wall(16, 14));
        getListItems().add(new basicFruit(0, 2));
        getListItems().add(new basicFruit(4, 5));
        getListItems().add(new basicFruit(10, 8));
        getListItems().add(new basicFruit(19, 19));
        getListItems().add(new basicFruit(19, 18));
        // getListItems().add(iFruit(18,19)/* fruit = new basicFruit(18, 19))*/);
        getListItems().add(new basicFruit(18, 18));
    }

}