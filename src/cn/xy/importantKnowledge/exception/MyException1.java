package cn.xy.importantKnowledge.exception;

import java.io.FileNotFoundException;

public class MyException1 extends FileNotFoundException {
    public MyException1(String msg){
        super(msg);
    }
}
