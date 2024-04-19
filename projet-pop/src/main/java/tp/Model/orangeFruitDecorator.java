package tp.Model;


class orangeFruitDecorator extends fruitDecorator{

    public orangeFruitDecorator(iFruit fruit) {
        super(fruit);
    }

    @Override
    public Integer getPoints(){
        return decoratedFruit.getPoints()+2000;
    }

    
}
