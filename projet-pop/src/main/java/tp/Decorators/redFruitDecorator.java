package tp.Decorators;

import tp.Interfaces.iItem;

public class redFruitDecorator extends fruitDecorator{

    public redFruitDecorator(iItem fruit) {
        super(fruit);
    }

    @Override
    public Integer getPoints(){
        return decoratedItem.getPoints()+2500;
    }

    
}
