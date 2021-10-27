import java.awt.*;

public class Main {

    static public void main(String[] args){ //prefixe static pour que la méthode soit appelée sans créer une instance de la classe
        System.out.println("Hello world");
        Circle circle = new Circle(0,0, Color.GREEN);
        Square s = new Square(0,0,Color.black);
        System.out.println(circle.getColor());
    }

}
