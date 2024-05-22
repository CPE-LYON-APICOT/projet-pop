package tp.Decorators;

import tp.Interfaces.iItem;
import tp.Model.basicCandy;
import tp.Model.basicFruit;

public class decoratorMain {
    public static void main(String[] args) {
        // Create a new basic fruit

        iItem greenFruit = new basicFruit(1,1);
        iItem orangeFruit = new basicFruit(1,2);
        iItem greenCandy = new basicCandy(1,3);
        iItem orangeCandy = new basicCandy(1,4);

        // Decorate the fruit with green point value
        greenFruit = new greenCandyDecorator(greenFruit);
        greenFruit = new greenFruitDecorator(greenFruit);
        greenFruit = new greenFruitDecorator(greenFruit);
        greenFruit = new greenCandyDecorator(greenFruit);
        greenFruit = new greenCandyDecorator(greenFruit);
        greenFruit = new orangeCandyDecorator(greenFruit);
        orangeFruit = new orangeFruitDecorator(orangeFruit);

        greenCandy = new greenCandyDecorator(greenCandy);
        orangeCandy = new orangeCandyDecorator(orangeCandy);

        // Get the fruit point value
        System.out.println("Le fruit vert vaut "+greenFruit.getPoints()+" points" + " | vitesse : " + greenFruit.getSpeed());
        System.out.println("Le fruit orange vaut "+orangeFruit.getPoints()+" points");

        System.out.println("Le bonbon vert applique une vitesse de "+greenCandy.getSpeed());
        System.out.println("Le bonbon orange applique une vitesse de "+orangeCandy.getSpeed());
    }
}
