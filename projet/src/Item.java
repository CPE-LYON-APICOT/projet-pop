public class Item {
    protected Integer x;
    protected Integer y;
}

interface ConstructorItem {
    public Item constructFruit();

    public Item constructCandy();

    public Item constructWall();
}

abstract class AbstractConstructor implements ConstructorItem {
    Item myFactory;

    public AbstractConstructor() {

    }
}
