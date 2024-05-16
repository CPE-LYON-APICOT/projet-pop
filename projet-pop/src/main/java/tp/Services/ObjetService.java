package tp.Services;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Random;

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
    private Snake instance;
    private int grid_width;
    private int grid_height;
    private List<String> listCandyTypes;
    private List<String> listFruitTypes;

    public int getGrid_height() {
        return grid_height;
    }

    public int getGrid_width() {
        return grid_width;
    }

    public ObjetService(SnakeSingleton snakeSingleton) {
        this.instance = snakeSingleton.getInstance();
        this.grid_width = 10;
        this.grid_height = 10;
        setListItems(new ArrayList<>());
        generateItemsList(0, 0);
        generateItemsList(1, 0);
        instance.addObserver((e, f) -> DetectIfSnakeAteItem(e, f));

        this.listCandyTypes = Arrays.asList("tp.Model.basicCandy", "tp.Decorators.greenCandyDecorator",
                "tp.Decorators.orangeCandyDecorator", "tp.Decorators.redCandyDecorator");
        this.listFruitTypes = Arrays.asList("tp.Model.basicFruit", "tp.Decorators.greenFruitDecorator",
                "tp.Decorators.orangeFruitDecorator", "tp.Decorators.redFruitDecorator");
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
                
                int randomItemType;
                
                if(listCandyTypes.contains(item.getClass().getName()))
                {
                    randomItemType=0;
                }
                else /*if(listFruitTypes.contains(item.getClass().getName()))*/{
                    randomItemType=1;
                }

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
                this.instance.setPoints(iItem.getPoints() * this.instance.getSpeed());
                if (iItem.getSpeed() != 0) {
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

    private List<Entry<Integer, Integer>> wholeGrid() {
        List<Entry<Integer, Integer>> res = new ArrayList<>();
        // res.add(new AbstractMap.SimpleEntry<>(null, null));
        for (int i = 0; i < this.grid_width; i++) {
            for (int j = 0; j < this.grid_height; j++) {
                res.add(new AbstractMap.SimpleEntry<>(i, j));
            }
        }
        return res;
    }

    public Entry<Integer, Integer> randomPositionGenerator() {
        Random random = new Random();
        List<Entry<Integer, Integer>> snake_pos = this.instance.getCurrentPosition();

        List<Entry<Integer, Integer>> grid = wholeGrid();
        for (Entry<Integer, Integer> i : snake_pos) {
            grid.remove(i);
        }

        // Integer random1 = random.nextInt(grid_width);
        // Integer random2 = random.nextInt(grid_height);

        Entry<Integer, Integer> ran_pos = new AbstractMap.SimpleEntry<>(grid.get(random.nextInt(grid.size())));

        // while (snake_pos.contains(ran_pos)) {
        // random1 = random.nextInt(grid_width);
        // random2 = random.nextInt(grid_height);
        // }
        return ran_pos;
    }

    public void generateItemsList(int randomItemType, int randomItemColor) {
        Entry<Integer, Integer> entry = randomPositionGenerator();
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