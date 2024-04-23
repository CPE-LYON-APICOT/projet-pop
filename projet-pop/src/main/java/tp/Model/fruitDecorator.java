package tp.Model;
class fruitDecorator extends ItemDecorator {

    // protected iFruit decoratedFruit;

    public fruitDecorator(iItem fruit){
        super(fruit);
    }

    @Override
    public Integer getPoints() {
        return 1;
    }

    @Override
    public Double getSpeed() {
        return 1.0;
    }

}

