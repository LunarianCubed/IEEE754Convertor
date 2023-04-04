public class Convertor {
    /*
        * This is a class that converts a float to it's IEEE 754 binary representation.
     */

    static StringBuilder sb32 = new StringBuilder();
    static StringBuilder sb64 = new StringBuilder();
    static int intBits;
    public static void Convert(double num) {
        if(num < 0){
            sb32.append(1);
            sb64.append(1);
            num *= -1;
        }else {
            sb32.append(0);
            sb64.append(0);
        }
        intBits = (int)num;


        convertFractional(num - intBits);
//        String binary = Integer.toBinaryString(intBits);
//        System.out.println(binary);
    }

    private static void convertInteger(int num){
        int remainder32 = 2;
        int remainder64 = 2;
    }
    private static void convertFractional(double num){
        double fractional = num;
        while(fractional != 0){
            fractional *= 2;
            if(fractional >= 1){
                sb32.append(1);
                fractional -= 1;
            }else{
                sb32.append(0);
            }
        }
    }



}
