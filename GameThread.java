public class GameThread implements Runnable{
    Game game;
    double delay;
    public GameThread(Game g,double d){
        game = g;
        delay = d;
    }
    public void run(){
        game.update(delay);
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}