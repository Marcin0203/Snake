/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Marcin
 */
public class Settings extends JPanel implements ActionListener{
    
    final Menu parent;
    JButton save, back, ColorHead, ColorBody, ColorApple, ColorBoard;
    JRadioButton SpeedSlow, SpeedMedium, SpeedFast, SizeSmall, SizeMedium, SizeBig;
    JLabel Speed, Size, CurrentColorHead, CurrentColorBody, CurrentColorApple, CurrentColorBoard, 
            SelectedColorHead, SelectedColorBody, SelectedColorApple, SelectedColorBoard;
    
    Settings (final Menu parent){
        
        this.parent=parent;
        
        save = new JButton("Zapisz");
        back = new JButton("Powrót");
        SpeedSlow = new JRadioButton("Wolno");
        SpeedMedium = new JRadioButton("Średnio");
        SpeedFast= new JRadioButton("Szybko");
        SizeSmall = new JRadioButton("Mały");
        SizeMedium = new JRadioButton("Średni");
        SizeBig = new JRadioButton("Duży");
        Speed = new JLabel("Wybierz prędkość poruszania się węża:");
        Size = new JLabel("Wybierz rozmiar głowy węża:");
        ColorHead = new JButton("Wybierz kolor głowy węża");
        ColorBody = new JButton("Wybierz kolor ciała węża");
        ColorApple = new JButton("Wybierz kolor jabłka");
        ColorBoard = new JButton("Wybierz kolor planszy");
        CurrentColorHead = new JLabel("Aktualny kolor głowy: ");
        CurrentColorBody = new JLabel("Aktualny kolor ciała węża: ");
        CurrentColorApple = new JLabel("Aktualny kolor jabłka: ");
        CurrentColorBoard = new JLabel("Aktualny kolor planszy: ");
        SelectedColorHead = new JLabel("Wybrany kolor głowy: ");
        SelectedColorBody = new JLabel("Wybrany kolor ciała węża: ");
        SelectedColorApple = new JLabel("wybrany kolor jabłka: ");
        SelectedColorBoard = new JLabel("Wybrany kolor planszy: ");
        
        groupButton();
        
        this.setBackground(new Color(200,255,255,255));
        this.setBounds(0, 0, 795, 855);
        
        Size.setBounds(175, 30, 500, 45);
        Size.setFont(new Font("Arial",0,30));
        
        Speed.setBounds(120, 250, 600, 45);
        Speed.setFont(new Font("Arial",0,30));
        
        CurrentColorHead.setBounds(20, 400, 200, 50);
        CurrentColorHead.setFont(new Font("Arial",0,20));
        
        CurrentColorBody.setBounds(20, 475, 250, 50);
        CurrentColorBody.setFont(new Font("Arial",0,20));
        
        CurrentColorApple.setBounds(20, 550, 250, 50);
        CurrentColorApple.setFont(new Font("Arial",0,20));
        
        CurrentColorBoard.setBounds(20, 625, 250, 50);
        CurrentColorBoard.setFont(new Font("Arial",0,20));
        
        SpeedSlow.setBounds(100, 330, 100, 30);
        SpeedSlow.setBackground(new Color(200,255,255,255));
        SpeedSlow.setFont(new Font("Arial",0,22));
        
        SpeedMedium.setBounds(300, 330, 100, 30);
        SpeedMedium.setBackground(new Color(200,255,255,255));
        SpeedMedium.setFont(new Font("Arial",0,22));
        
        SpeedFast.setBounds(500, 330, 100, 30);
        SpeedFast.setBackground(new Color(200,255,255,255));
        SpeedFast.setFont(new Font("Arial",0,22));
        
        SizeSmall.setBounds(100, 130, 100, 30);
        SizeSmall.setBackground(new Color(200,255,255,255));
        SizeSmall.setFont(new Font("Arial",0,22));
        
        SizeMedium.setBounds(300, 130, 100, 30);
        SizeMedium.setBackground(new Color(200,255,255,255));
        SizeMedium.setFont(new Font("Arial",0,22));
        
        SizeBig.setBounds(500, 130, 100, 30);
        SizeBig.setBackground(new Color(200,255,255,255));
        SizeBig.setFont(new Font("Arial",0,22));
        
        ColorHead.setBounds(290, 400, 200, 50);
        ColorHead.addActionListener(this);
        
        ColorBody.setBounds(290, 475, 200, 50);
        ColorBody.addActionListener(this);
        
        ColorApple.setBounds(290, 550, 200, 50);
        ColorApple.addActionListener(this);
        
        ColorBoard.setBounds(290, 625, 200, 50);
        ColorBoard.addActionListener(this);
        
        back.setBounds(400, 750, 120, 50);
        back.addActionListener(this);
        
        save.setBounds(250, 750, 120, 50);
        save.addActionListener(this);
        
        add(Speed);
        add(Size);
        add(SpeedSlow);
        add(SpeedMedium);
        add(SpeedFast);
        add(SizeSmall);
        add(SizeMedium);
        add(SizeBig);
        add(ColorHead);
        add(ColorBody);
        add(ColorApple);
        add(ColorBoard);

        add(save);
        add(back);
        
    }

    
    private void groupButton() {

        ButtonGroup group1 = new ButtonGroup();
        ButtonGroup group2 = new ButtonGroup();

        group1.add(SpeedSlow);
        group1.add(SpeedMedium);
        group1.add(SpeedFast);
        
        group2.add(SizeSmall);
        group2.add(SizeMedium);
        group2.add(SizeBig);
        

    }
    
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o==back){
         parent.parent.GlownyPanel.removeAll();
         parent.parent.GlownyPanel.repaint();
         parent.parent.GlownyPanel.add(parent.parent.menu);
        }
        
        if(o==save){
         
            if(SpeedSlow.isSelected()){
                parent.speed=350;
                parent.SpeedFast=false;
                parent.SpeedMedium=false;
                parent.SpeedSlow=true;
            }
            
            if(SpeedMedium.isSelected()){
                parent.speed=150;
                parent.SpeedFast=false;
                parent.SpeedMedium=true;
                parent.SpeedSlow=false;
            }
            
            if(SpeedFast.isSelected()){
                parent.speed=75;
                parent.SpeedFast=true;
                parent.SpeedMedium=false;
                parent.SpeedSlow=false;
            }
            
            if(SizeSmall.isSelected()){
                parent.headSize=10;
                parent.SizeSmall=true;
                parent.SizeMedium=false;
                parent.SizeBig=false;
                parent.MaxAreaGame=740;
            }
            
            if(SizeMedium.isSelected()){
                parent.headSize=25;
                parent.SizeSmall=false;
                parent.SizeMedium=true;
                parent.SizeBig=false;
                parent.MaxAreaGame=725;
            }
            
            if(SizeBig.isSelected()){
                parent.headSize=50;
                parent.SizeSmall=false;
                parent.SizeMedium=false;
                parent.SizeBig=true;
                parent.MaxAreaGame=700;
            }
            
            parent.WriteSettings();
            parent.WriteColor();
        }
        
        if(o==ColorHead){
            Color color = JColorChooser.showDialog(this, "Wybierz kolor", getBackground());
        if (color == null) {
            return;
        }
        
        parent.HeadColor=color;
        }
        
        if(o==ColorBody){
            Color color = JColorChooser.showDialog(this, "Wybierz kolor", getBackground());
        if (color == null) {
            return;
        }
        
        parent.BodyColor=color;
        }
        
        if(o==ColorApple){
            Color color = JColorChooser.showDialog(this, "Wybierz kolor", getBackground());
        if (color == null) {
            return;
        }
        
        parent.AppleColor=color;
        }
        
        if(o==ColorBoard){
            Color color = JColorChooser.showDialog(this, "Wybierz kolor", getBackground());
        if (color == null) {
            return;
        }
        
        parent.BoardColor=color;
        }
    }
    
}
