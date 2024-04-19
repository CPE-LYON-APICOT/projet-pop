 package tp.Services;

import org.springframework.stereotype.Component;

import tp.Model.Snake;
@Component
public class SnakeSingleton {

    private static Snake instance;

    public SnakeSingleton(){
        SnakeSingleton.instance = new Snake(10,10);
    }
    public Snake getInstance(){
        return instance;
    }
}