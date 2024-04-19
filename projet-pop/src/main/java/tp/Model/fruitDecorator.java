package tp.Model;
abstract class fruitDecorator implements iFruit{

    protected iFruit decoratedFruit;

    public fruitDecorator(iFruit fruit){
        this.decoratedFruit = fruit;
    }

}

