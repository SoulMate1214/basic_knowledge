package cn.xy.importantKnowledge.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileException {
    String name;
    String path;
    public void notExist1(FileException file) throws MyException1 {
        if (file.name.equals("不存在")){
            throw new MyException1("文件不存在，使用自定义异常类1(继承的FileNotFoundException类)");
        }
    }
    public void notExist2(FileException file) throws MyException2 {
        if (file.name.equals("不存在")){
            throw new MyException2("文件不存在，使用自定义异常类2(继承的Exception类)");
        }
    }
    public void notExist3(FileException file) throws Throwable {
        if (file.name.equals("不存在")){
            throw new FileNotFoundException("文件不存在，直接向FileNotFoundException抛出并携带新信息,throws可以写同种异常类和父级异常类");
        }
    }
    public void notExist4() throws Exception{
        FileException fileException= new FileException();
        File file =new File("\"d:/LOL.exe\"");
        new FileInputStream(file);
    }

    public static void main(String[] args){
        FileException fileException= new FileException();
        fileException.name = "不存在";
        File file =new File("\"d:/soul.exe\"");
        try{
            new FileInputStream(file);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2016-06.03");
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }try {
            fileException.notExist3(fileException);
        }catch (Throwable e) {
            e.printStackTrace();
        }try {
            fileException.notExist4();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fileException.notExist1(fileException);
        }catch (MyException1 e) {
            e.printStackTrace();
        }try {
            fileException.notExist2(fileException);
        }catch (MyException2 e) {
            e.printStackTrace();
        }
    }
}
