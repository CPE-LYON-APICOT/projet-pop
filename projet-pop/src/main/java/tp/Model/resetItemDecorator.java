package tp.Model;

class resetItemDecorator extends ItemDecorator{
    
    public resetItemDecorator(iItem item) {
        super(item);
    }

    @Override
    public SpecialEffects setEffect(){
        return decoratedItem.setEffect();

    }

}
