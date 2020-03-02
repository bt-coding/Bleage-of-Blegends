public class GameRateUpdater implements Runnable{
    int fps;
    Game game;
    public GameRateUpdater(int f, Game g){
        fps = f;
        game = g;
    }
    public void run(){
        while(true){
            new Thread(new GameThread(game,(1000.0/fps)/1000.0)).start();
            try{
                Thread.sleep(1000/fps);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}