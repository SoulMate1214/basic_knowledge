package cn.xy.importantKnowledge.io;

import java.io.*;

public class DataStream {
    public static void main(String[] args) {
        try{
            write();
            read();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void read() throws IOException{
        File f =new File("DataStream.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            boolean b= dis.readBoolean();
            int i = dis.readInt();
            String str = dis.readUTF();

            System.out.println("读取到布尔值:"+b);
            System.out.println("读取到整数:"+i);
            System.out.println("读取到字符串:"+str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void write() throws IOException {
        File f =new File("DataStream.txt");
        f.createNewFile();
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeBoolean(true);
            dos.writeInt(300);
            dos.writeUTF("123 this is gareen");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
