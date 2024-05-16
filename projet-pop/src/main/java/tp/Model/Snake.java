package tp.Model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import tp.enums.Direction;

import java.util.Observable;

@SuppressWarnings("deprecation")

public class Snake extends Observable {
    private Integer size;
    private Direction direction;
    private List<Entry<Integer, Integer>> last_positions;
    private List<Direction> last_directions;
    private double speed;
    private double points;

   
    public Snake(Integer x, Integer y) {
        this.size = 1;
        this.direction = Direction.RIGHT;
        this.last_positions = new ArrayList<>();
        this.last_directions = new ArrayList<>();
        Entry<Integer, Integer> startPos = new AbstractMap.SimpleEntry<>(x, y);
        last_positions.add(startPos);
        last_directions.add(this.direction);
        this.speed = 1;
        this.points=0;
        // for (int i = 0; i < this.size; i++) {
        // }
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void IncreaseSize() {
        this.size++;
    }

    public void DecreaseSize() {
        this.size--;
    }

    public void updateDirections(Direction direction) {
        this.last_directions.add(direction);
    }

    public List<Entry<Integer, Integer>> getLastPositions() {
        return last_positions;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Direction> getLastDirections() {
        return last_directions;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getSpeed(){
        return this.speed;
    }
    public void setPoints(double points)
    {
        this.points += points;
    }

    public double getPoints(){
        return this.points;
    }

    public boolean oppositeDirection(Direction direction) {
        boolean res = false;

        switch (direction) {
            case UP:
                if (this.last_directions.get(last_directions.size() - 1) == Direction.DOWN) {
                    res = true;
                }
                break;
            case DOWN:
                if (this.last_directions.get(last_directions.size() - 1) == Direction.UP) {
                    res = true;
                }
                break;
            case RIGHT:
                if (this.last_directions.get(last_directions.size() - 1) == Direction.LEFT) {
                    res = true;
                }
                break;
            case LEFT:
                if (this.last_directions.get(last_directions.size() - 1) == Direction.RIGHT) {
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

    public boolean tailTouched() {
        // List<Entry<Integer,Integer>> positions/* , previous_positions */;

        // positions = last_positions.reversed().subList(0, size);
        // previous_positions = last_positions.reversed().subList(size, last_positions.size());
        // System.out.println(positions);
        // System.out.println(previous_positions);
        

        for (Entry<Integer,Integer> i : getCurrentPosition()) {
            if (Collections.frequency(getCurrentPosition(), i) > 1) {
                return true;
            }
        }
        return false;
    }

    public List<Entry<Integer,Integer>> getCurrentPosition() {
        return last_positions.reversed().subList(0, size);
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
        this.setChanged();
        this.notifyObservers(this);
    }
}
