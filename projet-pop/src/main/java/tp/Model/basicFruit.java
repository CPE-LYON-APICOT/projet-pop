package tp.Model;
public class basicFruit extends Item {
    
    public basicFruit(Integer x, Integer y) {
        super(x, y);
    }

    @Override
    public Integer getPoints() {
        return 1;
    }
    
}
