class greenFruitDecorator extends fruitDecorator{

    public greenFruitDecorator(iFruit fruit) {
        super(fruit);
    }

    @Override
    public Integer getPoints(){
        return decoratedFruit.getPoints()+1000;
    }

    
}
