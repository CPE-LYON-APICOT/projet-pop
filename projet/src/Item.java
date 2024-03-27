public class Item {
    protected Integer x;
    protected Integer y;

    public Item(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}

/* Construction des items */

interface ConstructorItem {

    public Item constructFruit();

    public Item constructCandy();

    public Item constructWall();
}

/*
 * interface ItemFactory{
 * 
 * 
 * 
 * 
 * }
 */
