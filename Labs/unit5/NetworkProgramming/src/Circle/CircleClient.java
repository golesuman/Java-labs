package Circle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class CircleClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the radius of the circle: ");
            double radius = scanner.nextDouble();

            outputStream.writeDouble(radius);
            System.out.println("Sent radius to server: " + radius);

            double area = inputStream.readDouble();
            System.out.println("Received area from server: " + area);

            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
