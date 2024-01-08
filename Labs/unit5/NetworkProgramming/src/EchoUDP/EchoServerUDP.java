package EchoUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoServerUDP {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on a specific port
            DatagramSocket serverSocket = new DatagramSocket(9876);
            System.out.println("Server is listening on port 9876...");

            while (true) {
                // Create a byte array to receive data
                byte[] receiveData = new byte[1024];

                // Receive data from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Get client's address and port
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Extract the received message
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedMessage);

                // Send the received message back to the client
                byte[] sendData = receivedMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Sent back to client: " + receivedMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
