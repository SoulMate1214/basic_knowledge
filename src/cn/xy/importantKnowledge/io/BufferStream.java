package cn.xy.importantKnowledge.io;

import java.io.*;

public class BufferStream {
    public static void main(String[] args) throws IOException {
        File file = new File("BufferStream.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        BufferedWriter bw = new BufferedWriter(fw);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        try {
            pw.println("我是PrintWriter写入的1");
            pw.println("我是PrintWriter写入的2");
            pw.println("我是PrintWriter写入的3");
            pw.flush();
            bw.write("我是BufferedWriter写入的1");
            bw.newLine();
            bw.write("我是BufferedWriter写入的2");
            bw.newLine();
            bw.write("我是BufferedWriter写入的3");
            bw.newLine();
            bw.flush();

            while (true) {
                String line = br.readLine();
                if (null == line)
                    break;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            fw.close();
            pw.close();
            bw.close();
            fr.close();
            br.close();
        }
    }
}
