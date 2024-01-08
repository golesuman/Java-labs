package EchoUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EchoClientUDP {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket
            DatagramSocket clientSocket = new DatagramSocket();

            // Get the server's address
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Get user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message to send to the server: ");
            String messageToSend = scanner.nextLine();

            // Convert the message to bytes
            byte[] sendData = messageToSend.getBytes();

            // Create a DatagramPacket to send to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);

            // Send the packet to the server
            clientSocket.send(sendPacket);
            System.out.println("Sent to server: " + messageToSend);

            // Create a byte array to receive the echoed message
            byte[] receiveData = new byte[1024];

            // Create a DatagramPacket to receive from the server
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive the packet from the server
            clientSocket.receive(receivePacket);

            // Extract the echoed message
            String echoedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + echoedMessage);

            // Close the socket
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
