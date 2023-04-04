public class Convertor {
    /*
        * This is a class that converts a float to it's IEEE 754 binary representation.
     */

    static StringBuilder sb32 = new StringBuilder();
    static StringBuilder sb64 = new StringBuilder();
    static final int BIAS32 = 127;
    static final int BIAS64 = 1023;
    public static void Convertor(double num) {
        int intBits;
        num = signBit(num);
        System.out.println(num);
        intBits = (int)num;
        num = num - intBits;


        int exponent = 0;
        if(intBits >= 1){
            while(intBits > 1){
                intBits /= 2;
                exponent++;
            }
        }
        else if(intBits != 0){
            while(num < 1){
                num *= 2;
                exponent--;
            }
        }
        convertExponent(exponent);
//        convertInteger(intBits);
//        convertFractional(num - intBits);
//        String binary = Integer.toBinaryString(intBits);
//        System.out.println(binary);

        sb32.append(" | ");
        sb64.append(" | ");

        convertMantissa(num, exponent);
        printBinary();


        sb32 = new StringBuilder();
        sb64 = new StringBuilder();
    }

    private static double signBit(double num){
        if(num < 0){
            sb32.append(1);
            sb64.append(1);
            num *= -1;
        }else {
            sb32.append(0);
            sb64.append(0);
        }
        sb32.append(" | ");
        sb64.append(" | ");
        return num;
    }


    private static void convertExponent(int exponent){
        int exponent32 = exponent + BIAS32;
        int exponent64 = exponent + BIAS64;
//        for(int i = 7 ; i >= 0 ; i--){
//            sb32.append((exponent32 & (1 << i)) != 0 ? "1" : "0");
//        }
//        for(int i = 10 ; i >= 0 ; i--){
//            sb64.append((exponent64 & (1 << i)) != 0 ? "1" : "0");
//        }
        sb32.append(decToBin(exponent32, 7));
        sb64.append(decToBin(exponent64, 10));

    }


    private static StringBuilder decToBin(int num, int bits){
        StringBuilder sb = new StringBuilder();
        for(int i = bits; i >= 0 ; i--){
            sb.append((num & (1 << i)) != 0 ? "1" : "0");
        }
        return sb;
    }

    private static StringBuilder fracToBin(double num, int bits){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bits ; i++){
            num *= 2;
            if(num >= 1){
                sb.append(1);
                num -= 1;
            }else{
                sb.append(0);
            }
        }
        return sb;
    }


    private static void convertMantissa(double num, int exponent){
        convertInteger((int)num, exponent - 1);

        sb32.append(" | ");
        sb64.append(" | ");
        convertFractional(num - (int)num, exponent);

    }
    private static void convertInteger(int num, int exponent){
        sb32.append(decToBin(num, exponent));
        sb64.append(decToBin(num, exponent));
    }
    private static void convertFractional(double num, int exponent){
        sb32.append(fracToBin(num, 23-exponent));
        sb64.append(fracToBin(num, 52-exponent));
    }

    private static void printBinary(){
        System.out.println(sb32);
        System.out.println(sb64);
    }



}
