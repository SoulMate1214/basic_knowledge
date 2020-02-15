package cn.xy.importantKnowledge.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data 注解会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，如为final属性，则不会为该属性生成setter方法。
@Data
// 分别提供全参构造方法和无参构造方法
@AllArgsConstructor
@NoArgsConstructor
// 链式
@Builder
public class Hero {
    private int id;
    private String name;

    public static void main(String[] args) {
        //传统方式
        Hero h1 = new Hero();
        h1.setId(1);
        h1.setName("garren");
        System.out.println(h1);

        //builder 方式
        Hero h2 =Hero.builder().id(1).name("gareen").build();
        System.out.println(h2);
    }
}