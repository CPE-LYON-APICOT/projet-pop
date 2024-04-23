package tp.Model;
class candyDecorator extends ItemDecorator {

    protected iItem decoratedCandy;

    public candyDecorator(iItem candy){
        super(candy);
    }

    @Override
    public Integer getPoints() {
        return 0;
    }

    @Override
    public Double getSpeed() {
        return 1.0;
    }

    
}
