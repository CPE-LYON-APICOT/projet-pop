import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap;

public class Snake {
    private Integer size;
    private Direction direction;
    private List<Entry<Integer,Integer>> last_positions;

    public Snake(Integer x, Integer y) {
        this.size = 0;
        this.direction = Direction.RIGHT;
        this.last_positions = new ArrayList<>();
        Entry<Integer,Integer> startPos = new AbstractMap.SimpleEntry<>(x,y);
        last_positions.add(startPos);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public Entry<Integer,Integer> getPos() {
        return last_positions.getLast();
    }

    public Integer getX() {
        return last_positions.getLast().getKey();
    }

    public Integer getY() {
        return last_positions.getLast().getValue();
    }

    public void move(Entry<Integer, Integer> position) {
        last_positions.add(position);
    }
}
