package cn.xy.importantKnowledge.jsoup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;

public class Parsing {
    private static void show(Elements es) {
        for (Element e : es) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        String html = "<html><body><p>Hello HTML</p></body></html>";
        Document doc = Jsoup.parse(html);
        Elements as= doc.getElementsByTag("p");
        for (Element e : as) {
            System.out.println(e.text());
        }

        String html1 = "<html><body><p>Hello HTML</p></body></html>";
        Document doc1 = Jsoup.parse(html1);
        System.out.println("基于字符串方式得到的 Document:\r\n"+ doc1);

        File f = new File("D:\\jetbrainsSoftware\\workspace\\idea\\basic_knowledge\\src\\cn\\xy\\importantKnowledge\\jsoup\\demo.html");
        if(f.exists()) {
            Document doc2 = Jsoup.parse(f,"utf-8");
            System.out.println("基于文件方式得到的 Document:\r\n"+ doc2);
            //通过id获取
            Element e = doc2.getElementById("productName");
            System.out.println(e);
            //通过标签获取
            Elements es;
            es = doc2.getElementsByTag("p");
            show(es);
            //通过类名称获取
            es = doc2.getElementsByClass("RightBox");
            show(es);
            //通过属性获取
            es = doc2.getElementsByAttribute("name");
            show(es);
            //获取属性
            System.out.println(e.attr("id"));
            //获取所有属性
            System.out.println(e.attributes());
            //获取id
            System.out.println(e.id());
            //获取类名称
            System.out.println(e.className());
            //获取所有类名称
            System.out.println(e.classNames());
            //获取文本
            System.out.println(e.text());
            //获取html
            System.out.println(e.html());
            //获取外html
            System.out.println(e.outerHtml());
            //获取标签信息
            System.out.println(e.tagName());
        }

//        String url = "http://www.baidu.com";
//        Document doc3 = Jsoup.parse(new URL(url),5000); //超过5秒就报错
//        System.out.println("基于URL方式得到的 Document:\r\n"+ doc3);
    }
}
