import java.io.*;
import java.util.Scanner;

public class binarary {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.print("Enter Your Bday without dot (2401999): ");
        Double bday = sca.nextDouble();
        try (
             ObjectOutputStream output =
                       new ObjectOutputStream(new FileOutputStream("object.dat"));
        ) {

            output.writeDouble(bday);
             } catch (IOException e) {
            e.printStackTrace();
        }
////////////////////////////////////////////////////////
        try(ObjectInputStream input =
                    new ObjectInputStream(new FileInputStream("object.dat"));) {

            System.out.println(input.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
