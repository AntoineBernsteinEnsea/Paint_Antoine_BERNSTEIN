import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Drawing extends JPanel {

    Color c ;
    String nameFigure;
    int x;
    int y;
    ArrayList<Figure> Figures_List = new ArrayList<>();

    public Drawing (){

        this.setBackground(Color.WHITE);
        nameFigure = "Rectangle";
        c = Color.black;

    }



    //Setter
    public void setC(Color c) {
        this.c = c;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }
}
