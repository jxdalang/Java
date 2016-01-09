/**
* @package jbdc_test
* @author ZS@ZJU
* @version V1.0
*/
package jdbc_test;

import java.sql.*;

/**
* @className JDBCmySQLTest
* @description TODO
* @author ZS@ZJU
* @date Jan 8, 2016 10:57:32 PM
*/
public class JDBCmySQLTest {

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (!conn.isClosed()) // 检查连接是否正常
                System.out.println("Connection established!\n");

            // 执行SQL语句需要用Connection创建一个Statement对象
            Statement stat = conn.createStatement();

            // 执行一次Query，结果存放在ResultSet对象中
            String sql_command = "SELECT * FROM jdbc_test"; // 查询事先建好的测试数据表
            try (ResultSet res = stat.executeQuery(sql_command)) {
                // 打印query结果
                System.out.println("Display query:");
                System.out.println("----------------");
                System.out.println(" ID\t\tNAME\tSEX");
                while (res.next()) {
                    System.out.println(res.getString(1) + "\t" + res.getString(2) + "\t" + res.getString(3));
                }
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Driver not found!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 该方法获取数据库连接
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        // 目标数据库的信息
        String url = "jdbc:mysql://127.0.0.1:3306/t1"; // 数据库地址（使用本地的测试数据库）
        String user = "root"; // 用户名
        String password = "930305"; // 密码

        // 加载数据库驱动类
        String driver = "com.mysql.jdbc.Driver"; // 数据库驱动器类
        Class.forName(driver); // 可能抛出ClassNotFoundException

        // 返回数据库的连接（Connection对象）
        return DriverManager.getConnection(url, user, password); // 可能抛出SQLException
    }

}
