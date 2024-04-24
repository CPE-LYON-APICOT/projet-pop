package tp.Model;
class candyDecorator extends ItemDecorator {

    // protected iItem decoratedItem;

    public candyDecorator(iItem candy){
        super(candy);
    }

    
    public Double getSpeed() {
        return 1.0;
    }

    
}
