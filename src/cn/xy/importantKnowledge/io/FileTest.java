package cn.xy.importantKnowledge.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File f1 = new File("d:/soul");
        System.out.println("f1的绝对路径：" + f1.getAbsolutePath());
        File f2 = new File("LOL.exe");
        System.out.println("f2的绝对路径：" + f2.getAbsolutePath());
        File f3 = new File(f1, "LOL.exe");
        System.out.println("f3的绝对路径：" + f3.getAbsolutePath());
        System.out.println("当前文件是：" +f3);
        System.out.println("判断是否存在："+f3.exists());
        System.out.println("判断是否是文件夹："+f3.isDirectory());
        System.out.println("判断是否是文件："+f3.isFile());
        System.out.println("获取文件的长度："+f3.length());
        System.out.println("获取文件的最后修改时间：" + new Date(f3.lastModified()));
        // rename
        f3.renameTo(f2);

//        File f = new File("demo.txt");
//        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
//        f.list();
//        // 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
//        File[]fs= f.listFiles();
//        // 以字符串形式返回获取所在文件夹
//        f.getParent();
//        // 以文件形式返回获取所在文件夹
//        f.getParentFile();
//        // 创建文件夹，如果父文件夹不存在，创建就无效
//        f.mkdir();
//        // 创建文件夹，如果父文件夹不存在，就会创建父文件夹
//        f.mkdirs();
//        // 创建一个空文件,如果父文件夹不存在，就会抛出异常
//        f.createNewFile();
//        // 所以创建一个空文件之前，通常都会创建父目录
//        f.getParentFile().mkdirs();
//        // 列出所有的盘符c: d: e: 等等
//        f.listRoots();
//        // 刪除文件
//        f.delete();
//        // JVM结束的时候，刪除文件，常用于临时文件的删除
//        f.deleteOnExit();
    }
}
