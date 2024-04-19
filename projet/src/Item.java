import java.util.AbstractMap;
import java.util.Map.Entry;

abstract class Item {

    protected Integer x;
    protected Integer y;

    public Item(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    
    /*
     * public SpecialEffects getEffect() {
     * return SpecialEffects.EFFET1;
     * }
     */
    public Entry<Integer, Integer> getPosition() {
        Entry<Integer, Integer>  coordonneesItem = new AbstractMap.SimpleEntry<>(x, y);
        return coordonneesItem;
    }
}
