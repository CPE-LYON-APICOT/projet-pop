package tp.Decorators;

import tp.Interfaces.iItem;

public class greenCandyDecorator extends candyDecorator {

    public greenCandyDecorator(iItem candy) {
        super(candy);
    }

    @Override
    public Double getSpeed(){
        return decoratedItem.getSpeed()+0.5;
    }
    @Override
    public Integer getPoints() {
        return 250;
    }
    
    
}
    