package tp.Model;

import tp.ATRIER.SpecialEffects;

class resetItemDecorator extends itemDecorator{
    
    public resetItemDecorator(iItem item) {
        super(item);
    }

    @Override
    public SpecialEffects setEffect(){
        return decoratedItem.setEffect();

    }

}
