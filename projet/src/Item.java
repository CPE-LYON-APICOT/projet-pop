abstract class Item {

    public Item(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    protected Integer x;
    protected Integer y;

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
