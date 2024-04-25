package tp.Model;

public class effectItem3Decorator extends ItemDecorator{
    
    public effectItem3Decorator(iItem item) {
        super(item);
    }

    @Override
    public SpecialEffects setEffect(){
        return SpecialEffects.EFFET3;
    }

}
