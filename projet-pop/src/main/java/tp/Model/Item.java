package tp.Model;
import java.util.AbstractMap;
import java.util.Map.Entry;

public abstract class Item {

    private Integer x;
    private Integer y;

    public Item(Integer x, Integer y) {
        this.setX(x);
        this.setY(y);
    }
    
    public Integer getY() {
        return y;
        
    }

    public void setY(Integer y) {
        this.y = y;
        
    }

    public Integer getX() {
        return x;
        
    }

    public void setX(Integer x) {
        this.x = x;
        
    }

    /*
     * public SpecialEffects getEffect() {
     * return SpecialEffects.EFFET1;
     * }
     */
    public Entry<Integer, Integer> getPosition() {
        Entry<Integer, Integer>  coordonneesItem = new AbstractMap.SimpleEntry<>(getX(), getY());
        return coordonneesItem;
    }
}
