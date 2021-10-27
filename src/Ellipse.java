import java.awt.*;

public class Ellipse extends Figure {

    int SemiAxisX = 0;
    int SemiAxisY = 0;

    public Ellipse(int px, int py, Color c){
        this.c = c;
        p.X = px;
        p.Y = py;
    };

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        SemiAxisX = widthBB/2;
        SemiAxisY = heightBB/2;
    }

    @Override
    public void draw(Graphics g) {}


}
