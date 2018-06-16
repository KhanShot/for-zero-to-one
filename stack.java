import java.util.Scanner;
import java.util.Stack;

public class stack{
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.print("Enter Decimal number: ");
        int dec = sca.nextInt();
        Stack<Integer> converted = new Stack<Integer>();
        int i = 0;
        while (dec > 0){
            converted.push(dec%2);
            dec = dec/2;
            i++;
        }
        while (converted.size()!=0){
            System.out.print(converted.pop()+" ");
        }

    }
}