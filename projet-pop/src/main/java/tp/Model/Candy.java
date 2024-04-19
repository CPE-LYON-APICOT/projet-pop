package tp.Model;

public class Candy extends Item {

    private double speed;

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Candy(Integer x, Integer y, double speed) {
        super(x, y);
        this.speed = speed;
    }

    public Double getSpeed() {
        return this.speed;
    }
}
