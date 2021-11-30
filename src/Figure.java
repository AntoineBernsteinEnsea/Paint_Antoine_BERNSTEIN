import java.awt.*;
import java.io.Serializable;

abstract public class Figure implements Serializable {

    protected Color c;
    protected Point p;


    public Figure(){
        c = new Color(0, 255, 0);//green
        p = new Point();
    }

    public Figure( Color color , Point point ){
        c = color;
        p = point;
    }



    public abstract void setBoundingBox(int heightBB, int widthBB);

    public abstract void draw(Graphics g);


    @Override
    public String toString() {
        return "Couleur = "+ c;
    }

    //getter
    public Color getColor() {
        return c;
    }

}
