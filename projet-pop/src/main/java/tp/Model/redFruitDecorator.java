package tp.Model;


class redFruitDecorator extends fruitDecorator{

    public redFruitDecorator(iItem fruit) {
        super(fruit);
    }

    @Override
    public Integer getPoints(){
        return decoratedItem.getPoints()+3000;
    }

    
}
