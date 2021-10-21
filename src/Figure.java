import java.awt.*;

abstract public class Figure {

    protected Color c;


    public Figure(){
        this.c = new Color(0, 255, 0);//green
    }

    public Figure( Color color , Point point ){
        this.c = color;
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
