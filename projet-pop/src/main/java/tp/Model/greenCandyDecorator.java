package tp.Model;
class greenCandyDecorator extends candyDecorator{

    public greenCandyDecorator(iCandy candy) {
        super(candy);
    }

    @Override
    public Double getSpeed(){
        return decoratedCandy.getSpeed()+0.25;
    }
    
}
