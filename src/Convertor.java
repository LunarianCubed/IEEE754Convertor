public class Convertor {
    /*
        * This is a class that converts a float to it's IEEE 754 binary representation.
     */
    public static void Convert(float num) {
        int intBits = Float.floatToIntBits(num);
        String binary = Integer.toBinaryString(intBits);
        System.out.println(binary);
    }

    StringBuilder sb = new StringBuilder();
    

}
