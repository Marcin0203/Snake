/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.io.*;
import javax.swing.*;


/**
 *
 * @author Marcin
 */
public class Snake extends JFrame {

    public JPanel GlownyPanel = new JPanel();
    JPanel menu = new Menu(this);
    
    public Snake() {
        super("Snake v1.3");
        

        this.setPreferredSize(new Dimension(756, 838));
        this.setResizable(false);
        this.setLocation(500, 150);
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GlownyPanel.setLayout(null);
        GlownyPanel.setBounds(0, 0, 795, 855);
        GlownyPanel.add(menu);

        this.setContentPane(GlownyPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Snake gra = new Snake();
        // TODO code application logic here
    }
    

}

