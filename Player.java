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
        loc = new double[]{20,20};
    }
    public double[] getLoc(){
        return loc;
    }
    public void moveV(double m){
        loc[0] += m;
    }
    public void moveH(double m){
        loc[1] += m;
    }
    public double getSpeed(){
        return speed;
    }
}