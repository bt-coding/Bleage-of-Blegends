import java.net.*;
public class NetworkObject {
    //public final int PORT = 17752;
    private DatagramSocket socket;
    private InetAddress address;
    private int port;
    private byte[] buf;
    public NetworkObject(String target, int port) {
        try  {
            socket = new DatagramSocket();
            address = InetAddress.getByName(target);
            this.port = port;
        } catch (Exception e) {
            System.out.println("An error has occured while establishing a networked connection");
            e.printStackTrace();
            return;
        }
    }
    public String[] sendData(String data, int expectedResponses) {
        buf = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        try {
            socket.send(packet);
        } catch (Exception e) {
            System.out.println("An error occured while sending a data packet");
            e.printStackTrace();
        }
        if (expectedResponses > 0) {
            String[] responses = new String[expectedResponses];
            for(int i=0;i<expectedResponses;i++) {
                packet = new DatagramPacket(buf, buf.length);
                try {
                    socket.receive(packet);
                } catch (Exception e) {
                    System.out.println("An error occured while getting a packet response");
                    e.printStackTrace();
                }
                String pdata = new String(packet.getData(), 0, packet.getLength());
                responses[i] = pdata;
            }
            return responses;
        } else {
            return new String[0];
        }
    }
}