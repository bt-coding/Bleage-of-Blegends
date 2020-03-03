public class PacketBuilder {
    private final String seperator = "\\";
    private final String ending = "{E}";
    private final String vLocationUpdate = "PL";
    private final String vHeartbeat = "HB";
    
    public PacketBuilder() {
        
    }
    
    public String userLocationSend(double x, double y) {
        x = roundDouble(x);
        y = roundDouble(y);
        String packet = vLocationUpdate + seperator + x + seperator + y + seperator + ending; 
        return packet;
    }
    
    public String heartbeat() {
        String packet = vHeartbeat + seperator + ending;
        return packet;
    }
    
    private double roundDouble(double n) {
        return (((double)((int)(n*1000)))/1000);
    }
    
    /*packet format:
    variant\data1\data2\data..\
    
    VARIANTS:
    location update - PL
    heartbeat - HB
    
    
    
    */
}