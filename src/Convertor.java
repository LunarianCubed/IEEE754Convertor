public class Convertor {
    /*
        * This is a class that converts a float to it's IEEE 754 binary representation.
     */

    static StringBuilder sb = new StringBuilder();
    static int intBits;
    public static void Convert(double num) {
        if(num < 0){
            sb.append(1);
        }else {
            sb.append(0);
        }
        intBits = (int)num;


        convertFractional(num - intBits);
//        String binary = Integer.toBinaryString(intBits);
//        System.out.println(binary);
    }

    private static void convertInteger(int num, int bias){


    }
    private static void convertFractional(double num){
        double fractional = num;
        while(fractional != 0){
            fractional *= 2;
            if(fractional >= 1){
                sb.append(1);
                fractional -= 1;
            }else{
                sb.append(0);
            }
        }
    }



}
