import java.util.Scanner;
import CSC4101Assignment2.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        double num = sc.nextDouble();
          double num;
        num = 16.64;
        Convertor.IEEE754(num);
//
//        System.out.println("num = -73.40");
//        num = -73.40;
//        Convertor.IEEE754(num);

        num = 0.085;
        Convertor.IEEE754(num);
//
        num = 0.00000;
        Convertor.IEEE754(num);

        while(sc.hasNext()){
            num = sc.nextDouble();
            Convertor.IEEE754(num);
        }
    }
}
