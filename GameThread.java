public class GameThread implements Runnable{
    Game game;
    public GameThread(Game g){
        game = g;
    }
    public void run(){
        game.update();
    }
}