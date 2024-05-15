package tp.Services;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;

import javax.swing.RowFilter.Entry;

import org.springframework.stereotype.Component;

import tp.Model.basicFruit;
import tp.Interfaces.iItem;
import tp.Model.Snake;
import tp.Model.basicCandy;
import tp.Decorators.*;
import tp.Model.basicFruit;
import tp.View.Grid;

@SuppressWarnings({ "deprecation", "unused" })
@Component
public class ObjetService {
    private ArrayList<iItem> listItems;
    Snake instance;

    public ObjetService(SnakeSingleton snakeSingleton) {
        this.instance = snakeSingleton.getInstance();
        setListItems(new ArrayList<>());
        generateItemsList(0, 0);

        instance.addObserver((e, f) -> DetectIfSnakeAteItem(e, f));

        /*
         * 
         * instance.AddObserver()
         */
    }

    public ArrayList<iItem> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<iItem> listItems) {
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
                iItem item = potentialItem.get();
                getListItems().remove(potentialItem.get());

                // génération de deux valeurs aléatoires afin de définir le type d'objet qui
                // sera ajouté dans la grille

                Random random = new Random();
                int randomItemType = random.nextInt(2);
                int randomItemColor = random.nextInt(4);

                generateItemsList(randomItemType, randomItemColor);
                
                System.out.println("L'objet " + item.getClass().getName() + " a été ramassé");
                System.out.println(getListItems());
                // switch (item.getClass().getName()) {
                // case "tp.Model.*":
                iItem iItem = (iItem) potentialItem.get();
                // System.out.println(iItem.getPoints());
                // System.out.println(iItem.getSpeed());
                // System.out.println("VITESSE DU SSSSSERPENTARD : "+instance.getSpeed());
                if(iItem.getSpeed()!=0)
                {
                    this.instance.setSpeed(iItem.getSpeed());
                }
                
                
                // break;

                /*
                 * case "tp.Decorators.*":
                 * basicCandy candy = (basicCandy) potentialItem.get();
                 * System.out.println(candy.getSpeed());
                 * break;
                 * 
                 * 
                 * }
                 */
                sn.IncreaseSize();
            }
        }

    }

    public Map.Entry<Integer, Integer> randomPositionGenerator() {
        Random random = new Random();

        int random1 = random.nextInt(20);
        int random2 = random.nextInt(20);
        return new AbstractMap.SimpleEntry<>(random1, random2);
    }

    public void generateItemsList(int randomItemType, int randomItemColor) {
        Map.Entry<Integer, Integer> entry = randomPositionGenerator();
        Integer x = entry.getKey();
        Integer y = entry.getValue();
        if (randomItemType == 0) {
            iItem newItem = new basicCandy(x, y);
            switch (randomItemColor) {
                case 0:
                    getListItems().add(newItem);
                    break;
                case 1:
                    newItem = new greenCandyDecorator(newItem);
                    getListItems().add(newItem);
                    break;
                case 2:
                    newItem = new orangeCandyDecorator(newItem);
                    getListItems().add(newItem);
                    break;
                case 3:
                    newItem = new redCandyDecorator(newItem);
                    getListItems().add(newItem);
                    break;
            }

        } else {
            iItem newItem = new basicFruit(x, y);
            switch (randomItemColor) {
                case 0:
                    getListItems().add(newItem);
                    break;
                case 1:
                    newItem = new greenFruitDecorator(newItem);
                    getListItems().add(newItem);
                    break;
                case 2:
                    newItem = new orangeFruitDecorator(newItem);
                    getListItems().add(newItem);
                    break;
                case 3:
                    newItem = new redFruitDecorator(newItem);
                    getListItems().add(newItem);
                    break;
            }
        }
        System.out.println(getListItems());
    }
    /*
     * public int[] setGridSize(int height, int width)
     * {
     * int[] gridSize = new int[2];
     * gridSize[0]=height;
     * gridSize[1]=width;
     * return gridSize;
     * }
     */
    /*
     * Méthode positions dans snake pour la position du serpent
     * Grille avec toutes les positions possibles puis en retirer les positions du
     * serpent
     */
}