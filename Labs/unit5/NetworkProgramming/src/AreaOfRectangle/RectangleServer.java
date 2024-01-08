package AreaOfRectangle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RectangleServer {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Server is waiting for client...");

            // Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Receive radius from client
            double length = inputStream.readDouble();
            System.out.println("Received length from client: " + length);
            double breadth = inputStream.readDouble();
            System.out.println("Received breadth from client: " + breadth);

            // Calculate area
            double area = length * breadth;

            // Send the computed area to the client
            outputStream.writeDouble(area);
            System.out.println("Sent area to client: " + area);

            // Close the streams and sockets
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
