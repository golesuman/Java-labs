package Circle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CircleServer {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is waiting for client...");

            // Accept a client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Receive radius from client
            double radius = inputStream.readDouble();
            System.out.println("Received radius from client: " + radius);

            // Calculate area
            double area = Math.PI * Math.pow(radius, 2);

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