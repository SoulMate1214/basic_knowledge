package cn.xy.importantKnowledge.hutool;
import java.util.Date;

import cn.hutool.core.date.DateUtil;

public class hutoolDemo {
    public static void main(String[] args) {
        String dateStr = "2012-12-12 12:12:12";
        Date date = DateUtil.parse(dateStr);
        System.out.println(date);
    }
}
