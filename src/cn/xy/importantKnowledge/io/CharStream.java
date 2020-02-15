package cn.xy.importantKnowledge.io;

import java.io.*;

public class CharStream{
    public static void main(String[] args) throws IOException {
        File file = new File("CharStream.txt");
        file.createNewFile();
        try(FileWriter fileWriter = new FileWriter(file)){
            String data = "3u281jjf890j";
            char[] chars = data.toCharArray();
            fileWriter.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        } try(FileReader fileReader = new FileReader(file)){
            char[] data = new char[(int)file.length()];
            fileReader.read(data);
            for (char a:data){
                System.out.print(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
