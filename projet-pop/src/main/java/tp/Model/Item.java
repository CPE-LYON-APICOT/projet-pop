package tp.Model;

import java.util.AbstractMap;
import java.util.Map.Entry;

import tp.Interfaces.iItem;

public abstract class Item implements iItem {

    protected Integer x;
    protected Integer y;

    public Item(Integer x, Integer y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public Integer getY() {
        return y;

    }

    @Override
    public void setY(Integer y) {
        this.y = y;

    }

    @Override
    public Integer getX() {
        return x;

    }

    @Override
    public void setX(Integer x) {
        this.x = x;

    }

    @Override
    public Integer getPoints() {
        return 0;
    }

    @Override
    public Double getSpeed() {
        return 0.0;
    }

    // @Override
    // public SpecialEffects setEffect() {
    //     return SpecialEffects.EFFET1;
    // }

    @Override
    public Entry<Integer, Integer> getPosition() {
        Entry<Integer, Integer> coordonneesItem = new AbstractMap.SimpleEntry<>(getX(), getY());
        return coordonneesItem;
    }
}
