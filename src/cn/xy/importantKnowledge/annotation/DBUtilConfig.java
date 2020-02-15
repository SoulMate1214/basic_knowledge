package cn.xy.importantKnowledge.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

// 元注解
// 作用域注解：表示这个注解可以用在什么上面
@Target({METHOD, TYPE, FIELD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE})

// 生命周期注解：表示注解可以维持多久
// RetentionPolicy.SOURCE： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
// RetentionPolicy.CLASS： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显式指定@Retention的时候，就会是这种类型。
// RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解@JDBCConfig 就是这样
@Retention(RetentionPolicy.RUNTIME)

// 继承注解：表示这个注解可以被子类继承
@Inherited

// 文档注解：表示当执行javadoc的时候，本注解会生成相关文档。在用javadoc命令生成API文档后，DBUtil的文档里会出现该注解说明
@Documented
public @interface DBUtilConfig {
    String ip();

    int port() default 3306;

    String database();

    String encoding();

    String loginName();

    String password();
}
