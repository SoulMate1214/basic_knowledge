package cn.xy.importantKnowledge.io;

import java.io.*;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        File file = new File("ByteStream.txt");
        file.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try{
            byte[] newData = { 88, 89 };
            fileOutputStream.write(newData);
            byte[] data =new byte[(int) file.length()];
            fileInputStream.read(data);
            for (byte b : data) {
                System.out.println(b);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            try{
                fileOutputStream.close();
                fileInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
