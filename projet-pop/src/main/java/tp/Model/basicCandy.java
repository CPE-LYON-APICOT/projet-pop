package tp.Model;

public class basicCandy extends Item {

    public basicCandy(Integer x, Integer y) {
        super(x, y);
    }
    
    @Override
    public Double getSpeed() {
        return 1.0;
    }    
}