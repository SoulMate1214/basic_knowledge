package cn.xy.importantKnowledge.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * jdk8以前的写法
         * 编码和解码的效率⽐较差，公开信息说以后的版本会取消这个⽅法
         */
        BASE64Encoder encoder = new BASE64Encoder();
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] textByte = "敷衍三连，哦，牛批，666".getBytes("UTF-8");
        //编码
        String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);//5Zyj6a2U5a+85biI
        //解码
        System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));//圣魔导师

        /**
         * jdk8的写法
         * 编解码销量远⼤于 sun.misc 和 Apache Commons Codec，可以自己动手压测一下速度
         */
        Base64.Decoder decoder2 = Base64.getDecoder();
        Base64.Encoder encoder2 = Base64.getEncoder();
        byte[] textByte2 = "敷衍三连，哦，牛批，666".getBytes("UTF-8");
        //编码
        String encodedText2 = encoder2.encodeToString(textByte2);
        System.out.println(encodedText);//5Zyj6a2U5a+85biI
        //解码
        System.out.println(new String(decoder2.decode(encodedText2), "UTF-8"));//圣魔导师
    }
}
