package tp.Decorators;

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


}
