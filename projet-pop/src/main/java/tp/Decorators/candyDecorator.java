package tp.Decorators;

import tp.Interfaces.iItem;

class candyDecorator extends ItemDecorator {

    public candyDecorator(iItem candy){
        super(candy);
    }

    @Override
    public Double getSpeed() {
        return super.getSpeed() + 0.5;
    }

    
}
