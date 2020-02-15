package cn.xy.importantKnowledge.io;

import cn.xy.model.Hero;

import java.io.*;

public class ObjectStream {
    public static void main(String[] args) throws IOException {
        Hero hero = new Hero("盖伦", (short) 50, (short) 150, 5000, 0);
        File file = new File("ObjectStream.txt");
        file.createNewFile();
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            FileInputStream fileInputStream =new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ){
            objectOutputStream.writeObject(hero);
            Hero readHero = (Hero) objectInputStream.readObject();
            System.out.println(readHero.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
