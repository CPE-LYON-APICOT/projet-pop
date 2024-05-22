package tp.Decorators;

import tp.Interfaces.iItem;

public class greenFruitDecorator extends fruitDecorator{

    public greenFruitDecorator(iItem item) {
        super(item);
    }

    @Override
    public Integer getPoints(){
        return decoratedItem.getPoints()+500;
    }

    
}
