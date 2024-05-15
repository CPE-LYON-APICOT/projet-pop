package tp.Decorators;

import tp.Interfaces.iItem;

class orangeCandyDecorator extends candyDecorator{

    public orangeCandyDecorator(iItem candy) {
        super(candy);
    }

    @Override
    public Double getSpeed(){
        return decoratedItem.getSpeed()+0.5;
    }
    
}
