package tp.Model;

public class ItemDecorator implements iItem {
    protected iItem decoratedItem;

    public ItemDecorator(iItem item){
        this.decoratedItem = item;
    }
    
    @Override
    public Integer getPoints() {
        return decoratedItem.getPoints();
    }

    @Override
    public Double getSpeed() {
        return decoratedItem.getSpeed();
    }

    @Override
    public SpecialEffects setEffect() {
        return SpecialEffects.EFFET1;
    }


}
