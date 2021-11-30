import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {

    Color c ;
    String nameFigure;
    int x;
    int y;
    ArrayList<Figure> Figures_List = new ArrayList<>();

    public Drawing (){
        this.setBackground(Color.WHITE);
        nameFigure = "Rectangle";
        c = Color.black;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setSize(400,400);
    }


    //Setter
    public void setC(Color c) {
        this.c = c;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        x = e.getX();
        y = e.getY();
        switch (this.nameFigure) {
            case "Rectangle" -> Figures_List.add(new Rectangle(x, y, this.c));
            case "Square" -> Figures_List.add(new Square(x, y, this.c));
            case "Ellipse" -> Figures_List.add(new Ellipse(x, y, this.c));
            case "Circle" -> Figures_List.add(new Circle(x, y, this.c));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Figures_List.get(Figures_List.size()-1).setBoundingBox(e.getY()-Figures_List.get(Figures_List.size()-1).p.Y,e.getX()-Figures_List.get(Figures_List.size()-1).p.X);
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Figure f : Figures_List){
            f.draw(g);
        }
    }


    public void save(String nom){
        try{
            File fichier = new File(nom);
            FileOutputStream fos = new FileOutputStream(fichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Figures_List);
            oos.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void open(String nom){
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\33769\\IdeaProjects\\Paint.\\"+nom);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Figures_List = (ArrayList<Figure>) ois.readObject();
            ois.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
