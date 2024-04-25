package tp.Model;

public class effectItem2Decorator extends ItemDecorator{
    
    public effectItem2Decorator(iItem item) {
        super(item);
    }

    @Override
    public SpecialEffects setEffect(){
        return SpecialEffects.EFFET2;
    }

}
