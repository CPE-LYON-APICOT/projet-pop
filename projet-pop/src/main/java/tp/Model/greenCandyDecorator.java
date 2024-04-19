package tp.Model;
class greenCandyDecorator extends candyDecorator{

    public greenCandyDecorator(iCandy candy) {
        super(candy);
    }

    @Override
    public Double setSpeed(){
        return decoratedCandy.setSpeed()+0.25;
    }
    
}
    