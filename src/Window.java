import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

import static java.awt.Color.*;

public class Window extends JFrame implements ActionListener {

    Drawing drawing = new Drawing();
    JOptionPane info = new JOptionPane();

    public Window(String Title, int X, int Y){

        super(Title);
        this.setSize(X,Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = this.getContentPane();

        int NbButtons = 12;

        //Partie Menus
        JMenuBar Menubar = new JMenuBar(); // Barre de menu



        JMenu File_Menu = new JMenu("File"); // Menu dans la barre de menu

        JMenu Edit_Menu = new JMenu("Edit");

        JMenu A_propos_Menu = new JMenu("A propos");





        JMenuItem New_Item, Open_Item, Save_Item, Quit_Item; //Items dans le menu "File"
        New_Item = new JMenuItem(new AbstractAction("New") {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing.Figures_List.clear();
                drawing.repaint();
            }
        });
        Open_Item = new JMenuItem(new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String FileName_open = JOptionPane.showInputDialog(null, "Name of the file to open", "Open", JOptionPane.INFORMATION_MESSAGE);
                    if ((FileName_open != null)&&(FileName_open.length()>0) ){
                        drawing.open(FileName_open);
                        drawing.repaint();
                    }
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        Save_Item = new JMenuItem(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent e) {

                String FileName_close = JOptionPane.showInputDialog(null,"Name your file","Save",JOptionPane.INFORMATION_MESSAGE);
                if((FileName_close !=null)&&(FileName_close.length()>0)){
                    drawing.save(FileName_close);
                }
            }
        });
        Quit_Item = new JMenuItem(new AbstractAction("Quit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JMenuItem Undo = new JMenuItem(new AbstractAction("Undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (drawing.Figures_List.size()!=0){
                    drawing.Figures_List.remove(drawing.Figures_List.size()-1);
                    drawing.repaint();
                }
            }
        });

        JMenuItem Authors = new JMenuItem(new AbstractAction("Authors") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInternalMessageDialog(info, "Authors : Antoine BERNSTEIN","Authors",JOptionPane.INFORMATION_MESSAGE);
            }
        });
;



        File_Menu.add(New_Item); File_Menu.add(Save_Item); File_Menu.add(Open_Item); File_Menu.add(Quit_Item);

        Edit_Menu.add(Undo);

        A_propos_Menu.add(Authors);



        Menubar.add(File_Menu);Menubar.add(Edit_Menu);Menubar.add(A_propos_Menu);



        //Partie Boutons

        List<Color> List_color = Arrays.asList(BLACK, RED, GREEN, BLUE, PINK, MAGENTA, YELLOW, ORANGE);

        ArrayList<JButton> ButtonList = new ArrayList<>(NbButtons);


        JButton Black_Button,Red_Button,Green_Button,Blue_Button,Magenta_Button,Orange_Button;
        JButton Yellow_Button,Pink_Button,Ellipse_Button,Circle_Button,Rectangle_Button,Square_Button;

        Black_Button = new JButton("Black");Red_Button = new JButton("Red");Green_Button = new JButton("Green");
        Blue_Button = new JButton("Blue");Pink_Button = new JButton("Pink");Magenta_Button = new JButton("Magenta");
        Yellow_Button = new JButton("Yellow");Orange_Button = new JButton("Orange");
        Ellipse_Button = new JButton("Ellipse");Circle_Button = new JButton("Circle");
        Rectangle_Button = new JButton("Rectangle");Square_Button = new JButton("Square");

        ButtonList.add(Black_Button); ButtonList.add(Red_Button); ButtonList.add(Green_Button); ButtonList.add(Blue_Button);
        ButtonList.add(Pink_Button); ButtonList.add(Magenta_Button); ButtonList.add(Yellow_Button); ButtonList.add(Orange_Button);
        ButtonList.add(Ellipse_Button); ButtonList.add(Circle_Button); ButtonList.add(Rectangle_Button); ButtonList.add(Square_Button);

        for (JButton Button : ButtonList){
            Button.addActionListener(this);
        }


        for (int i=0;i<8;i++){ //Boutons pour les couleurs
            ButtonList.get(i).setBackground(List_color.get(i));
        }


        //Partie organisation de l'affichage

        pane.setLayout(new BorderLayout());

        JPanel B_C = new JPanel();
        JPanel B_F = new JPanel();
        JPanel B = new JPanel();

        for (int i=0;i<8;i++){
            B_C.add(ButtonList.get(i));
        }
        for (int i=8;i<12;i++){
            B_F.add(ButtonList.get(i));
        }


        B_C.setLayout(new GridLayout(2,4));
        B_F.setLayout(new GridLayout(2,2));
        B.setLayout(new GridLayout(1,2));
        B.add(B_C);
        B.add(B_F);

        pane.add(drawing, BorderLayout.CENTER);
        pane.add(B, BorderLayout.SOUTH);


        this.setJMenuBar(Menubar);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch (cmd){
            case "Black" :
                drawing.setC(BLACK);
                break;

            case "Red" :
                drawing.setC(RED);
                break;

            case "Green" :
                drawing.setC(GREEN);
                break;

            case "Blue" :
                drawing.setC(BLUE);
                break;

            case "Pink" :
                drawing.setC(PINK);
                break;

            case "Magenta" :
                drawing.setC(MAGENTA);
                break;

            case "Yellow" :
                drawing.setC(YELLOW);
                break;

            case "Orange" :
                drawing.setC(ORANGE);
                break;

            case "Rectangle" :
                drawing.setNameFigure("Rectangle");
                break;

            case "Square" :
                drawing.setNameFigure("Square");
                break;

            case "Ellipse" :
                drawing.setNameFigure("Ellipse");
                break;

            case "Circle" :
                drawing.setNameFigure("Circle");
                break;

            case "Authors" :
                JOptionPane.showInternalMessageDialog(info, "Authors : Antoine BERNSTEIN","Authors",JOptionPane.INFORMATION_MESSAGE);
                break;

        }
    }


    public static void main(String[] args)
    {

        new Window("Paint",800,600);
    }

}
