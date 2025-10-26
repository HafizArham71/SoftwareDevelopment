public class Demo {

    public static void main(String[] args) {

        // ===============================
        //  PRIMITIVE DATA TYPES IN JAVA
        // ===============================

        // ✅ Integers
        int myNum = 12;           // 4 Bytes → Range: -2^31 to 2^31 - 1
        short myNum1 = 13;        // 2 Bytes → Range: -2^15 to 2^15 - 1
        long myNum2 = 123456L;    // 8 Bytes → 'L' or 'l' required at end

        // ✅ Floating-Point Numbers
        float myFloat = 2.4F;     // 4 Bytes → 'F' or 'f' required at end
        double myFloat1 = 5.78;   // 8 Bytes → Default type for decimals

        // ✅ Character
        char ch = 'g';            // 2 Bytes → Unicode character (0–65535)

        // ✅ Boolean
        boolean isAvailable = true;  // 1 Byte → true / false

        // ✅ Byte
        byte myNum3 = 4;          // 1 Byte → Range: -128 to 127


        // ===============================
        //  MEMORY SIZE TRICK (EASY RULE)
        // ===============================
        // byte (1B), short (2B), int (4B), long (8B)
        // float (4B), double (8B)
        // char (2B), boolean (1B)
        //
        //  Pattern: 1 → 2 → 4 → 8
        //  Double pattern repeats for floats.
        // ===============================


        // ===============================
        //  PRINTING VARIABLES
        // ===============================
        System.out.println("int: " + myNum);
        System.out.println("short: " + myNum1);
        System.out.println("long: " + myNum2);
        System.out.println("float: " + myFloat);
        System.out.println("double: " + myFloat1);
        System.out.println("char: " + ch);
        System.out.println("boolean: " + isAvailable);
        System.out.println("byte: " + myNum3);
    }
}
