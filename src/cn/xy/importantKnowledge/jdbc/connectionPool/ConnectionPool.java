package cn.xy.importantKnowledge.jdbc.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    List<Connection> cs = new ArrayList<Connection>();
    int size;

    public ConnectionPool(int size) {
        this.size = size;
        init();
    }

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_project?useUnicode=true&characterEncoding=utf8", "root", "981214");
                cs.add(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        while (cs.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection connection = cs.remove(0);
        return connection;
    }

    public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }
}
