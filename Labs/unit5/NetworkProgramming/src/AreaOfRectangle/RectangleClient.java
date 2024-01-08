package AreaOfRectangle;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class RectangleClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 8888);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the length of the rectangle: ");
            double length = scanner.nextDouble();
            outputStream.writeDouble(length);
            System.out.println("Sent length to server: " + length);

            System.out.println("Enter Breadth of the rectangle: ");
            double breadth = scanner.nextDouble();
            outputStream.writeDouble(breadth);
            System.out.println("Sent length to server: " + breadth);
            double area  = inputStream.readDouble();
            System.out.println("Area of the rectangle: " + area);
            inputStream.close();
            outputStream.close();
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
