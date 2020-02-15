package cn.xy.importantKnowledge.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
    static Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) {
        // properties形式
        PropertyConfigurator.configure("D:/jetbrainsSoftware/workspace/idea/basic_knowledge/src/cn/xy/importantKnowledge/log4j/log4j.properties");
        for (int i = 0; i < 5000; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }

        // xml形式
        PropertyConfigurator.configure("\"D:/jetbrainsSoftware/workspace/idea/basic_knowledge/src/cn/xy/importantKnowledge/log4j/log4j.xml");
        for (int i = 0; i < 2000; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }

        // 普通形式
        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }
}
