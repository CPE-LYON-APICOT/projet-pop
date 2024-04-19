class orangeCandyDecorator extends candyDecorator{

    public orangeCandyDecorator(iCandy candy) {
        super(candy);
    }

    @Override
    public Double getSpeed(){
        return decoratedCandy.getSpeed()+0.5;
    }
    
}
