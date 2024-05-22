package tp.Interfaces;

import java.util.Map.Entry;

public interface iItem {
    Integer getY();

    void setY(Integer y);

    Integer getX();

    void setX(Integer x);

    Integer getPoints();

    Double getSpeed();

    Entry<Integer, Integer> getPosition();
}
