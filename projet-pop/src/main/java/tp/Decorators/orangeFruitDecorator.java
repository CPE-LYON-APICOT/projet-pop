package tp.Decorators;

import tp.Interfaces.iItem;

public class orangeFruitDecorator extends fruitDecorator{

    public orangeFruitDecorator(iItem fruit) {
        super(fruit);
    }

    @Override
    public Integer getPoints(){
        return decoratedItem.getPoints()+1000;
    }

    
}
