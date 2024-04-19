package tp.Model;
public class decoratorMain {
    public static void main(String[] args) {
        // Create a new basic fruit

        iFruit greenFruit = new basicFruit();
        iFruit orangeFruit = new basicFruit();
        iCandy greenCandy = new basicCandy();
        iCandy orangeCandy = new basicCandy();

        // Decorate the fruit with green point value
        greenFruit = new greenFruitDecorator(greenFruit);
        orangeFruit = new orangeFruitDecorator(orangeFruit);

        greenCandy = new greenCandyDecorator(greenCandy);
        orangeCandy = new orangeCandyDecorator(orangeCandy);

        // Get the fruit point value
        System.out.println("Le fruit vert vaut "+greenFruit.getPoints()+" points");
        System.out.println("Le fruit orange vaut "+orangeFruit.getPoints()+" points");

        System.out.println("Le bonbon vert applique une vitesse de "+greenCandy.setSpeed());
        System.out.println("Le bonbon orange applique une vitesse de "+orangeCandy.setSpeed());
    }
}
