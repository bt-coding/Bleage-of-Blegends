import java.awt.event.*;
public class Keyboard extends KeyAdapter{
    Game game;
    public Keyboard(Game g){
        game = g;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            game.moving[3] = true;
        }
        if(key == KeyEvent.VK_A){
            game.moving[0] = true;
        }
        if(key == KeyEvent.VK_S){
            game.moving[2] = true;
        }
        if(key == KeyEvent.VK_D){
            game.moving[1] = true;
        }
        if(key == KeyEvent.VK_F){
            game.windowNum = 1;
        }
        if(key == KeyEvent.VK_G){
            game.windowNum = 0;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            game.moving[3] = false;
        }
        if(key == KeyEvent.VK_A){
            game.moving[0] = false;
        }
        if(key == KeyEvent.VK_S){
            game.moving[2] = false;
        }
        if(key == KeyEvent.VK_D){
            game.moving[1   ] = false;
        }
    }
}