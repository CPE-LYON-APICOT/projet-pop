package tp.Decorators;

import tp.Interfaces.iItem;

public class orangeCandyDecorator extends candyDecorator{

    public orangeCandyDecorator(iItem candy) {
        super(candy);
    }

    @Override
    public Double getSpeed(){
        return decoratedItem.getSpeed()+1;
    }
    @Override
    public Integer getPoints() {
        return 500;
    }
    
}
