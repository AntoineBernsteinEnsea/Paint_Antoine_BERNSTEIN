import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static java.awt.Color.*;

public class Window extends JFrame implements ActionListener {

    Drawing drawing = new Drawing();
    JOptionPane info = new JOptionPane();

    public Window(String Title, int X, int Y){

        super(Title);
        this.setSize(X+14,Y);
        drawing.setSize(X,Y-120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int NbButtons = 12;
        //float BYS = Y/20; //ButtonYSize
        //float BXS = X/4; //ButtonXSize
        //float BXSC = X/8; //ButtonXSizeColor


        //Partie Menus
        JMenuBar Menubar = new JMenuBar(); // Barre de menu

        JMenu File_Menu = new JMenu("File"); // Menu dans la barre de menu


        JMenu A_propos_Menu = new JMenu("A propos");
        JMenuItem Authors = new JMenuItem(new AbstractAction("Authors") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showInternalMessageDialog(info, "Authors : Antoine BERNSTEIN","Authors",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        A_propos_Menu.add(Authors);


        JMenuItem New_Item, Open_Item, Save_Item, Quit_Item; //Items dans le menu "File"
        New_Item = new JMenuItem("New");Open_Item = new JMenuItem("Open");
        Save_Item = new JMenuItem("Save");Quit_Item = new JMenuItem("Quit");
        File_Menu.add(New_Item); File_Menu.add(Save_Item); File_Menu.add(Open_Item); File_Menu.add(Quit_Item);

        Menubar.add(File_Menu);Menubar.add(A_propos_Menu);



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
            this.add(Button);
            Button.addActionListener(this);
        }


        //ces deux boucles permettent de répartir correctement les boutons sur le bas de la fenêtre à l'ouverture d'une fenêtre de paint
        for (int i=0;i<8;i++){ //Boutons pour les couleurs
            ButtonList.get(i).setBounds(((i%4)*X/8),Y-(60+(1+i/4)*Y/20),X/8,Y/20);
            ButtonList.get(i).setBackground(List_color.get(i));
        }

        for (int i=0;i<4;i++){ //Boutons pour les formes
            ButtonList.get(i+8).setBounds(((i%2)*X/4)+X/2,Y-(60+(1+i/2)*Y/20),X/4,Y/20);
        }

        this.getContentPane().add(drawing);

        this.setJMenuBar(Menubar);
        this.setLayout(null);
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
                System.out.println(drawing.c);
                drawing.setC(RED);
                System.out.println("red clicked");
                System.out.println(drawing.c);
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

        }
    }


    public static void main(String[] args)
    {

        new Window("Paint",800,600);
    }

}
