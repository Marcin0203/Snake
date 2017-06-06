/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics.*;

/**
 *
 * @author Marcin
 */
public class PanelNewGame extends JPanel implements KeyListener {

    final Menu parent;

    JLabel score, start, Koniec, Score, start1, start2;
    JTextArea TextScore;
    JPanel PanelInfo, planszaGry;

    public PanelNewGame(final Menu parent) {

        this.parent = parent;

        this.setLayout(null);
        this.setBounds(0, 0, 795, 855);
        this.setBackground(Color.black);

        score = new JLabel("Punkty: ");
        TextScore = new JTextArea("0");
        PanelInfo = new JPanel();
        start = new JLabel("Naciśnij ENTER aby zacząć gre.");
        Koniec = new JLabel("Koniec Gry. Zdobyte punkty: ");
        start1 = new JLabel("Nacisnij ENTER aby zagrać jeszcze raz,");
        start2 = new JLabel("lub ESC aby wyjść do Menu.");
        Score = new JLabel(TextScore.getText());

        TextScore.setBounds(200, 0, 200, 60);
        TextScore.setFont(new Font("Arial", 0, 50));
        TextScore.setForeground(Color.white);
        TextScore.setBackground(Color.LIGHT_GRAY);
        TextScore.setEditable(false);

        score.setBounds(0, 0, 200, 60);
        score.setFont(new Font("Arial", 0, 50));
        score.setForeground(Color.white);

        start.setBounds(5, 200, 800, 150);
        start.setFont(new Font("Arial", 0, 50));
        start.setForeground(Color.red);

        PanelInfo.setLayout(null);
        PanelInfo.setBounds(0, 0, 795, 60);
        PanelInfo.setBackground(Color.LIGHT_GRAY);

        Koniec.setBounds(5, 100, 700, 150);
        Koniec.setFont(new Font("Arial", 0, 50));
        Koniec.setForeground(Color.red);

        Score.setBounds(700, 100, 100, 150);
        Score.setFont(new Font("Arial", 0, 50));
        Score.setForeground(Color.red);

        start1.setBounds(100, 300, 800, 150);
        start1.setFont(new Font("Arial", 0, 30));
        start1.setForeground(Color.red);

        start2.setBounds(180, 400, 800, 150);
        start2.setFont(new Font("Arial", 0, 30));
        start2.setForeground(Color.red);

        PanelInfo.add(score);
        PanelInfo.add(TextScore);

        add(PanelInfo);
        add(start);

        setFocusable(true);
        addKeyListener(this);

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            this.remove(start);
            this.remove(Koniec);
            this.remove(Score);
            this.remove(start1);
            this.remove(start2);

            Score.setText("");
            PanelInfo.repaint();

            this.repaint();
            planszaGry = new BoardGame(this);
            planszaGry.requestFocus();

        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

            parent.parent.GlownyPanel.removeAll();
            parent.parent.GlownyPanel.repaint();
            parent.parent.GlownyPanel.add(parent.parent.menu);

        }

    }

    public String getTextArea() {

        return TextScore.getText();
    }

}
