import javax.swing.*;
import java.awt.*;
public class Display extends JComponent{
    private Game game;
    private int[][] map;
    private int[] screenDimensions;
    private double[] mapViewScale;
    private double[] playerViewScale;
    private int[][] playerView;
    public Display(Game g,int sw,int sh){
        game = g;
        map = game.getMap();
        screenDimensions = new int[]{sw,sh};
        mapViewScale = new double[]{(double)sw/map.length,(double)sh/map[0].length};
        playerViewScale = new double[]{(double)sw/game.playerViewBoxDimensions[0],(double)sh/game.playerViewBoxDimensions[1]};
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
            //playerView = game.playerView;
            playerView = game.getPlayerView();
            //System.out.println(playerView[0][0]);
            double a = game.character.getLoc()[0]-((game.playerViewBoxDimensions[0]+1)/2);
            double b = game.character.getLoc()[1]-((game.playerViewBoxDimensions[1]+1)/2);
            double xBlockShift = (game.character.getLoc()[0]%1)*playerViewScale[0];
            double yBlockShift = (game.character.getLoc()[1]%1)*playerViewScale[1];
            if(a<0){
                a = 0;
                xBlockShift = 0;
            }
            if(b<0){
                b = 0;
                yBlockShift = 0;
            }   
            if(a+game.playerViewBoxDimensions[0] > map.length){
                a = map.length-game.playerViewBoxDimensions[0];
                xBlockShift = 1*playerViewScale[0];
            }
            if(b+game.playerViewBoxDimensions[1] > map[0].length){
                b = map[0].length-game.playerViewBoxDimensions[1];
                yBlockShift = 1*playerViewScale[1];
            }
            for(int x = 0; x < playerView.length; x++){
                for(int y = 0; y < playerView[0].length; y++){
                    if(playerView[x][y] == 0){
                        g.setColor(Color.GREEN);
                    }
                    else if(playerView[x][y] == 1){
                        g.setColor(Color.RED);
                    }
                    else if(playerView[x][y] == 2){
                        g.setColor(Color.ORANGE);
                    }
                    else if(playerView[x][y] == 3){
                        g.setColor(Color.BLUE);
                    }
                    g.fillRect((int)(x*playerViewScale[0])-(int)(xBlockShift),(int)(y*playerViewScale[1])-(int)(yBlockShift),(int)playerViewScale[0]+1,(int)playerViewScale[1]+1);
                }
            }
            g.setColor(new Color(148,0,211));
            g.fillRect((int)((game.character.getLoc()[0]-a-0.5)*playerViewScale[0]),(int)((game.character.getLoc()[1]-b-0.5)*playerViewScale[1]),(int)playerViewScale[0]+1,(int)playerViewScale[1]+1);
            g.setColor(Color.BLACK);
            g.drawString("Player location X: "+game.character.getLoc()[0]+" Y: "+game.character.getLoc()[1],10,10);
            g.drawString("View Box Location X: "+a+" Y: "+b,10,20);
        }
    }
}