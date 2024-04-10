import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap;

public class Snake {
    private Integer size;
    private Direction direction;
    private List<Entry<Integer,Integer>> last_positions;

    public Snake(Integer x, Integer y) {
        this.size = 5;
        this.direction = Direction.RIGHT;
        this.last_positions = new ArrayList<>();
        Entry<Integer,Integer> startPos = new AbstractMap.SimpleEntry<>(x,y);
        last_positions.add(startPos);
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void IncreaseSize(Integer size) {
        this.size++;
    }

    public void DecreaseSize(Integer size) {
        this.size--;
    }

    public List<Entry<Integer,Integer>> getLastPositions() {
        return last_positions;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean oppositeDirection(Direction direction) {
        boolean res = false;

        switch (direction) {
            case UP:
                if (this.direction == Direction.DOWN) {
                    res = true;
                }
                break;
            case DOWN:
                if (this.direction == Direction.UP) {
                    res = true;
                }
                break;
            case RIGHT:
                if (this.direction == Direction.LEFT) {
                    res = true;
                }
                break;
            case LEFT:
                if (this.direction == Direction.RIGHT) {
                    res = true;
                }
                break;
        }
        return res;
    }

    public void setValidDirection(Direction direction) {
        if (!(this.oppositeDirection(direction))) {
            this.direction = direction;
        }
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
