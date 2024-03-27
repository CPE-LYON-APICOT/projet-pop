public class App {
    public static void main(String[] args) throws Exception {
        Grid game = new Grid(20,20);
        game.initGrid();
        Snake snek = new Snake(10,10);
        game.updateSnakePos(snek);
        game.displayGrid();
    }
}
