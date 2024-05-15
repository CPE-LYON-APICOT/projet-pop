package tp.Decorators;

import tp.Interfaces.iItem;

class redCandyDecorator extends candyDecorator{

    public redCandyDecorator(iItem candy) {
        super(candy);
    }

    @Override
    public Double getSpeed(){
        return decoratedItem.getSpeed()+0.5;
    }
}
