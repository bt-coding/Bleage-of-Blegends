import javax.swing.*;
import java.awt.*;
public class Display extends JComponent{
    private Game game;
    private int[][] map;
    private int[] screenDimentions;
    private double[] mapViewScale;
    private double[] playerViewScale;
    private int[][] playerView;
    public Display(Game g,int sw,int sh){
        game = g;
        map = game.getMap();
        screenDimentions = new int[]{sw,sh};
        mapViewScale = new double[]{(double)sw/map.length,(double)sh/map[0].length};
        playerViewScale = new double[]{(double)sw/game.playerViewBoxDimentions[0],(double)sh/game.playerViewBoxDimentions[1]};
    }
    public void draw(){
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(game.windowNum == 0){
            for(int x = 0; x < map.length; x++){
                for(int y = 0; y < map[0].length;y++){
                    if(map[x][y] == 0){
                        g.setColor(Color.GREEN);
                    }
                    else if(map[x][y] == 1){
                        g.setColor(Color.RED);
                    }
                    else if(map[x][y] == 2){
                        g.setColor(Color.ORANGE);
                    }
                    else if(map[x][y] == 3){
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect((int)(x*mapViewScale[0]),(int)(y*mapViewScale[1]),(int)mapViewScale[0]+1,(int)mapViewScale[1]+1);
                }
            }
        }
        else if(game.windowNum == 1){
            playerView = game.playerView;
            for(int x = 0; x < playerView.length; x++){
                for(int y = 0; y < playerView[0].length; y++){
                    if(map[x][y] == 0){
                        g.setColor(Color.GREEN);
                    }
                    else if(map[x][y] == 1){
                        g.setColor(Color.RED);
                    }
                    else if(map[x][y] == 2){
                        g.setColor(Color.ORANGE);
                    }
                    else if(map[x][y] == 3){
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect((int)(x*playerViewScale[0])-(int)((game.character.getLoc()[0]%1)*playerViewScale[0]),(int)(y*playerViewScale[1])-(int)((game.character.getLoc()[1]%1)*playerViewScale[1]),(int)playerViewScale[0]+1,(int)playerViewScale[1]+1);
                }
            }
            g.setColor(Color.BLACK);
            g.drawString("Player location X: "+game.character.getLoc()[0]+" Y: "+game.character.getLoc()[1],10,10);
        }
    }
}