package cn.xy.importantKnowledge.jdbc.connectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class WorkingThread extends Thread {
    private ConnectionPool cp;

    public WorkingThread(String name, ConnectionPool cp) {
        super(name);
        this.cp = cp;
    }

    public void run() {
        Connection c = cp.getConnection();
        System.out.println(this.getName() + ":\t 获取了一根连接，并开始工作");
        try (Statement st = c.createStatement()) {
            Thread.sleep(1000);
            ResultSet resultSet = st.executeQuery("select * from sys_log");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("查询成功,name为:" + name);
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
        cp.returnConnection(c);
    }
}
