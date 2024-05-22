package tp.Decorators;

import java.util.Map.Entry;

import tp.Interfaces.iItem;

public class ItemDecorator implements iItem {
    protected iItem decoratedItem;

    public ItemDecorator(iItem item){
        this.decoratedItem = item;
    }

    @Override
    public Integer getPoints() {
        return decoratedItem.getPoints();
    }

    @Override
    public Double getSpeed() {
        return decoratedItem.getSpeed();
    }

    @Override
    public Integer getY()
    {
        return decoratedItem.getY();
    }

    @Override
    public void setY(Integer y){
        decoratedItem.setY(y);
    }


    public Integer getX()
    {
        return decoratedItem.getX();
    }

    public void setX(Integer x){
        decoratedItem.setX(x);
    }

    public Entry<Integer, Integer> getPosition()
    {
        return decoratedItem.getPosition();
    }

}
