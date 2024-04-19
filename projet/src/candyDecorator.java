abstract class candyDecorator implements iCandy{

    protected iCandy decoratedCandy;

    public candyDecorator(iCandy candy){
        this.decoratedCandy = candy;
    }
    
}
