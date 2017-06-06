/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.*;

/**
 *
 * @author Marcin
 */
public class MyTimerTask extends TimerTask {

    final BoardGame parent;
    
    boolean gameOver=false;

    MyTimerTask(final BoardGame parent) {
        this.parent = parent;
    }

    @Override
    public void run() {
        if (parent.up) {

            parent.repaint();
            parent.MoveArray();
            parent.y_head -= parent.parent.parent.headSize;
            WhenAdd();

            if (parent.y_head < 0) {

                if (parent.parent.parent.SizeBig) {
                    parent.y_head = parent.parent.parent.MaxAreaGame;
                }

                if (parent.parent.parent.SizeMedium) {
                    parent.y_head = parent.parent.parent.MaxAreaGame;
                }
                
                if (parent.parent.parent.SizeSmall) {
                    parent.y_head = parent.parent.parent.MaxAreaGame;
                }

            }

            WhenAdd();
            WhenGameOver();

        }

        if (parent.down) {
            parent.repaint();
            parent.MoveArray();
            parent.y_head += parent.parent.parent.headSize;
            if (parent.x_head == parent.x_apple && parent.y_head == parent.y_apple) {
                parent.Add();
            }

            if (parent.parent.parent.SizeBig) {

                if (parent.y_head > parent.parent.parent.MaxAreaGame) {
                    parent.y_head = 0;
                }

            }
            
            if (parent.parent.parent.SizeMedium) {

                if (parent.y_head > parent.parent.parent.MaxAreaGame) {
                    parent.y_head = 0;
                }

            }
            
            if (parent.parent.parent.SizeSmall) {

                if (parent.y_head > parent.parent.parent.MaxAreaGame) {
                    parent.y_head = 0;
                }

            }

            WhenAdd();
            WhenGameOver();
        }

        if (parent.left) {
            parent.repaint();
            parent.MoveArray();
            parent.x_head -= parent.parent.parent.headSize;
            if (parent.x_head == parent.x_apple && parent.y_head == parent.y_apple) {
                parent.Add();
            }

            if (parent.x_head < 0) {
                if (parent.parent.parent.SizeBig) {
                    parent.x_head = parent.parent.parent.MaxAreaGame;
                }
                
                if (parent.parent.parent.SizeMedium) {
                    parent.x_head = parent.parent.parent.MaxAreaGame;
                }
                
                if (parent.parent.parent.SizeSmall) {
                    parent.x_head = parent.parent.parent.MaxAreaGame;
                }
            }

            WhenAdd();
            WhenGameOver();
        }

        if (parent.right) {
            parent.repaint();
            parent.MoveArray();
            parent.x_head += parent.parent.parent.headSize;
            if (parent.x_head == parent.x_apple && parent.y_head == parent.y_apple) {
                parent.Add();
            }
            if (parent.parent.parent.SizeBig) {
                if (parent.x_head > parent.parent.parent.MaxAreaGame) {
                    parent.x_head = 0;
                }
            }
            
            if (parent.parent.parent.SizeMedium) {
                if (parent.x_head > parent.parent.parent.MaxAreaGame) {
                    parent.x_head = 0;
                }
            }

            if (parent.parent.parent.SizeSmall) {
                if (parent.x_head > parent.parent.parent.MaxAreaGame) {
                    parent.x_head = 0;
                }
            }
            
            WhenAdd();
            WhenGameOver();
        }
    }
    
    public void WhenGameOver(){
        for (int PomLenghtSnake = parent.lenghtSnake; PomLenghtSnake >= 0; PomLenghtSnake--) {

            if (parent.x_head == parent.ArraySnake[PomLenghtSnake].x && parent.y_head == parent.ArraySnake[PomLenghtSnake].y && gameOver==false) {
                parent.GameOver();
                gameOver=true;
            }
    }
    }
    
    public void WhenAdd(){
         if (parent.x_head == parent.x_apple && parent.y_head == parent.y_apple) {
                parent.Add();
            }
        
    }

}
