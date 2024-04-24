package tp.Model;
class fruitDecorator extends ItemDecorator {

    // protected iFruit decoratedFruit;

    public fruitDecorator(iItem fruit){
        super(fruit);
    }

    public Integer getPoints() {
        return 1;
    }

}

