package cn.xy.importantKnowledge.variable;

public class BasicVariable {
    // byte have 8 bit,2^8
    byte byteMinNumber = -128;
    byte byteMaxNumber = 127;

    // short have 16 bit,2^16
    short shortMinNumber = -32768;
    short shortMaxNumber = 32767;

    // int have 32 bit,2^32
    int intMinNumber = -2147483648;
    int intMaxNumber = 2147483647;

    // long have 64 bit,2^64
    long longMinNumber = -9223372036854775808L;
    long longMaxNumber = 9223372036854775807L;

    // float have 32 bit
    float floatMinNumber = -3.4028235E38F;
    float floatMaxNumber = 3.4028235E38F;

    // double have 64 bit
    double doubleMinNumber = -1.7976931348623157e308D;
    double doubleMaxNumber = 1.7976931348623157e308D;

    // only one char
    char aChar = '中';

    // have many charts
    String aString = "中国";

    // only have true(1) or false(0)
    boolean trueBoolean = true;
    boolean falseBoolean = false;

    // Binary,use "0b" begin
    int binary = 0b010101;
    // Octal,use "0" begin
    int Octal = 073;
    // Decimal,normal input
    int Decimal = 92541;
    // Hex,use "0x" begin
    int Hex = 0xAF78;

    // following are the escape characters
    char tab = '\t';
    char carriageReturn = '\r';
    char newLine = '\n';
    char doubleQuote = '\"';
    char singleQuote = '\'';
    char backslash = '\\';
}
