/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcin
 */
public class Menu extends JPanel implements ActionListener {

    final Snake parent;

    JLabel naglowek;
    JButton exit, new_game, settings, highscore;
    JPanel gra = new PanelNewGame(this);
    int ArrayScore[] = new int[10], headSize;
    int speed, MaxAreaGame, MaxLenghtSnake = 2550;
    boolean SizeSmall, SizeMedium, SizeBig, SpeedSlow, SpeedMedium, SpeedFast;
    Color HeadColor, BodyColor, AppleColor, BoardColor;

    public Menu(final Snake parent) {

        this.parent = parent;
        naglowek = new JLabel("SNAKE");
        exit = new JButton("Wyjście");
        new_game = new JButton("Nowa Gra");
        settings = new JButton("Ustawienia");
        highscore = new JButton("Ranking");

        new_game.setBounds(340, 300, 120, 50);
        new_game.addActionListener(this);

        settings.setBounds(340, 400, 120, 50);
        settings.addActionListener(this);

        highscore.setBounds(340, 500, 120, 50);
        highscore.addActionListener(this);

        exit.setBounds(340, 600, 120, 50);
        exit.addActionListener(this);

        naglowek.setBounds(200, 100, 400, 80);
        naglowek.setFont(new Font("SNAKE", Font.BOLD, 100));
        naglowek.setForeground(Color.red);

        this.setLayout(null);
        this.setBounds(0, 0, 795, 855);
        this.setBackground(Color.cyan);
        this.add(naglowek);
        this.add(new_game);
        this.add(settings);
        this.add(highscore);
        this.add(exit);

        ReadArray();
        ReadSettings();
        ReadColor();
        SetSettings();
        

    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == exit) {
            parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));

        }
        if (o == new_game) {

            parent.GlownyPanel.removeAll();
            parent.GlownyPanel.repaint();
            parent.GlownyPanel.add(gra);
            gra.requestFocus();

        }

        if (o == highscore) {

            JPanel highScore = new HighScore(this);

            parent.GlownyPanel.removeAll();
            parent.GlownyPanel.repaint();
            parent.GlownyPanel.add(highScore);

        }

        if (o == settings) {

            JPanel settings = new Settings(this);

            parent.GlownyPanel.removeAll();
            parent.GlownyPanel.repaint();
            parent.GlownyPanel.add(settings);

        }
    }

    public void ReadHighScore(JTextArea textArea) {

        int i = 1;

        try {
            FileReader p = new FileReader("High Score.txt");

            BufferedReader bufferedReader = new BufferedReader(p);

            String textLine = bufferedReader.readLine();

            do {

                textArea.replaceSelection(i + ".  \t" + textLine + "\n");

                textLine = bufferedReader.readLine();

                i++;
            } while (textLine != null);

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        }

    }

    public void ReadArray() {

        File FileThereIs = new File("High Score.txt");

        if (FileThereIs.exists() == false) {
            for (int i = 0; i < 10; i++) {
                ArrayScore[i] = 0;
            }
            WriteArray();
        }
        int i = 0;

        try {
            FileReader fileReader = new FileReader("High Score.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String textLine = bufferedReader.readLine();

            do {

                ArrayScore[i] = (Integer.parseInt(textLine));

                textLine = bufferedReader.readLine();

                i++;
            } while (textLine != null);

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        } catch (NumberFormatException exc) {
            System.out.print("Błędne dane Ranking");

        }

    }

    public void ReadSettings() {

        File FileThereIs = new File("Settings.bin");

        if (FileThereIs.exists() == false) {
            SizeSmall = false;
            SizeMedium = true;
            SizeBig = false;
            SpeedSlow = false;
            SpeedMedium = true;
            SpeedFast = false;
            WriteSettings();
        }

        try {
            DataInputStream bufferedReader = new DataInputStream(new FileInputStream("Settings.bin"));

            this.SizeSmall = (boolean) bufferedReader.readBoolean();
            this.SizeMedium = (boolean) bufferedReader.readBoolean();
            this.SizeBig = (boolean) bufferedReader.readBoolean();
            this.SpeedSlow = (boolean) bufferedReader.readBoolean();
            this.SpeedMedium = (boolean) bufferedReader.readBoolean();
            this.SpeedFast = (boolean) bufferedReader.readBoolean();

            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        } catch (NumberFormatException exc) {
            System.out.print("Błędne dane");

        }

    }

    public void WriteArray() {

        try {

            FileWriter fileWriter = new FileWriter("High Score.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write(Integer.toString(ArrayScore[i]) + "\n");
            }
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku");
        }

    }

    public void WriteSettings() {

        try {

            DataOutputStream bufferedWriter = new DataOutputStream(new FileOutputStream("Settings.bin"));
            bufferedWriter.writeBoolean(SizeSmall);
            bufferedWriter.writeBoolean(SizeMedium);
            bufferedWriter.writeBoolean(SizeBig);
            bufferedWriter.writeBoolean(SpeedSlow);
            bufferedWriter.writeBoolean(SpeedMedium);
            bufferedWriter.writeBoolean(SpeedFast);

        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku");
        }

    }

    public void SetSettings() {
        if (SizeSmall) {
            headSize = 10;
            MaxAreaGame = 740;
        }

        if (SizeMedium) {
            headSize = 25;
            MaxAreaGame = 725;
        }

        if (SizeBig) {
            headSize = 50;
            MaxAreaGame = 700;
        }

        if (SpeedSlow) {
            speed = 350;
        }

        if (SpeedMedium) {
            speed = 150;
        }

        if (SpeedFast) {
            speed = 75;
        }
    }
    
     public void ReadColor() {

        File FileThereIs = new File("Color.obj");

        if (FileThereIs.exists() == false) {
            HeadColor = new Color(255, 150, 60);
            BodyColor = new Color(255, 255, 0);
            AppleColor = Color.red;
            BoardColor = Color.black;
            WriteColor();
        }

        try {
            FileInputStream fileReader = new FileInputStream("Color.obj");
            ObjectInputStream bufferedReader=new ObjectInputStream(fileReader);

            HeadColor =(Color) bufferedReader.readObject();
            BodyColor = (Color) bufferedReader.readObject();
            AppleColor = (Color) bufferedReader.readObject();
            BoardColor = (Color) bufferedReader.readObject();
            
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        } catch (NumberFormatException exc) {
            System.out.print("Błędne dane");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     public void WriteColor() {

        try {

            FileOutputStream fileReader = new FileOutputStream("Color.obj");
            ObjectOutputStream bufferedWriter=new ObjectOutputStream(fileReader);
            bufferedWriter.writeObject(HeadColor);
            bufferedWriter.writeObject(BodyColor);
            bufferedWriter.writeObject(AppleColor);;
            bufferedWriter.writeObject(BoardColor);

        } catch (IOException e) {
            System.out.println("Błąd zapisu do pliku");
        }

    }

}
