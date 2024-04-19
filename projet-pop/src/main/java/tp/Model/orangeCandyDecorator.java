package tp.Model;

class orangeCandyDecorator extends candyDecorator{

    public orangeCandyDecorator(iCandy candy) {
        super(candy);
    }

    @Override
    public Double setSpeed(){
        return 0.5;
    }
    
}
