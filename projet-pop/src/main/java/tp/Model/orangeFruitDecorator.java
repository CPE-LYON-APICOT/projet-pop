package tp.Model;


class orangeFruitDecorator extends fruitDecorator{

    public orangeFruitDecorator(iItem fruit) {
        super(fruit);
    }

    @Override
    public Integer getPoints(){
        return decoratedItem.getPoints()+2000;
    }

    
}
