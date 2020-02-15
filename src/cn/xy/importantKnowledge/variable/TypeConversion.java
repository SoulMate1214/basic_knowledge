package cn.xy.importantKnowledge.variable;

public class TypeConversion {
    byte byteNumber1 = 1;
    byte byteNumber2 = 1;
    short shortNumber1 = 2;
    short shortNumber2 = 2;
    int intNumber = 3;
    long longNumber = 4L;
    final float floatNumber = 5.5F;
    final double doubleNumber = 6.66D;

    private TypeConversion(){
        // larger needs to be forced into smaller ones
        byteNumber1 = (byte) intNumber;
        // smaller ones can be converted directly to larger ones
        longNumber = intNumber;
        // it is worth noting that the number of bits is lower than that of int type variables,for example:byte,short it will become int during operation by default
        shortNumber1 = (short) (shortNumber1+shortNumber2);
        byteNumber1 = (byte) (byteNumber1+byteNumber2);
    }
}
