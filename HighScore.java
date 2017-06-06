/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Marcin
 */
public class HighScore extends JPanel implements ActionListener {
    
    final Menu parent;
    JLabel top;
    JTextArea highscore;
    JButton back;
    
    HighScore(final Menu parent){
        
        this.parent=parent;
        
        top = new JLabel("TOP 10");
        highscore = new JTextArea();
        back = new JButton("Powrót");
        
        this.setBackground(new Color(200,255,255,255));
        this.setBounds(0, 0, 795, 855);
        
        top.setBounds(300, 0, 200, 50);
        top.setFont(new Font("Arial",0,50));
        
        highscore.setEditable(false);
        highscore.setBackground(new Color(200,255,255,255));
        highscore.setBounds(200, 70, 795, 650);
        highscore.setFont(new Font("Arial",0,50));

        back.setBounds(340, 750, 120, 50);
        back.addActionListener(this);
        
        add(top);
        add(highscore);
        add(back);
        
        parent.ReadHighScore(highscore);

    }
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o==back){
         parent.parent.GlownyPanel.removeAll();
         parent.parent.GlownyPanel.repaint();
         parent.parent.GlownyPanel.add(parent.parent.menu);
        }
    }
    
}
