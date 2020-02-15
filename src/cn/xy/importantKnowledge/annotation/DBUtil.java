package cn.xy.importantKnowledge.annotation;

import java.sql.*;

public class DBUtil {
    private static final String url = "jdbc:mysql://localhost:3306/blog_project?useUnicode=true&characterEncoding=utf8";
    private static final String username = "root";
    private static final String password = "981214";
    private static Connection connection;
    private static Statement statement;

    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("反射创建驱动类对象成功");
            // connection.setAutoCommit(false)可以设置关闭自动提交，connection.commit()设置手动提交，达到事务的效果
            // MYSQL 表的类型必须是INNODB才支持事务
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("创建连接对象成功");

            // 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
            DatabaseMetaData dbmd = connection.getMetaData();
            // 获取数据库服务器产品名称
            System.out.println("数据库产品名称:\t" + dbmd.getDatabaseProductName());
            // 获取数据库服务器产品版本号
            System.out.println("数据库产品版本:\t" + dbmd.getDatabaseProductVersion());
            // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
            System.out.println("数据库和表分隔符:\t" + dbmd.getCatalogSeparator());
            // 获取驱动版本
            System.out.println("驱动版本:\t" + dbmd.getDriverVersion());
            System.out.println("可用的数据库列表：");
            // 获取数据库名称
            ResultSet rs = dbmd.getCatalogs();
            while (rs.next()) {
                System.out.println("数据库名称:\t" + rs.getString(1));
            }

            // statement和preparedStatement区别在于防止sql注入，且后者效率高
            // preparedStatement.getGeneratedKeys()可以获取自增长id
            statement = connection.createStatement();
            System.out.println("创建statement执行对象成功");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from sys_log");
            System.out.println("创建PreparedStatement执行对象成功");

            // execute可以执行查询语句然后通过getResultSet，把结果集取出来
            // executeUpdate不能执行查询语句
            // executeQuery只能用于查询
            ResultSet resultSet = statement.executeQuery("select * from sys_log");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("查询成功,name为:" + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
    }
}
