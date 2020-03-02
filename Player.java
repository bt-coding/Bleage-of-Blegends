public class Player{
    private double[] loc;
    private double health;
    private double maxHealth;
    //m/s
    private double speed;
    public Player(){
        speed = 2;
        maxHealth = 100;
        health = maxHealth;
    }
}