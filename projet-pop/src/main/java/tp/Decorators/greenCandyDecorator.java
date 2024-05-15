package tp.Decorators;

import tp.Interfaces.iItem;

class greenCandyDecorator extends candyDecorator {

    public greenCandyDecorator(iItem candy) {
        super(candy);
    }

    @Override
    public Double getSpeed(){
        return decoratedItem.getSpeed()+0.25;
    }
    
}
