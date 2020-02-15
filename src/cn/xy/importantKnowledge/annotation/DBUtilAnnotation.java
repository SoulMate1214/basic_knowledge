package cn.xy.importantKnowledge.annotation;
import java.sql.*;

@DBUtilConfig(ip = "127.0.0.1", database = "blog_project", encoding = "UTF-8", loginName = "root", password = "981214")
public class DBUtilAnnotation {
    private static Connection connection;
    private static Statement statement;

    public DBUtilAnnotation() {
        try {
            // 获取注解对象
            DBUtilConfig config = DBUtilAnnotation.class.getAnnotation(DBUtilConfig.class);
            String ip = config.ip();
            int port = config.port();
            String database = config.database();
            String encoding = config.encoding();
            String loginName = config.loginName();
            String password = config.password();
            String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, loginName, password);
            statement = connection.createStatement();
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
        DBUtilAnnotation dbUtilAnnotation = new DBUtilAnnotation();
    }
}
