/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

/**
 *
 * @author Marcin
 */
public class BoardGame extends JPanel implements KeyListener {

    final PanelNewGame parent;

    JPanel Koniec;

    Random generator = new Random();

    int GameScore = 0, x_apple, y_apple, x_head, y_head, lenghtSnake = 2;

    boolean right = true, left = false, down = false, up = false;

    BodySnake[] ArraySnake = new BodySnake[2550];

    public BoardGame(final PanelNewGame parent) {

        this.parent = parent;

        this.setLayout(null);
        this.setBounds(0, 60, 795, 795);
        this.setBackground(parent.parent.BoardColor);

        for (int k = 0; k < 2550; k++) {
            ArraySnake[k] = new BodySnake();
        }
        do {
            x_head = generator.nextInt(500 - 300) + 300;
            y_head = generator.nextInt(475 - 275) + 275;
        } while (x_head % parent.parent.headSize != 0 || y_head % parent.parent.headSize != 0);

        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                ArraySnake[j].x = x_head;
                ArraySnake[j].y = y_head + parent.parent.headSize;
            } else {
                ArraySnake[j].x = ArraySnake[j - 1].x;
                ArraySnake[j].y = ArraySnake[j - 1].y + parent.parent.headSize;
            }
        }

        NewApple();
        parent.TextScore.setText(Integer.toString(GameScore));

        Timer timer1 = new Timer();
        MyTimerTask timer1_task = new MyTimerTask(this);
        timer1.schedule(timer1_task, 0, parent.parent.speed);

        parent.add(this);
        setFocusable(true);
        addKeyListener(this);

    }

    public void paint(Graphics h) {

        super.paintComponent(h);
        h.setColor(parent.parent.HeadColor);

        for (int help = x_head; help < x_head + parent.parent.headSize; help++) {
            for (int help2 = y_head; help2 < y_head + parent.parent.headSize; help2++) {
                h.drawLine(help, help2, help, help2);
            }
        }
        int PomLenghtSnake = 0;
        h.setColor(parent.parent.BodyColor);
        try {
            do {
                for (int help = ArraySnake[PomLenghtSnake].x; help < ArraySnake[PomLenghtSnake].x + parent.parent.headSize; help++) {
                    for (int help2 = ArraySnake[PomLenghtSnake].y; help2 < ArraySnake[PomLenghtSnake].y + parent.parent.headSize; help2++) {
                        h.drawLine(help, help2, help, help2);
                    }
                }
                PomLenghtSnake++;
            } while (ArraySnake[PomLenghtSnake].x >= 0);

            h.setColor(parent.parent.AppleColor);
            for (int help = x_apple; help < x_apple + parent.parent.headSize; help++) {
                for (int help2 = y_apple; help2 < y_apple + parent.parent.headSize; help2++) {
                    h.drawLine(help, help2, help, help2);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Blad tablicy: " + PomLenghtSnake + "\n");
        }

    }

    public void NewApple() {

        boolean BodySnake;

        do {

            x_apple = generator.nextInt(parent.parent.MaxAreaGame);
            y_apple = generator.nextInt(parent.parent.MaxAreaGame - 60) + 60;
            BodySnake = false;
            for (int PomLenghtSnake = lenghtSnake; PomLenghtSnake >= 0; PomLenghtSnake--) {

                if (x_apple == ArraySnake[PomLenghtSnake].x && y_apple == ArraySnake[PomLenghtSnake].y) {
                    BodySnake = true;
                }
            }
        } while (x_apple % parent.parent.headSize != 0 || y_apple % parent.parent.headSize != 0 || BodySnake == true);

    }

    public void GameOver() {

        int i = 0, help = -1, help2 = -1;
        boolean HighScore = false;

        parent.remove(parent.Score);
        parent.Score.setText(parent.TextScore.getText());
        parent.remove(this);
        parent.repaint();
        parent.add(parent.Koniec);
        parent.add(parent.Score);
        parent.add(parent.start1);
        parent.add(parent.start2);

        for (i = 0; i < 10; i++) {
            if (parent.parent.ArrayScore[i] < GameScore && HighScore == false) {

                help = parent.parent.ArrayScore[i];

                parent.parent.ArrayScore[i] = GameScore;

                HighScore = true;
            } else {
                if (HighScore) {

                    help2 = help;

                    help = parent.parent.ArrayScore[i];

                    parent.parent.ArrayScore[i] = help2;

                }
            }
        }

        parent.parent.WriteArray();

    }

    public void Add() {
        for (int PomLenghtSnake = lenghtSnake + 1; PomLenghtSnake > 0; PomLenghtSnake--) {
            ArraySnake[PomLenghtSnake].x = ArraySnake[PomLenghtSnake - 1].x;
            ArraySnake[PomLenghtSnake].y = ArraySnake[PomLenghtSnake - 1].y;
        }
        ArraySnake[0].x = x_head;
        ArraySnake[0].y = y_head;
        if (up) {
            y_head -= parent.parent.headSize;
        }
        if (down) {
            y_head += parent.parent.headSize;
        }
        if (left) {
            x_head -= parent.parent.headSize;
        }
        if (right) {
            x_head += parent.parent.headSize;
        }
        NewApple();
        lenghtSnake++;
        GameScore++;
        parent.TextScore.setText(Integer.toString(GameScore));

    }

    public void MoveArray() {

        for (int PomLenghtSnake = lenghtSnake; PomLenghtSnake >= 0; PomLenghtSnake--) {

            if (PomLenghtSnake > 0) {
                ArraySnake[PomLenghtSnake].x = ArraySnake[PomLenghtSnake - 1].x;
                ArraySnake[PomLenghtSnake].y = ArraySnake[PomLenghtSnake - 1].y;
            } else {
                ArraySnake[PomLenghtSnake].x = x_head;
                ArraySnake[PomLenghtSnake].y = y_head;
            }
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP: {

                if (down) {
                    right = false;
                    left = false;
                    down = true;
                    up = false;
                } else {
                    right = false;
                    left = false;
                    down = false;
                    up = true;
                }
                break;
            }

            case KeyEvent.VK_DOWN: {

                if (up) {
                    right = false;
                    left = false;
                    down = false;
                    up = true;
                } else {
                    right = false;
                    left = false;
                    down = true;
                    up = false;
                }

                break;
            }

            case KeyEvent.VK_RIGHT: {

                if (left) {
                    right = false;
                    left = true;
                    down = false;
                    up = false;
                } else {
                    right = true;
                    left = false;
                    down = false;
                    up = false;
                }

                break;
            }

            case KeyEvent.VK_LEFT: {

                if (right) {
                    right = true;
                    left = false;
                    down = false;
                    up = false;
                } else {
                    right = false;
                    left = true;
                    down = false;
                    up = false;
                }

                break;
            }

        }

    }
}
