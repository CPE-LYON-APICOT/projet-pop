package tp.Model;

public class Fruit extends Item {

    private Integer points;

    public Fruit(Integer x, Integer y, Integer points) {
        super(x, y);
        this.points = points;
    }

    public Integer getPoints() {
        return this.points;
    }

}
